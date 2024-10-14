package br.com.alura.screenmatch;

public class Titulo {
    private String nome;
    private int anoDeLancamento;
    private int duracaoEmMinutos;
    private boolean incluidoNoPlano;
    private double somaDasAvaliacoes;
    private int totalDeAvaliacoes;


    void exibeFichaTecnica()
    {
        System.out.println("O nome do filme é: " +nome);
        System.out.println("Seu ano de lançamento é: " +anoDeLancamento);
        System.out.println("Duração: " +duracaoEmMinutos);
        System.out.println("Incluído no plano? " +incluidoNoPlano);
    }

    void avalia(double nota)
    {
        somaDasAvaliacoes += nota;
        totalDeAvaliacoes++;
    }

    double pegaMedia()
    {
        return somaDasAvaliacoes/totalDeAvaliacoes;
    }

    public String getNome() {
        return nome;
    }

    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public int getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    public boolean isIncluidoNoPlano() {
        return incluidoNoPlano;
    }

    public double getSomaDasAvaliacoes() {
        return somaDasAvaliacoes;
    }

    public int getTotalDeAvaliacoes() {
        return totalDeAvaliacoes;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAnoDeLancamento(int anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    public void setDuracaoEmMinutos(int duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    public void setIncluidoNoPlano(boolean incluidoNoPlano) {
        this.incluidoNoPlano = incluidoNoPlano;
    }

}
