
public class Buffer {
	
	int valor;
	
	public Buffer(int valor){
		this.valor = valor;
	}
	
	public void escreveBuffer(int valor){
		this.valor = valor;
	}
	
	public int leBuffer(){
		return this.valor;
	}

}
