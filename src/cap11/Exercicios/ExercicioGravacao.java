package cap11.Exercicios;

import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;


public class ExercicioGravacao {

	public static void main(String[] args) {

		String texto = JOptionPane.showInputDialog("Digite um texto");
		
		PrintWriter writer = null;
		try {
			
		writer = new PrintWriter("D:\\ESTUDOS\\IMPACTA\\CursoJavaProgrammer_v2\\Projects\\src\\cap11\\Exercicios\\ArqTexto\\Logs.txt");
		writer.println(texto);
		writer.append(texto);
		writer.close();
		
		}catch (IOException e) {
			
			e.printStackTrace();
			
		} finally {
			if(writer != null) {
				writer.close();
			}
		}
	}
}
