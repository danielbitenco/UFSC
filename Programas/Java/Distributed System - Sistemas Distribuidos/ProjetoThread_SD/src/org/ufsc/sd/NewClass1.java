package org.ufsc.sd;

public class NewClass1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		for (int i = 0; i < 10; i++) {
			NewClass classe = new NewClass(i);
			Thread t = new Thread(classe);
			t.start();
		}
		
	
		
	}

}
