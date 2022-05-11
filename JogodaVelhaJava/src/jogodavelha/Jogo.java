package jogodavelha;

import java.util.Scanner;

public class Jogo {
	
// Declaração de metodos atributos privados 
    private Tabuleiro tabuleiro;
    private int partida=1, vez=1;
    private Jogador jogador1;
    private Jogador jogador2;
    
//Declaração de metodos atributos público
    public Scanner entrada = new Scanner(System.in);
    public Scanner coleta = new Scanner(System.in);
    
    
    public Jogo(){
/*O metodo está sendo iniciado na Classe Tabuleiro   
  Declaração das variáveis e instanciamentos dos objetos para iniciar o jogo  
  O metodo invoca o metodo iniciarJogadores 
 
*/
        tabuleiro = new Tabuleiro();
        iniciarJogadores();
        
        while( Jogar() );
    }
 



	public void iniciarJogadores(){
		
/*Obrigado pela ajuda. 
 * 
 * após instanciar "escolherJogador na variavel 'escolha'"
 * a estrutura if/else funcionou corretamente onde não 
 * tinha enxergado que chamava repetidas vezes o mesmo
 * metodo	
 * 	
 */
		
    	
        System.out.println("Escolha o jogador 1 ?");
        System.out.println(" ");
        
        int escolha = escolherJogador();
        
       if(escolha == 1)        	
            this.jogador1 = new Humano(1);
       	      
        else if (escolha == 2) 
        	this.jogador1 = new Computador(1);
    	 
        else if (escolha == 3)
       		this.jogador1 = new ComputadorLone(1);
      		
       	else        
       		this.jogador1 = new ComputadorLtwo(1);
 
       

                 
        System.out.println("----------------------");
        System.out.println(" ");
        System.out.println("Escolha o jogador 2 ?");
        
        
        escolha = escolherJogador();
        
        
        if(escolha == 1)        	
            this.jogador2 = new Humano(2);
       	      
        else if (escolha == 2) 
        	this.jogador2 = new Computador(2);
    	 
        else if (escolha == 3)
       		this.jogador2 = new ComputadorLone(2);
      		
       	else
       		this.jogador2 = new ComputadorLtwo(2);
 
       
    }
/* 
 * 
 * Utilizando o Metodo Scanner para selecionar os jogadores 
 * Métodos definidos dentro das classes Humano  e Computador 
 * Tratamento de erro para a digitação e escolha do jogador  
 */   
    public int escolherJogador(){
    	
       int opcao = 0;
    
        do{
            System.out.println("1. Homem 1\n");
            System.out.println("2. Computador, nivel 1\n");
            System.out.println("3. Computador, nivel 2\n");
            System.out.println("4. Computador, nivel 3\n");
            
            System.out.print("Opção: ");
            opcao = entrada.nextInt();
            
           System.out.println("A opção escolhida foi: \n" +opcao);
            
           if(opcao != 1 && opcao != 2 && opcao != 3 && opcao != 4 )
        	   
                System.out.println("Entrada inválida! Tente novamente");
           
           
        }while(opcao != 1 && opcao != 2 && opcao != 3 && opcao != 4 );
        
        return opcao;
    }
    
    
    
    public boolean Jogar(){
        if(venceu() == 0 ){
            System.out.println("----------------------");
            System.out.println("\npartida "+partida);
            System.out.println("É a vez do jogador " + vez() );
            
            if(vez()==1)
                jogador1.jogar(tabuleiro);
            else
                jogador2.jogar(tabuleiro);
               
            
            if(tabuleiro.tabuleiroCompleto()){
                System.out.println("Fechou e ninguêm venceu. Jogo empatado");
                return false;
            }
            vez++;
            partida++;

            return true;
            
        } else{
            if(venceu() == -1 )
                System.out.println("Jogador 1 venceu!");
            else
                System.out.println("Jogador 2 venceu!");
            
            return false;
        }
            
    }
    
    public int vez(){
        if(vez%2 == 1)
            return 1;
        else
            return 2;
    }
    
    
    
    
// Fazendo a checagem da matriz 3x3 linha & colunas    
    public int venceu(){
        if(tabuleiro.checaLinhas() == 1)
            return 1;
        if(tabuleiro.checaColunas() == 1)
            return 1;
        if(tabuleiro.checaDiagonais() == 1)
            return 1;
        
        if(tabuleiro.checaLinhas() == -1)
            return -1;
        if(tabuleiro.checaColunas() == -1)
            return -1;
        if(tabuleiro.checaDiagonais() == -1)
            return -1;
        
        return 0;
    }
    
    
}
