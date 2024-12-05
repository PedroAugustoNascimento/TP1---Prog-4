import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Set;
import java.util.LinkedHashSet;

/*
Joao NO
Carlos YES
Abner NO
Samuel YES
Ricardo NO
Abhay YES
Samuel YES
Andres YES
Roberto NO
Carlos YES
Samuel YES
Samuel YES
Abhay YES
Aline YES
Andres YES
FIM 
*/
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> nomes = new ArrayList<>();
        Set<String> nomesOrganizados = new LinkedHashSet<>();

        //realizando a entrada de dados
        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            if (linha.equalsIgnoreCase("FIM")) {
                break; 
            }
            StringTokenizer token = new StringTokenizer(linha, " ");
            while (token.hasMoreTokens()) {
                String proximaString = token.nextToken();
                nomes.add(proximaString);
            }
        }
        sc.close();

        //salvando em uma lista somente os nomes com YES 
        for (int i=0; i<nomes.size(); i++){
            String atual = nomes.get(i);
            if(i>0){
                String anterior = nomes.get(i-1);
                if(atual.equals("YES")){
                    nomesOrganizados.add(anterior);
                }
            }
        }

        /*System.out.println("==============================");
        for (String word : nomesOrganizados) {
            System.out.println(word);
        }*/

        String[] comparacoes = new String[nomesOrganizados.size()];
        for (int i=0; i<nomesOrganizados.size(); i++){
            String word = "";
            comparacoes[i] = word;
        }

        System.out.println("==================================");
        for (int i=0; i<comparacoes.length; i++){
            System.out.println(comparacoes[i]);
        }

    }
}
