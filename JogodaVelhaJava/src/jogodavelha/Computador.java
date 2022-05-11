package jogodavelha;

import java.util.Random;
import java.util.Scanner;

public class Computador extends Jogador{
	
	/* Inseri nesta instancia o Random para gerar as jogadas 
	 * automáricas do computador de forma aleatoria
	 * estou tentando implementar utilizando MINIMAX	
	 * A Classe Computador está recebendo  a classe Jogador 
	*/
	public Scanner opcao= new Scanner(System.in);
	
	
	Random cpuAi = new Random();   
    public Computador(int jogador){
        super(jogador);
        System.out.println("O computador nivel 1 está On Line!");
        System.out.println("Você está jogando com o Jasper!");       
    }  
	@Override
 
    public void jogar(Tabuleiro tabuleiro){
        Tentativa(tabuleiro);
        tabuleiro.setPosicao(tentativa, jogador);
    
    }
  /* Override, Indica que uma declaração de método se destina a substituir
    uma declaração de método em um supertipo. Se um método é anotado
    com este tipo de anotação, compiladores são necessários para gerar
    uma mensagem de erro, a menos que pelo menos uma das seguintes condições seja válida: 
 */  
    
    
       @Override
        public void Tentativa(Tabuleiro tabuleiro){    	   
        do{
            do{
            	
            	
/* Inclui na linha abaixo cpuAi.nextInt para contar aleatoriamente até 3           	
 * para linha e coluna na matriz 3x3 fazendo assim a jogada automatica
 * chama a função que analisa se a jogada é permitida e retorna um valor boolean que
 *  controla o laço de repetição de todo o método
 * 
 */
                System.out.print("Linha: ");
                tentativa[0] = cpuAi.nextInt(4);
                
                if( tentativa[0] > 3 ||tentativa[0] < 1)
                    System.out.println("Espere um pouco, estou pensando.");
                
            }while( tentativa[0] > 3 ||tentativa[0] < 1);
            
            do{
                System.out.print("Coluna: ");
                tentativa[1] = cpuAi.nextInt(4);
                
                if(tentativa[1] > 3 ||tentativa[1] < 1)
                    System.out.println("Ops! Agora vai!.");
                
            }while(tentativa[1] > 3 ||tentativa[1] < 1);
            
            tentativa[0]--; 
            tentativa[1]--;
            
            if(!checaTentativa(tentativa, tabuleiro))
                System.out.println("Perai!.");
        }while( !checaTentativa(tentativa, tabuleiro) );
        
    	   }
    }
    	   
 

    

    
    
    
