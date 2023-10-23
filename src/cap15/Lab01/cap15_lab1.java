package cap15.Lab01;

import cap09.laboratorio.Pessoa;
import cap09.laboratorio.Professor;

import java.util.HashMap;
import java.util.Map;

public class cap15_lab1 {

    public static void main(String[] args) {


        Map<String, Professor> professores = new HashMap<>();

        Professor professor = new Professor(3000, "Java", "Peter", 36, 'M', 7, "1900");
        professores.put("Peter", professor);

        professores.put("Benimaru", new Professor(3000, "Mat", "Benimaru", 36, 'M', 8, "1800"));
        professores.get("Benimaru");

        System.out.println(professores.get("Benimaru"));


    }
}
