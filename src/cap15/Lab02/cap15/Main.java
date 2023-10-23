package cap15.Lab02.cap15;

import java.util.ArrayList;

public class Main {

    public static <arrayList> void main(String[] args) {

        ArrayList<Estudante> estudanteList = new ArrayList<>();

        estudanteList.add(new Estudante("Jona", 7.5, 8.0));
        estudanteList.add(new Estudante("Anotnio", 6.5, 8.5));

        estudanteList.forEach(estudante -> {
            double soma = estudante.getNotaMatematica() + estudante.getNotaPortugues();
            double media = soma/2;
            estudante.setMedia(media);

            System.out.println(estudante);
        });
    }
}
