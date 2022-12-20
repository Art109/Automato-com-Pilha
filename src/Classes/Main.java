package Classes;

public class Main {
     
	public static void main(String[]args) {
	
		Automato automato = new Automato();
		if(automato.verificaSentenca("aaaaabbbbb")) {
			System.out.print("Aceita");
		}
		else 
			System.err.print("Rejeita");

	}
}
