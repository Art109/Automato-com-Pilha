package Classes;

import java.util.ArrayList;
import java.util.List;

public class Automato {
    private String sentenca;
    private MatrizTransicao matriz;
    private int estadoInicial;
    private List<Integer> estadosFinais;
    private Pilha pilha;

    public Automato() {
        this.sentenca = "";
        /*this.estadoInicial = 0;        
        this.estadosFinais = new ArrayList<>();
        this.estadosFinais.add(3);
        this.matriz = new MatrizTransicao();*/
        this.pilha = new Pilha();
    }

    public boolean verificaSentenca(String sentenca) {
        this.sentenca = sentenca;
        //int estadoAtual = this.estadoInicial;

        //Lembrar de converter sentenca!
        String nova = this.converterSentenca();
        
        /*int i = 0;
        while (i <= this.sentenca.length() - 1 && estadoAtual != -1) {
            int col = Integer.parseInt(nova.charAt(i)+"");
            estadoAtual = this.matriz.getCelula(estadoAtual, col);

            i++;
        }*/
        
        boolean a = true;
        for(int i = 0 ; i < nova.length(); i++) {
        	int leitura = Integer.parseInt(nova.charAt(i) + "");
        	
        	if(leitura == 0 && a) {
        		pilha.Push(0);
        	}
        	else if(leitura == 1) {
        		a = false;
        		if(!pilha.isEmpty()) {
        			pilha.Pop();
        		}
        		else
        			return false;
        	}
        }
        
        if(pilha.isEmpty()) {
        	return true;
        }
        
        return false;
        /*
        if (estadoAtual == -1) {
            return false;
        } else if (isFinal(estadoAtual)) {
            return true;
        } else {
            return false;
        }
        */
    }
    
    public String converterSentenca(){
        String aux = "";
        
        for(int i=0; i<=this.sentenca.length()-1;i++){
            aux = aux + this.alfabe2Index(this.sentenca.charAt(i));
        }
        return aux;
    }            

    private boolean isFinal(int estado) {
        return this.estadosFinais.contains(estado);               
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
