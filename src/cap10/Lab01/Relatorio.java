package cap10.Lab01;

public class Relatorio implements Imprimivel{
	

	@Override
	public void imprimir() {
		
		System.out.println("Relatorio sendo impresso...");
		
	}
	
	@Override
	public void salvar() {
		
		System.out.println("Salvando...");
	}

}
