package jogodavelha;

import java.util.Scanner;

public class Humano extends Jogador{
    public Scanner entrada = new Scanner(System.in);

    public Humano(int jogador){
        super(jogador);
        this.jogador = jogador;
        System.out.println("Voc� est� On Line boa sorte!");
    }
    /*  Override, Indica que uma declara��o de m�todo se destina a substituir
    uma declara��o de m�todo em um supertipo. Se um m�todo � anotado
    com este tipo de anota��o, compiladores s�o necess�rios para gerar
    uma mensagem de erro, a menos que pelo menos uma das seguintes condi��es seja v�lida: 
 */  
   
    @Override
    public void jogar(Tabuleiro tabuleiro){
        Tentativa(tabuleiro);
        tabuleiro.setPosicao(tentativa, jogador);
    }
 // atributos que validam as posi��es selecionadas pelo jogador humano  
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
