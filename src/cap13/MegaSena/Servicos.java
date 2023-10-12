package cap13.MegaSena;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;


// When  -> Quando
// Given -> Dado
// Then  -> Resultado

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Servicos {
	
	@Test
	@Order(1)
	@DisplayName("Se numero é maior que 60")
	void numeroMaiorSessenta() {
		int numero = MegaSenaUtilitario.sortearNumero(60);
		Assertions.assertFalse(numero > 60);
	}
	
	@Test
	@Order(2)
	@DisplayName("Se numero é menor que 0")
	void numeroMenoresZero() {
		
		int numero = MegaSenaUtilitario.sortearNumero(60);
		
//		Assertions.assertFalse(numero <= 0);
//		Assertions.assertTrue(numero > 60);		
		Assertions.assertTrue(numero > 0 && numero <= 60);
	}
	
	@Test
	@Order(3)
	@DisplayName("Se numero repetem no sorteio")
	void listaNumeroSorteados() {
		int max = 60;
		
		for(int i = 0; i < max; i++) {
			
			int numero = MegaSenaUtilitario.sortearNumero(60);			
			Assertions.assertTrue(numero > 0 && numero <= 60);			
			System.out.print(numero + " ");
		}
	}
}

