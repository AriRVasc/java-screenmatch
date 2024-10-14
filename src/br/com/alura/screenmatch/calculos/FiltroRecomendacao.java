package br.com.alura.screenmatch.calculos;

public class FiltroRecomendacao {

    private String Recomendacao;

    public void filtrar(Classificavel classificavel) {
        if (classificavel.getClassificacao() >= 4) {
            System.out.println("Este está entre os preferidos do momento!");
        } else if (classificavel.getClassificacao() >= 2 ){
            System.out.println("Muito bem avaliado no momento!");
        } else {
            System.out.println("Assista depois!");
        }
    }
}
