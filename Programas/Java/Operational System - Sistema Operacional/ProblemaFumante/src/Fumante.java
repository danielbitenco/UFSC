import java.util.Random;
import java.util.concurrent.Semaphore;

public class Fumante extends Thread {

	Semaphore sAgente;
	Semaphore sFumante;
	Insumos i;
	Random r;
	int quemFuma;
	String[] s = {"PAPEL", "FOSFORO", "FUMO"};
	
	public Fumante (Semaphore sFumante, Semaphore sAgente,  Insumos i){
		this.sAgente = sAgente;
		this.sFumante = sFumante;
		this.i = i;
		r = new Random();
	}
	
	public void run(){
		
		while(true){
			
			try {
				sAgente.acquire();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			switch (quemFuma = r.nextInt(3)){ 
			
			case 0:
				if ((i.getInsumos()[0]>0) && i.getInsumos()[1]>0){
					i.getInsumos()[0]-=1;
					i.getInsumos()[1]-=1;
					System.out.println("Fumante "+quemFuma +" fumando");
					System.out.println(s[0]+" "+i.getInsumos()[0]);
					System.out.println(s[1]+" "+i.getInsumos()[1]);
					System.out.println(s[2]+" "+i.getInsumos()[2]);
				}
			break;
			
			case 1:
				if ((i.getInsumos()[0]>0) && i.getInsumos()[2]>0){
					i.getInsumos()[0]-=1;
					i.getInsumos()[2]-=1;
					System.out.println("Fumante "+quemFuma+" fumando");
					System.out.println(s[0]+" "+i.getInsumos()[0]);
					System.out.println(s[1]+" "+i.getInsumos()[1]);
					System.out.println(s[2]+" "+i.getInsumos()[2]);
				}
			break;
			
			case 2:
				if ((i.getInsumos()[1]>0) && i.getInsumos()[2]>0){
					i.getInsumos()[1]-=1;
					i.getInsumos()[2]-=1;
					System.out.println("Fumante "+quemFuma+" fumando");
					System.out.println(s[0]+" "+i.getInsumos()[0]);
					System.out.println(s[1]+" "+i.getInsumos()[1]);
					System.out.println(s[2]+" "+i.getInsumos()[2]);
				}
			break;

			}
			
			sAgente.release();
			try {
				sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
}
