package cap11.Exercicios;

import java.awt.font.NumericShaper;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class ExercicioIdade {

	public static void main(String[] args) {
		
	//	Scanner scanner = new Scanner(System.in);
		
		int ano = 0;
		
		do {
		
		System.out.print("Digite o ano de nascimento: "); 
	//	String texto = scanner.nextLine();
		String texto = JOptionPane.showInputDialog("Digite o ano:");
		
		try {
		
		ano = Integer.parseInt(texto);
		
		int idade = 2023 - ano;
		
	//	System.out.println("Sua idade é: " + idade);
		
		JOptionPane.showConfirmDialog(null, "Sua idade é: " + idade + " anos");
		
		}catch (NumberFormatException e) {
			
			e.printStackTrace();
			System.out.println();
			JOptionPane.showMessageDialog(null, "Valor inválido");
		}

	    } while (ano == 0);		
	}
}