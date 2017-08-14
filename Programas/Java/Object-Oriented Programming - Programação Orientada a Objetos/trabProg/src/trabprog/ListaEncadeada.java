package trabprog;

import java.util.Scanner;
public class ListaEncadeada{
	Scanner lendo = new Scanner(System.in);

	//Variaveis da classe
	private NoFila no; //Criando variavel de armazenamento de NoFila
	private int contador = 0; //Variavel contador
	
	public ListaEncadeada(){  //Construtor da lista encadeada
		no = null;
		contador = 0;
	}
	
	//Getters e Setters
	public int qtdNo(){ //Quantidade no (contador)
		return contador;
	}
	
	public NoFila getNo(){ //Retorna no atual
		return this.no;
	}
	
	public void setNo(NoFila no){ //Passa o parametro para a variavel
		this.no = no;
	}
	
	public void proximoNo(){ //Indica o proximo no apontado pelo atual
		no = no.getProximo();
	}
	
	public void novoNo(NoFila no){ //cria novo no e ja seta o no anterior para o atual
		if (this.no == null){
			no.setProximo(no);
			this.no = no;
		}
	
		else{
			no.setProximo(this.no.getProximo());
			this.no.setProximo(no);	
			this.no = no;	
		}
		this.contador = contador+1;
	}
	
	public void Retrieve(){ //Imprime a lista
		int contador = 0;
		
		while(contador != this.contador){
			System.out.println(getNo().getId());
			proximoNo();
			contador++;		
		}
	}
	
	public void Delete(int numero){ //Deleta o elemento que o usuario escolher
				boolean estaNaLista = false;
				for(int i= 0; i < this.contador; i++){
					NoFila anterior = getNo();
					proximoNo();
				if (numero == getNo().getId()){
					anterior.setProximo(this.no.getProximo());
					setNo(anterior);
					this.contador = this.contador - 1;	
				}				
			}
			if (estaNaLista == false) {
				System.out.println("Não tem este item na lista");
			}
		}
		
	public void Update(int numero,int novoNumero){ //troca o valor antigo pelo novo que o usuario escolheu
				boolean estaNaLista = false;
				int contador = 0;
				while(contador != this.contador){
					if (numero == getNo().getId()){
						getNo().setId(novoNumero);					
						estaNaLista = true;
						break;
					}
					proximoNo();
					contador++;
			}
			if (estaNaLista == false) {
				System.out.println("Não tem este item na lista");
		}
	}
	
	public void Create(int id){ //Cria novo no
		NoFila no = new NoFila();
	 	no.setId(id);
	 	novoNo(no);
	
	}

	public int TryValorError(){ //Metodo para tratamento de erro
		while(true){
			String variavel = lendo.nextLine();
			try{ //Entra o elememento que o usario digitou e verifica se eh do tipo que desejamos, no caos um int, e tenta a conversao
				Integer num = new Integer(variavel);
				return num;
			}
			catch (NumberFormatException nfc){ //Caso o comentario anterior nao funcione, eh enviado uma mensagem de erro
			System.out.println("Erro, digite um número por favor.");
			}
		}
	}
}