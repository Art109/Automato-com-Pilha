package Classes;

import java.util.ArrayList;
import java.util.List;

public class Automato {
    private String sentenca;
    //private MatrizTransicao matriz;
    //private int estadoInicial;
   //private List<Integer> estadosFinais;
    private Transicao transicao;
    private Pilha pilha;
    private int estadoAtual;

    public Automato() {
        this.sentenca = "";
        /*this.estadoInicial = 0;        
        this.estadosFinais = new ArrayList<>();
        this.estadosFinais.add(3);
        this.matriz = new MatrizTransicao();*/
        this.pilha = new Pilha();
        transicao = new Transicao();
    }
    
    public int sizeofInt(int i) {
		int aux = 0;
		while(i !=0) {
			i--;
			aux += 1;
			
		}
		return aux;
	}
    
    
    public boolean verificaSentenca(String sentenca) {
        this.sentenca = sentenca;
        estadoAtual = transicao.estadoInicial;

        //Lembrar de converter sentenca!
        String nova = this.converterSentenca();
        int index = 0;
        for(int i = 0; i < nova.length(); i++) {
        	index = transicao.procuraTransicao(estadoAtual, Integer.parseInt(nova.charAt(i)+""), pilha.checkTop());
        	if(index == -1)
        		break;
        	estadoAtual = transicao.transicoes.get((index * 5) + 3);
        	
        	//Verifica se deve colocar algo na pilha se sim da um push
        	if(transicao.transicoes.get((index *5) + 4) != -1) {
        		//caso só tenha que adcionar um elemento na pilha
        		if(sizeofInt(transicao.transicoes.get((index * 5) + 4)) == 1) {
        			pilha.Push(transicao.transicoes.get((index *5) + 4));
        		}
        		//caso tenha que adcionar mais de um elemento na pilha
        		else
        			for(int j = 0; j < sizeofInt(transicao.transicoes.get((index *5) + 4)); j++) {
        				pilha.Push((int)(Math.round(transicao.transicoes.get((index * 5) + 4) / Math.pow(10,sizeofInt(transicao.transicoes.get((index *5) + 4)) ))));
        			}
        	}
        	
        	if(transicao.transicoes.get((index * 5) + 2) != -1) {
        		pilha.Pop();
        	}
        }
   
                 
        
        
        /*int i = 0;
        while (i <= this.sentenca.length() - 1 && estadoAtual != -1) {
            int col = Integer.parseInt(nova.charAt(i)+"");
            estadoAtual = this.matriz.getCelula(estadoAtual, col);

            i++;
        }*/
        
       
        
        if (estadoAtual == -1 || index == -1) {
            return false;
        } else if (isFinal(estadoAtual) && pilha.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
    
    public String converterSentenca(){
        String aux = "";
        
        for(int i=0; i<=this.sentenca.length()-1;i++){
            aux = aux + this.alfabe2Index(this.sentenca.charAt(i));
        }
        return aux;
    }            

    private boolean isFinal(int estado) {
        estado = estadoAtual;
        for(int i = 0 ; i < transicao.estadosFinais.length; i++) {
        	if(estadoAtual == transicao.estadosFinais[i])
        		return true;
        }
        return false;
    }

    private char alfabe2Index(char m) {
        char aux = '-';
        switch (m) {
            case 'a':
                aux = '0';
                break;
            case 'b':
                aux = '1';
                break;
            default:
                aux = '-';
                break;
        }
        return aux;
    }    
    
    //Não estamos usando este método
    public int estados2Index(String estado) {
        char aux = '-';
        switch (estado) {
            case "q0":
                return 0;

            case "q1":
                return 1;

            default:
                return -1;

        }
        
    }



}
