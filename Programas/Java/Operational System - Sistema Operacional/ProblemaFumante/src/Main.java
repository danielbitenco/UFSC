import java.util.concurrent.Semaphore;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] in = {0,0,0};
		Semaphore sAgente = new Semaphore(1);
		Semaphore sFumante = new Semaphore(0);
		Insumos i = new Insumos(in);
		Fumante f = new Fumante(sFumante,sAgente,i);
		Agente a = new Agente (sFumante,sAgente,i);
		
		f.start();
		a.start();
		
		try {
			a.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
	}

}
