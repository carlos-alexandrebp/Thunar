package controller;

import java.io.File;



public class Salvar {
    public static void salvarCaminho(String informacao){
        String diretorio_Salvar = "/home/carlos/mint/config";
        
        File arq;
  //IMPLEMENTAR DADOS      
       //try{
            arq = new File(diretorio_Salvar);
            if(!arq.exists()){
                arq.mkdirs();
                

            }
           
            if(arq.exists()){
                
            }else {
            }
        //}catch(IOException exeption){
            
        
    }
}
