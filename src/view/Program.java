package view;

import java.util.Locale;
import java.util.Scanner;
import model.ManipularCmds;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        
        
        String[] trecho;
        String diretorioPai= "/";
        
        System.out.println("----- Seja Bem-Vindo Ao Thunar -----");
        System.out.println("");
        
        
        boolean exit = false;
        String localCursor = "$"+diretorioPai+"*";
        
        while(exit == false){
            System.out.print(localCursor);
            
            
            trecho = sc.nextLine().split(" ");
            
            if( trecho[0].equals("exit") &&  trecho.length <= 1 ){
                
                    System.out.println("--------------");
                    System.out.println("| Ate mais ! |");
                    System.out.println("--------------");
                    
                    exit = true;
            }
            
            else{
                ManipularCmds comando = new ManipularCmds();
                String retornoCompleto = comando.PesquisarCmd(trecho,diretorioPai);
                
                if(retornoCompleto.contains("/")){
                    String[] retornoSimples = retornoCompleto.split(" ");
                    diretorioPai = retornoSimples[1];
                    localCursor = retornoSimples[0];
                }
                else{
                    System.out.println(retornoCompleto);
                }
            
            }
            
        }
        sc.close();
    }
    
}
