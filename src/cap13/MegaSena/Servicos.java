package cap13.MegaSena;

import org.junit.jupiter.api.*;


// When  -> Quando
// Given -> Dado
// Then  -> Resultado

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Servicos {

//	@BeforeAll
//	static void iniciarAntesDeTodosTestes(){
//
//		System.out.println("BeforeAll: Iniciando conexão com out banco");
//	}
//	@BeforeEach
//	void iniciarAntesDeCadaTeste(){
//
//		System.out.println("BeforeEach: Iniciando conexão com out banco");
//	}
//
//	@AfterAll
//	static void executaNoFinalDeTodosTestes(){
//
//		System.out.println("Acabou todos os testes");
//	}
//
//	@AfterEach
//	void executaNoFinalDeCadaTeste(){
//
//		System.out.println("Acabou um teste");
//	}
	
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

	@Test
	void validadorNumerosMega () {

		int [] array = MegaSenaUtilitario.numerosSorteados();

		for(int i =0; i< array.length; i++) {
			for (int j = 0; j < array.length; j++) {

				int i1 = array[i];
				int i2 = array[j];
				if(i != j && i1 == i2){
					Assertions.fail("Valor já existente!!!");
				}
			}
		}
	}

}

