package trabprog;

public class NoFila{

	//Variaveis da classe
	private NoFila proximo; //Definindo a variavel que ira armazena um objeto no fila para armazenar o proximo
	private int id; //passando o id deste elemento
	
	
	//Setters e Getters
	public void setProximo(NoFila proximo){ //Passa o parametro para a variavel proximo
		this.proximo = proximo;
	}
	
	public void setId(int id){ //Passa o parametro para a variavel id
		this.id = id;
	}
	
	public NoFila getProximo(){ //Retorna valor variavel proximo
		return this.proximo;
	}
	
	public int getId(){ //Retorna valor variavel proximo
		return this.id;
	}
	
}



