package cap13.MegaSena;

public class Main {

	public static void main(String[] args) {

		for(int i = 0; i <6; i++) {
			int numero = MegaSenaUtilitario.sortearNumero(60);
			System.out.println(numero);
		}
		
	}

}
