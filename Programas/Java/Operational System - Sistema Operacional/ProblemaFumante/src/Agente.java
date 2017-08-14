import java.util.Random;
import java.util.concurrent.Semaphore;

public class Agente extends Thread{

	Semaphore sAgente;
	Semaphore sFumante;
	Insumos i;
	Random r;
	
	public Agente (Semaphore sFumante, Semaphore sAgente, Insumos i){
		this.sAgente = sAgente;
		this.sFumante = sFumante;
		this.i = i;
		r = new Random();
	}
	
	public void run(){
		
		while(true){
			int prod = r.nextInt(3);
			int prod2 = r.nextInt(3);

			try {
				sAgente.acquire();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			i.getInsumos()[prod]+=1;
			
			while ((prod2 = r.nextInt(3)) == i.getInsumos()[prod]);
			
			i.getInsumos()[prod2]+=1;
			
			sAgente.release();//sFumante.release();
			//System.out.println("\n PRODUZIU \n");
			try {
				sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
	}
	
	
}
