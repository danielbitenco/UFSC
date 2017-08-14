package trabprog;



public class Principal {
	public static void main(String[] args){
	
	//Variaveis classe
	ListaEncadeada circular = new ListaEncadeada();
	 
	 for(int i = 0; i < 10; i++){
	 	circular.Create(i); //Cria a lista com 1 elemento, usando a variavel i, que no caso, 0
	 } 

	 /* Abaixo começando a lista com apenas o 0, e o usuario vai criando a lista
		 
	 for(int i = 0; i < 1; i++){
	 	circular.Create(i); //Cria a lista com 1 elemento, usando a variavel i, que no caso, 0
	 } 
	*/

	circular.proximoNo(); //Para começar a lista com o "primeiro" inserido, que no caso, é o 0	
	
	//Menu
	while(true){
		//Opcoes Menu
		System.out.println("---------------------------------------------------------------------------------------------");
		System.out.println("Insira a operação que você deseja fazer");
		System.out.println("1- Mostrar lista encadeada");
		System.out.println("2- Adicionar item");
		System.out.println("3- deletar item");
		System.out.println("4- alterar item");
		System.out.println("5- sair");
		int escolha = circular.TryValorError(); //Variavel que vai receber opcao menu e se n for a exata, ira tratar o erro		
		System.out.println("---------------------------------------------------------------------------------------------");
		
		//Condicionais do menu
		if (escolha == 1){
			circular.Retrieve(); //Imprime a lista
		}
		
		else if (escolha == 2){
			System.out.println("Insira o novo item");
			int novo = circular.TryValorError(); //Se n for um elemento do tipo int, ira tentar converter, se n der, retornara mensagem de erro
			circular.Create(novo); //Vai inserir um novo elemento na lista			
		}
			
		else if (escolha == 3){
			System.out.println("Insira o que desejas deletar");
			int deletar = circular.TryValorError(); //Se n for um elemento do tipo int, ira tentar converter, se n der, retornara mensagem de erro
			circular.Delete(deletar); //Deleta o elemento que o usuario digitou (se estiver na lista)
		}
			
		else if (escolha == 4){
			System.out.println("Insira qual você deseja alterar");
			int alterandoEste = circular.TryValorError(); //Se n for um elemento do tipo int, ira tentar converter, se n der, retornara mensagem de erro
			System.out.println("Insira o novo valor");
			int porEste = circular.TryValorError(); //Se n for um elemento do tipo int, ira tentar converter, se n der, retornara mensagem de erro
			circular.Update(alterandoEste,porEste); //Altera o novo valor que o usuario digitou pelo valor antigo
		}

		else if (escolha == 5){
			System.out.println("Até mais piratinha <3 "); //<3
			break; //Sai do menu
		}

		else System.out.println("Esta opção não existe"); //Imprime um que a opcao nao existe, caso o usuario digite um elemento fora das opcoes do menu
		} 				
	}
}