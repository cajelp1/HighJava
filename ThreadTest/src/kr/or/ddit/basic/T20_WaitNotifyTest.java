package kr.or.ddit.basic;

public class T20_WaitNotifyTest {
	public static void main(String[] args) {
		DataBox databox = new DataBox();
		
		ProducerThread pth = new ProducerThread(databox);
		ConsumerThread cth = new ConsumerThread(databox);
		
		pth.start();
		cth.start();
	}
}


// 데이터를 공통으로 사용하는 클래스
class DataBox{
	private String data;
	
	//data가 null이 아닐때 data값을 반환하는 메서드
	public synchronized String getData() {
		if(data == null) {
			try {
				System.out.println("----getWait");
				wait();
			}catch(InterruptedException e) {e.printStackTrace();}
		}
		
		String returnData = data;
		System.out.println("읽어온 데이터 : "+returnData);
		data = null;
		System.out.println(Thread.currentThread().getName() + " nofity()호출");
		notify();
		
		return returnData;
	}
	
	// data가 null일 경우에만 자료를 세팅하는 메서드
	public synchronized void setData(String data) {
		if(this.data != null) {
			try {
				System.out.println("----setWait");
				wait();
			}catch(InterruptedException e) {e.printStackTrace();}
		}
		
		this.data = data;
		System.out.println("세팅한 데이터 : " + this.data);
		System.out.println(Thread.currentThread().getName() + " nofity()호출");
		notify();
		
	}
}

// 데이터를 세팅만 하는 쓰레드
class ProducerThread extends Thread {
	private DataBox dataBox;
	
	public ProducerThread(DataBox databox) {
		super("ProducerThread");
		this.dataBox = databox;
	}
	
	@Override
	public void run() {
		for(int i = 1; i<=10; i++) {
			String data = "Data-" + i;
			System.out.println("dataBox.setData() : "+data);
			
			dataBox.setData(data);
		}
	}
}

//데이터를 읽어만 오는 쓰레드
class ConsumerThread extends Thread{
	private DataBox dataBox;
	
	public ConsumerThread(DataBox dataBox) {
		super("ConsumerThread");
		this.dataBox = dataBox;
	}
	
	@Override
	public void run() {
		for(int i = 1; i<=10; i++) {
			String data = dataBox.getData();
			System.out.println("data.getData() : "+ data);
		}
	}
}




