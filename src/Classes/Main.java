package Classes;

public class Main {
     
	public static void main(String[]args) {
		Pilha pilha =  new Pilha();
		
		pilha.Push(1);
		pilha.Push(2);
		pilha.Push(3);
		pilha.Print();
		pilha.Pop();
		pilha.Print();
		
	}
}
