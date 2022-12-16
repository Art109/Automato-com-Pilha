package Classes;

public class Main {
     
	public static void main(String[]args) {
	
		Automato automato = new Automato();
		
		boolean resultado = automato.verificaSentenca("aaaabbbb");
		
		if(resultado)
			System.out.print("Aceita");
		else
			System.err.print("Rejeita");
		
	}
}
