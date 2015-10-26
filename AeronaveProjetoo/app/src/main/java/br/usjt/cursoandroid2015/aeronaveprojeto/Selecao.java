package br.usjt.cursoandroid2015.aeronaveprojeto;
/**
 * Created by palomacarreira on 07/09/15.
 */
import java.util.ArrayList;
import java.util.TreeSet;

public class Selecao {

        private static final ArrayList<Passagem> passagens = cadastroDePassagens();

        public Selecao() {

        }

        private Passagem buscarNome(String nome) {
            for (Passagem passagem : passagens) {
                if (nome.equals(passagem.getOrigem())) {
                    return passagem;
                }
            }
            return null;
        }
        public TreeSet<Passagem> listarTodasPassagens(String origem, String destino) {
            TreeSet<Passagem> listas = new TreeSet<Passagem>();

            if (origem.length() > 0 && destino.length() > 0) {
                listas = buscarOrigemDestino(origem, destino);
            } else if (origem.length() > 0) {
                listas = buscarOrigem(origem);
            } else if (destino.length() > 0) {
                listas = buscarDestino(destino);
            } else {
                listas = todas();
            }

            return listas;
        }

        private TreeSet<Passagem> buscarOrigem(String origem) {
            TreeSet<Passagem> lista = new TreeSet<Passagem>();
            for (Passagem passagem : passagens) {
                if (origem.equals(passagem.getOrigem())) {
                    lista.add(passagem);
                }
            }
            return lista;
        }

        private TreeSet<Passagem> buscarDestino(String destino) {
            TreeSet<Passagem> lista = new TreeSet<Passagem>();
            for (Passagem passagem : passagens) {
                if (destino.equals(passagem.getDestino())) {
                    lista.add(passagem);
                }
            }
            return lista;
        }

        private TreeSet<Passagem> buscarOrigemDestino(String origem, String destino) {
            TreeSet<Passagem> lista = new TreeSet<Passagem>();
            for (Passagem passagem : passagens) {
                if (destino.equals(passagem.getDestino()) && origem.equals(passagem.getOrigem())){
                    lista.add(passagem);
                }
            }
            return lista;
        }

        private TreeSet<Passagem> todas() {
            TreeSet<Passagem> lista = new TreeSet<Passagem>();
            for (Passagem passagem : passagens) {
                lista.add(passagem);
            }
            return lista;
        }

        private static ArrayList<Passagem> cadastroDePassagens() {
            ArrayList<Passagem> passagens = new ArrayList<Passagem>();
            passagens.add(new Passagem("São Paulo", "Fortaleza", "23hs", 152.00));
            passagens.add(new Passagem("São Paulo", "Fortaleza", "15hs", 145.00));
            passagens.add(new Passagem("São Paulo", "Fortaleza", "21hs", 145.00));
            passagens.add(new Passagem("São Paulo", "Fortaleza", "18hs", 185.00));
            passagens.add(new Passagem("São Paulo", "João Pessoa", "23hs", 112.00));
            passagens.add(new Passagem("São Paulo", "João Pessoa", "12hs", 145.00));
            passagens.add(new Passagem("São Paulo", "João Pessoa", "21hs", 178.00));
            passagens.add(new Passagem("São Paulo", "João Pessoa", "14hs", 135.00));
            passagens.add(new Passagem("João Pessoa","Fortaleza", "14hs", 245.00));
            passagens.add(new Passagem("João Pessoa","Fortaleza", "12hs", 247.00));
            passagens.add(new Passagem("João Pessoa","Fortaleza", "15hs", 285.00));
            passagens.add(new Passagem("João Pessoa","Fortaleza", "13hs", 295.00));
            passagens.add(new Passagem("João Pessoa", "São Paulo", "13hs", 678.00));
            passagens.add(new Passagem("João Pessoa", "São Paulo", "23hs", 645.00));
            passagens.add(new Passagem("João Pessoa", "São Paulo", "14hs", 650.00));
            passagens.add(new Passagem("João Pessoa", "São Paulo", "12hs", 610.00));
            passagens.add(new Passagem("Fortaleza", "São Paulo", "18hs", 745.00));
            passagens.add(new Passagem("Fortaleza", "São Paulo", "15hs", 778.00));
            passagens.add(new Passagem("Fortaleza", "São Paulo", "12hs", 789.00));
            passagens.add(new Passagem("Fortaleza", "São Paulo", "14hs", 775.00));
            passagens.add(new Passagem("Fortaleza", "João Pessoa", "12hs", 250.00));
            passagens.add(new Passagem("Fortaleza", "João Pessoa", "15hs", 570.00));
            passagens.add(new Passagem("Fortaleza", "João Pessoa", "14hs", 450.00));
            passagens.add(new Passagem("Fortaleza", "João Pessoa", "19hs", 215.00));


            return passagens;
        }
    }

