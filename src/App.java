import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        String path = "C:\\Users\\pakkz\\OneDrive\\Desktop\\TP1 - Prog 4\\TP1\\arquivos\\teste.txt";
        leitor(path);
    }

    public static void leitor(String caminho){
        try{
            FileReader arquivo = new FileReader(caminho);
            BufferedReader leitura = new BufferedReader(arquivo);

            //lendo a primeira linha e verificando a quantidade de casos
            String line = leitura.readLine();

                int qtdCase = Integer.parseInt(line.trim());

                for (int n =0; n<qtdCase; n++){
                    if(n>0){
                        System.out.println('\n');
                    }
                    //pega a segunda linha e separa as chaves e a quantidade de números
                    String [] linha = leitura.readLine().trim().split(" ");
                    int chaves = Integer.parseInt(linha[0]);
                    int numeros = Integer.parseInt(linha[1]);

                    //calculando enderecos
                    String [] enderecos = leitura.readLine().trim().split(" ");
                    int valores[] = new int[numeros];
                    for (int i =0; i<numeros; i++){
                        valores[i] = calculaEnderecos(Integer.parseInt(enderecos[i]),chaves);
                    }

                    //criando uma array vazia com a quantidade de endereco
                    List<String> array = new ArrayList<>();
                    for (int i=0; i<chaves; i++){
                        array.add(i + " ->");
                    }

                    //verificando os valores dos enderecos e se a chave está no array
                    for (int i=0; i<array.size();i++){
                        for (String num : array){
                            if (array.contains(Integer.toString(valores[i]))){
                                array.set(num, " -> "+ enderecos[i]);
                            }
                        }
                    }
                   
                    //printando resultado
                    for(String num: array){
                        System.out.println(num);
                    }
                    


                }
        }  catch (IOException e) {
            System.err.printf("Arquivo não encontrado: %s.\n",
                      e.getMessage());
       }
    }

    public static int calculaEnderecos(int numero, int endereco){
        int dispersao = numero % endereco;
        return dispersao;
    }

}
