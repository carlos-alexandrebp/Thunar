package model;

import controller.Salvar;
import java.io.File;


public class ManipularCmds {
    
    private static String dirPai;
    
    
    
    public  String PesquisarCmd(String[] trecho,String diretorioPai){
        dirPai = diretorioPai;
        
        switch(trecho[0]){
            case "cd" : 
                if(trecho.length == 1){
                    return "Erro! Use o cd com argumentos sendo pasta ou arquivos ex [cd casa]|";
                }
                else if(trecho[1].equals("..")){
                    String[] x = dirPai.replace('/', ' ').split(" ");
                    
                    if(x.length == 2){
                        dirPai = "/";
                    }
                    else{
                        for(int a =0;a < (x.length -1);a++)
                        {

                        if(a == 0){
                            dirPai = "/";
                            dirPai = x[a];
                        }
                        else{
                            dirPai +="/"+ x[a];
                        }
                        }
                    }
                    return "$"+dirPai+"* "+dirPai;
                    
                }
                else{
                    File arq = new File(dirPai+"/"+trecho[1]);
                    
                    if(arq.exists()){
                        if(dirPai.equals("/"))
                            dirPai = dirPai+""+trecho[1]; 
                        else{
                            dirPai = dirPai+"/"+trecho[1]; 
                        }
                        
                        return "$"+dirPai+"* "+dirPai;
                    }
                 }
                break;
            case "ls":
                File arq = new File(dirPai);
                
                File[] listarDiretorios = arq.listFiles(File :: isDirectory);
                File[] listarFiles = arq.listFiles(File :: isFile);
                
                for(File D : listarDiretorios)
                {
                    System.out.println("  " + D.getName());
                }
                for(File F : listarFiles)
                {
                    System.out.println(" *" + F.getName());
                }
                
                return "ok";
                
                //break;
            
        }
        
        
        return "   !Erro! nao existe o arquivo espesificado ou programa.";
    }
    
    //SALVA O CODIGO EM UM ARQ
    public String  ResgatarUltimoPonteiro(){
    
        return "";
    }
    public static void GurdarUltimoPonteiro(String ponteiro){
        Salvar.salvarCaminho(ponteiro);
    }
}
