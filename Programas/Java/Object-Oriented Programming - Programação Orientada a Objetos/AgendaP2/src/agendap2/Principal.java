package agendap2;

import java.util.Scanner;


public class Principal {

    private static int numeroCelula = 1;

    public static void main(String[] args) {
        
        Celula cel = new Celula(0,null,""); //indica que a primeira celula está vazia

        while (true){ //while laço de repetição para o menu, equanto a opçao for valida ele continua rodando;
            switch (menu()) { //Isso tá errado, o switch precisa receber algo pra validar nos cases
                case 1:
                    //inclui(); 
                    addCelula(cel);
                    
                    break;                
                case 2:
                    consulta();
                    break;                    
                case 3:
                    altera();
                    break;                    
                case 4:
                    exclui();
                    break;                    
                default:
                    System.out.println("Opção inválida");
            }

        }

    }

    public static void inclui(){
        System.out.println("Você entrou no método Incluir");
        
    }
    
    public static void consulta(){
       System.out.println("Você entrou no método Consultar");
       
    } 
    
    public static void altera(){
        System.out.println("Você entrou no método Alterar");
    }
    
    public static void exclui(){
        System.out.println("Você entrou no método Excluir");
    }
    
   //criando as opçoes do menu
    static int menu() {
        System.out.println("\tCadastro ");
        System.out.println("1- Incluir");
        System.out.println("2- Consultar");
        System.out.println("3- Alterar");
        System.out.println("4- Excluir");
        System.out.println("Opção: ");
        
       //lê as opçoes inseridas anteriormente
        Scanner sc = new Scanner(System.in);
        int entrada = sc.nextInt();
        return entrada;
    }
    
      
     public static void addCelula(Celula c) {
        //Celula nova = new Celula(1,c,"ss");
        Celula aux;
        
        if (c.getProximaCelula() == null) {
            c.setId(numeroCelula);
            c.setNome("primeiro");
            c.setProximaCelula(c);
            numeroCelula++;

        } else {
            aux = encontraUltimaCelula(c);
            Celula nova = new Celula(numeroCelula,c,"ultimaAdd");
            aux.setProximaCelula(nova);
            numeroCelula++;
        }
    }

    public static Celula encontraUltimaCelula(Celula c) {
        int primeiraCelula = c.getId();
        int maior = 0;
        Celula aux = c;
        Celula aux2 = aux;

        while (primeiraCelula > maior) {
            maior = primeiraCelula;
            aux2 = aux;
            aux = aux.getProximaCelula();
            primeiraCelula = aux.getId();
        }
        return aux2;
    }
	
	// Criamos um mÃ©todo para poder encontrar a celula anterior da desejada
    public static Celula encontrarCelulaAnterior (Celula c, String n){
        String nux = c.getNome(); 
	Celula aux = c;
        Celula aux2 = aux;
        // enquanto a string desejada for diferente de "n", recebera a proxima celula
        while (!nux.equals(n)) { 
        
            aux2 = aux;
            aux = aux.getProximaCelula();
            nux = aux.getNome();
        }
        return aux2;
    }

        //Criando a funÃ§Ã£o que irÃ¡ remover o contato da lista.
    public static void removeCelula(Celula c, String n) { 
             //criando a auxiliar "ant" que serÃ¡ a celula anterior da desejada
            Celula ant = encontrarCelulaAnterior(c,n);
            // quando excluir a celula atual, a anterior irÃ¡ pegar a proxima da excluida para substituir
            ant.setProximaCelula(ant.getProximaCelula().getProximaCelula()); 

    }
	
	//funÃ§Ã£o para consultar, verificar se o elemento estÃ¡ contido na lista.
    public static void consultaCelula(Celula c, String n){
        Celula ant = encontrarCelulaAnterior(c,n);

        ant = ant.getProximaCelula();

        System.out.println(ant.getId()+ "  "+ant.getNome());
    }
        
        //funÃ§Ã£o para poder alterar a celula
        
    public static void alterarCelula(Celula c, String n){
            Celula ant = encontrarCelulaAnterior(c,n);
            
            ant = ant.getProximaCelula();
            
            System.out.println(ant.getId()+ "  "+ant.getNome());
            //irÃ¡ ler o novo novo que deseja substituir
            Scanner ler = new Scanner(System.in);
            
            String novoNome = ler.next();
            //atribuindo o novo nome na celula
            ant.setNome(novoNome);
            
            System.out.println(novoNome);
	}
}
