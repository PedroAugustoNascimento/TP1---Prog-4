import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int num = quantidadeCasos(sc);
        List<Integer> ordendos = retornarEordenar(num, sc);
        print(ordendos);
        sc.close();
    }

    //verificando a quantidade de casos teste
    public static int quantidadeCasos(Scanner sc) {
        int qtdCase = sc.nextInt();
        return qtdCase;
    }

    //função para retornar e ordenar os arrayslist de pares e impares
    public static List<Integer> retornarEordenar(int qtdCase, Scanner sc) {
        List<Integer> pares = new ArrayList<>();
        List<Integer> impares = new ArrayList<>();
        List<Integer> ordenados = new ArrayList<>();

        //metodos para separar em pares e impares
        for (int i = 0; i < qtdCase; i++) {
            int numero = sc.nextInt();
            if (numero % 2 == 0) {
                pares.add(numero);
            } else {
                impares.add(numero);
            }
        }

        //forma de ordenar em forma crescente
        Collections.sort(pares);

        //forma de ordenar em forma decrescente
        Collections.sort(impares, Collections.reverseOrder());

        //adicionando os pares ordenados
        for (int num: pares){
            ordenados.add(num);
        }
        //adicionado os impares ordenados
        for (int num: impares){
            ordenados.add(num);
        }
        return ordenados;
    }
    //printando os resultados
    public static void print(List<Integer> ordenados){ 
        for (int num : ordenados) {
            System.out.println(num);
        }
    }

}
