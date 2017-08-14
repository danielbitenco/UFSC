import java.util.concurrent.Semaphore;

public class Consumidor extends Thread {
	
	Buffer b;
	Semaphore s_produtor;
	Semaphore s_consumidor;
	
	public Consumidor (Buffer b,Semaphore s_produtor, Semaphore s_consumidor){
		this.b = b;
		this.s_consumidor = s_consumidor;
		this.s_produtor = s_produtor;
	}
	
	public void run(){
		while(true){
			try {
				s_consumidor.acquire(); //operacao P()
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			System.out.println("Li o valor " +b.leBuffer());
			
			//s_produtor.release(); // operacao V()
			try {
				sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
