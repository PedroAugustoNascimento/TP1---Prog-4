import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        int qtdCase = quantidadeCasos(sc);
        String chavesEnd[] = chavesEtestes(sc);
        List<String[]> resultado = construirArray(chavesEnd, sc, qtdCase);
        print(resultado);
        sc.close();
        
    }

    //pegando a quantidade de testes
    public static int quantidadeCasos(Scanner sc){
        return sc.nextInt();
    }

    //armazenando em um vetor a quantidade de numeros e as chaves
    public static String[] chavesEtestes(Scanner sc){
        sc.nextLine();
        String input[] = sc.nextLine().split(" "); 
        return input;
    }

    //calculando a função de dispersão h(x) = x mod chaves
    public static int calculoEnd(String chave, String num){
        int endereco, numeros;
        endereco = Integer.parseInt(chave);
        numeros = Integer.parseInt(num);
        return numeros % endereco;
    }

    //construindo um arraylist de vetores com as chaves e seus respectivos numeros
    public static List<String[]> construirArray(String[] input, Scanner sc, int qtdCase){
        List<String[]> array = new ArrayList<>();
        int testes = Integer.parseInt(input[1]);
        int endereco = Integer.parseInt(input[0]);
        int i=0;
        //criando varios vetores com o indice e a setinha '->'
        do {
            String chaves[] = new String[endereco];
            for (int j=0; j<endereco; j++){
                chaves[j] = j + " -> ";
            }

            //lendo os numeros a serem calculados
            String numeros[] = sc.nextLine().split(" ");
            
            //calculando os numeros e 'jogando' para o vetor vazio construido anteriormente
            for (int j=0; j<testes; j++){
                int numCalc = calculoEnd(input[0], numeros[j]);
                chaves = contruirChaves(chaves, numCalc, numeros[j]);
            }
            array.add(chaves);
            i++;
        } while ( i< qtdCase);
        return array;
    }

    //calculando cada vetor do arraylist, colocando os numeros resultantes do calculo
    public static String[] contruirChaves(String []chaves, int numCalc, String numeros){
        chaves[numCalc] += numeros + " -> ";
        return chaves;
    }

    //printando o resultado
    public static void print(List<String[]> array) {
        for (String[] chave : array) {
            for (String linha : chave) {
                System.out.println(linha + "\\ ");
            }
        }
    }
}
