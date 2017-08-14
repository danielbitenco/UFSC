import java.util.Random;
import java.util.concurrent.Semaphore;

public class Produtor extends Thread{
	
	Buffer b;
	Random r;
	Semaphore s_produtor;
	Semaphore s_consumidor;
	
	public Produtor(Buffer b, Semaphore s_produtor, Semaphore s_consumidor){
		this.b = b;
		this.s_produtor = s_produtor;
		this.s_consumidor = s_consumidor;
		r = new Random();
	}
	
	public void run(){
		while (true){
			int valor  = r.nextInt(500);
			System.out.println("Produzi o valor: " + valor);
			try {
				s_produtor.acquire();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			b.escreveBuffer(valor);
			s_consumidor.release();
			try {
				sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
