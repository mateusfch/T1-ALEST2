import java.util.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class App {

    public static void main(String[] args) throws Exception {
        String conteudo = "";
        String nomeArquivo = "C:\\Users\\Mateus\\Desktop\\dna linkedlist\\dna linked list\\src\\casos\\caso10000k.txt";

        try {
            conteudo = new String(Files.readAllBytes(Paths.get(nomeArquivo)),
                    StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }

        long start = System.nanoTime();

        Map<String, Character> dict = new HashMap<String, Character>();
        dict.put("AN", 'D');
        dict.put("NA", 'D');
        dict.put("AD", 'N');
        dict.put("DA", 'N');
        dict.put("ND", 'A');
        dict.put("DN", 'A');

        LinkedListOfCharacter lista = new LinkedListOfCharacter();

        for (int i = 0; i < conteudo.length(); i++) {
            lista.add(conteudo.charAt(i));
        }

        for (int i = 0; lista.size() > 1; i++) {

            char c1 = lista.get(i);
            char c2 = lista.get(i + 1);
            if (c1 != c2) {

                lista.add(dict.get((String.valueOf(c1) + String.valueOf(c2))));
                lista.removeByIndex(i + 1);
                lista.removeByIndex(i);
                if (i != 0) {
                    i = i - 2;
                } else {
                    i--;
                }
            }
        }
        long end = System.nanoTime();
        System.out.println("CADEIA RESULTANTE: " + lista.toString());
        System.out.println("TEMPO DE EXECUÇÃO: " + (end - start) / 1e9);

    }
}