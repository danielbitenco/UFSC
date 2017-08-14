package org.ufsc.sd;

public class NewClass implements Runnable {

	private int id;
	
	public NewClass(int id) {
		setId(id);
	}
	
	
	@Override
	public void run() {
		System.out.println("ola "+ this.id);
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	
}
