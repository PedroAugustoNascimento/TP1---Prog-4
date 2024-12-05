import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

import javax.swing.SpinnerDateModel;

import java.util.Set;
import java.util.LinkedHashSet;
import java.util.Collections;

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
        List<String> nomesYes = new ArrayList<>();
        List<String> nomesNo = new ArrayList<>();
        int maximo = 0;
        String vencedor = "";

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

        //salvando em uma lista os nomes com YES e NO
        for (int i=0; i<nomes.size(); i++){
            String atual = nomes.get(i);
            if(i>0){
                String anterior = nomes.get(i-1);
                if(atual.equals("YES")){
                    if(!nomesYes.contains(anterior)){
                        nomesYes.add(anterior);
                    }
                } 
                if (atual.equals("NO")) {
                    if(!nomesYes.contains(anterior)){
                        nomesNo.add(anterior);
                    }
                }
                    
                    
            }
        }
        System.out.println("=================================");
        for (String nome: nomesYes){
            System.out.println(nome);
        }

        for (String nome : nomesYes){
            if((nome.length() > 0 ) || (nome.length() == maximo && vencedor.isEmpty())){
                vencedor = nome;
                maximo = nome.length();
            }
        }

        Collections.sort(nomesYes);
        Collections.sort(nomesNo);

        for (String nome: nomesYes){
            System.out.println(nome);
        }
        for (String nome: nomesNo){
            System.out.println(nome);
        }

        System.out.println();
        System.out.println("Amigo do Habay");
        System.out.println(vencedor);
    }
}
