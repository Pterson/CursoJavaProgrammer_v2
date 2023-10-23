package cap15;

import java.util.ArrayList;
import java.util.List;

public class ListaTeste {

    public static void main(String[] args) {

        List<String> paises = new ArrayList<>();
//        List<String> paisesVetor = new Vector<>();
//        List<String> paisesListaEncadeada = new LinkedList<>();

        paises.add("Brasil");
        paises.add("Portugal");
        paises.add("Estados Unidos");
        paises.add("França");
        paises.add("Inglaterra");
        paises.add("Italia");

        String paisBrasil = paises.get(1);  //paises[1]

        boolean contem = paises.contains("Brasil");

        int indexOfPais = paises.indexOf("Brasil"); // 0

        String pais = paises.get(indexOfPais); // Brasil

        if (indexOfPais >= 0){
            System.out.println(paises.get(indexOfPais));
        }else {
            System.out.println("Pais não exists na lista");
        }

        System.out.println("O tamanho da lista é: " + paises.size());

        System.out.println("---- foreach");
        for (String cadaPais : paises){
            System.out.println(cadaPais);
        }

        System.out.println("---- for raiz");
        for (int i = 0; i < paises.size(); i++) {
            System.out.println(paises.get(i));
        }

        paises.replaceAll(paisReplace -> "-" + paisReplace.toUpperCase());

        paises.sort((x, y) -> x.compareTo(y));

        paises.remove("Brasil");
        paises.remove(0);
        paises.clear();

        System.out.println("---- foreach interface funcional");
        paises.forEach(paisForEach -> {
            System.out.println("Cada pais da lista: ");
            System.out.println(paisForEach);
        });

    }
}
