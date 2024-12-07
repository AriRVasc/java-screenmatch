package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.excecao.ErroDeConversaoDeAnoException;
import br.com.alura.screenmatch.models.Titulo;
import br.com.alura.screenmatch.models.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalComBusca {
        public static void main(String[] args) throws IOException, InterruptedException {
            Scanner scanner = new Scanner(System.in);
            List<Titulo> titulos = new ArrayList<>();
            int op =1;

            Gson gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                    .create();

            while (op != 0) {
                System.out.println("Digite um filme para busca: ");
                var busca = scanner.nextLine();
                String endereco = "https://www.omdbapi.com/?t=" + busca.replace(" ", "+") + "&apikey=e83120c0";

                try {
                    HttpClient client = HttpClient.newHttpClient();
                    HttpRequest request = HttpRequest.newBuilder()
                            .uri(URI.create(endereco))
                            .build();
                    HttpResponse<String> response = client
                            .send(request, HttpResponse.BodyHandlers.ofString());

                    String json = response.body();
                    System.out.println(json);



                    TituloOmdb meuTituloOmdb = gson.fromJson(json, TituloOmdb.class);
                    System.out.println(meuTituloOmdb);
                    Titulo meuTitulo = new Titulo(meuTituloOmdb);

                    titulos.add(meuTitulo);
                } catch (NumberFormatException e) {
                    System.out.println("Aconteceu um erro: ");
                    System.out.println(e.getMessage());
                } catch (IllegalArgumentException e) {
                    System.out.println("Algum erro de argumento na busca, verifique o endereço");
                } catch (ErroDeConversaoDeAnoException e) {
                    System.out.println(e.getMessage());
                }
                System.out.println("Digite 1 para continuar adicionando filmes ou 0 para sair: ");
                op = scanner.nextInt();
                scanner.nextLine();

            }

            System.out.println(titulos);
            FileWriter escrita = new FileWriter("filmes.json");
            escrita.write(gson.toJson(titulos));
            escrita.close();
            System.out.println("O programa finalizou corretamente!");
        }
}
