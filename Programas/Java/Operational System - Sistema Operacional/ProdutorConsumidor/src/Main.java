import java.util.concurrent.Semaphore;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Semaphore s_produtor = new Semaphore(1);
		Semaphore s_comsumidor = new Semaphore(0);
		
		Buffer b = new Buffer(0);
		Produtor p = new Produtor(b,s_produtor,s_comsumidor);
		Consumidor c = new Consumidor(b,s_produtor,s_comsumidor);

		
		p.start();
		c.start();
		
		try {
			c.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
