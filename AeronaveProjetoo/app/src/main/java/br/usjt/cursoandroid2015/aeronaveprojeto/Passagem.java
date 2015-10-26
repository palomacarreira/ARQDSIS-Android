package br.usjt.cursoandroid2015.aeronaveprojeto;
/**
 * Created by palomacarreira on 07/09/15.
 */
public class Passagem implements Comparable<Passagem>{
    private String origem;
    private String destino;
    private String horarioSaida;
    private double preco;
    public static final String NAO_ENCONTRADA = "Não encontrada.";

    public Passagem(String origem, String destino, String horarioSaida, double preco) {
        this.origem = origem;
        this.destino = destino;
        this.horarioSaida = horarioSaida;
        this.preco = preco;
    }

    public String getOrigem() {
        return origem;
    }

    public String getDestino() {
        return destino;
    }

    public String getHorarioSaida() {
        return horarioSaida;
    }

    public double getPreco() { return preco;}

    @Override
    public String toString() {
        return "br.usjt.cursoandroid2015.aeronaveprojeto.Passagem{" +
                "origem='" + origem + '\'' +
                ", destino='" + destino + '\'' +
                ", horarioSaida='" + horarioSaida + '\'' +
                ", preco='" + preco + '\'' +
                '}';
    }

    @Override
    public int compareTo(Passagem passagem) {
        if (origem.equals(passagem.getOrigem())
                && destino.equals(passagem.getDestino())) {
            return 0;
        }
        return this.getOrigem().compareTo(passagem.getOrigem());
    }
}
