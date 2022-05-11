package jogodavelha;

import java.util.Scanner;

public class Humano extends Jogador{
    public Scanner entrada = new Scanner(System.in);

    public Humano(int jogador){
        super(jogador);
        this.jogador = jogador;
        System.out.println("Você está On Line boa sorte!");
    }
    /*  Override, Indica que uma declaração de método se destina a substituir
    uma declaração de método em um supertipo. Se um método é anotado
    com este tipo de anotação, compiladores são necessários para gerar
    uma mensagem de erro, a menos que pelo menos uma das seguintes condições seja válida: 
 */  
   
    @Override
    public void jogar(Tabuleiro tabuleiro){
        Tentativa(tabuleiro);
        tabuleiro.setPosicao(tentativa, jogador);
    }
 // atributos que validam as posições selecionadas pelo jogador humano  
    @Override
    public void Tentativa(Tabuleiro tabuleiro){
        do{
            do{
                System.out.print("Linha: ");
                tentativa[0] = entrada.nextInt();
                
                if( tentativa[0] > 3 ||tentativa[0] < 1)
                    System.out.println("Jogada incorreta.");
                
            }while( tentativa[0] > 3 ||tentativa[0] < 1);
            
            do{
                System.out.print("Coluna: ");
                tentativa[1] = entrada.nextInt();
                
                if(tentativa[1] > 3 ||tentativa[1] < 1)
                    System.out.println("Jogada incorreta.");
                
            }while(tentativa[1] > 3 ||tentativa[1] < 1);
            
            tentativa[0]--; 
            tentativa[1]--;
            
            if(!checaTentativa(tentativa, tabuleiro))
                System.out.println("Tente jogar em outro lugar.");
        }while( !checaTentativa(tentativa, tabuleiro) );
    }
}
