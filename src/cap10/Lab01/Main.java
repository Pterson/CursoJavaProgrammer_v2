package cap10.Lab01;

public class Main {

	public static void main(String[] args) {

		Relatorio relatorio = new Relatorio();
		
		Grafico grafico = new Grafico();
		
		

//Invocação do metodos imprimir
		relatorio.imprimir();
		
		grafico.imprimir();
		
		relatorio.salvar();
		
		

	}

}
