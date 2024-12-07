package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.calculos.CalculadoraDeTempo;
import br.com.alura.screenmatch.calculos.FiltroRecomendacao;
import br.com.alura.screenmatch.models.*;

import java.util.ArrayList;
import java.util.Comparator;


public class Main {
    public static void main(String[] args) {
        Filme favorito = new Filme("The Matrix", 2001);
        favorito.setDuracaoEmMinutos(135);
        favorito.setIncluidoNoPlano(true);
        System.out.println("Ficha técnica do filme favorito:");
        favorito.exibeFichaTecnica();


        Filme outro = new Filme("John Wick", 1999);
        outro.setDuracaoEmMinutos(101);
        outro.setIncluidoNoPlano(true);

        Serie serie = new Serie("La Casa de Papel", 2017);
        serie.setIncluidoNoPlano(true);
        serie.setAtiva(true);
        serie.setTemporadas(5);
        serie.setEpisodiosPorTemporada(10);
        serie.setMinutosPorEpisodio(45);

        CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
        calculadora.inclui(favorito);
        calculadora.inclui(outro);
        calculadora.inclui(serie);

        System.out.println("Tempo total: " +calculadora.getTempoTotal());

        Episodios primeiro = new Episodios();
        primeiro.setNumero(1);
        primeiro.setSerie(serie);
        primeiro.setTotalVisualizacoes(300);

        FiltroRecomendacao filtro = new FiltroRecomendacao();
        filtro.filtrar(favorito);
        filtro.filtrar(outro);
        filtro.filtrar(primeiro);

        ArrayList<Filme> listaFilmes = new ArrayList<>();
        listaFilmes.add(favorito);
        listaFilmes.add(outro);
        System.out.println(listaFilmes);
        System.out.println(listaFilmes.get(1).toString());
        System.out.println("O tamanho da lista é: " +listaFilmes.size());

        favorito.avalia(10);
        outro.avalia(9.5);

        ArrayList<Titulo> lista = new ArrayList<>();
        lista.add(favorito);
        lista.add(outro);
        lista.add(serie);

        for(Titulo item:lista){
            System.out.println("Nome: "+item.getNome());
            if (item instanceof Filme filme && filme.getClassificacao()>2){
                System.out.println(" Classificação: "+filme.getClassificacao());
            }
        }
        System.out.println(lista);
        lista.sort(Comparator.comparing(Titulo::getAnoDeLancamento));
        System.out.println(lista);


    }

}



