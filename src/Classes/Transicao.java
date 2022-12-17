package Classes;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Transicao {
	
	public ArrayList<Integer> transicoes;
	public int estadoInicial;
	public int[] estadosFinais;
	
	
	public Transicao() {
		 transicoes = new ArrayList<Integer>();
		loadTransicoes();
	}
	
	private void loadTransicoes(){
		try {
            FileReader file = new FileReader("Transicao.txt");
            Scanner arquivo = new Scanner(file);
            
            //Lê a primeira linha que define o estado inicial
            arquivo.useDelimiter("\r\n");
            String primeiraLinha = arquivo.next();
            this.estadoInicial =  Integer.parseInt(primeiraLinha);
            
          //Lê a segunda linha que define o vetor de estados finais
            String segundaLinha = arquivo.next(); 
            String vet[] = segundaLinha.split(";");
            this.estadosFinais = new int[vet.length];
            for(int i = 0 ; i < vet.length; i++){
            	this.estadosFinais[i] =  Integer.parseInt(vet[i]);
            }
            
            ///Daqui pra baixo são transições
            String linhaCorrente = "";
            while(arquivo.hasNext()){
                linhaCorrente = arquivo.next();
                vet = linhaCorrente.split(";");
               
                for(int i = 0; i < vet.length ; i++) {
                	transicoes.add(Integer.parseInt(vet[i]));
                	
                }
            }
        
            
            
            
        } catch (FileNotFoundException ex) {
        	System.out.println(ex);
        	//Logger.getLogger(MatrizTransicao.class.getName()).log(Level.SEVERE, null, ex);
        }
    
	}
	
	public ArrayList<Integer> getTransicoes() {
		return transicoes;
	}
	public int getEstadoInicial() {
		return estadoInicial;
	}
	public int[] getEstadoFinais() {
		return estadosFinais;
	}

}
