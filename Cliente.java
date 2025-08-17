import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nome;
    private double saldo;
    private List<Game> biblioteca;

    public Cliente(String nome, double saldo) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser vazio!");
        }
        this.nome = nome;
        this.saldo = saldo;
        this.biblioteca = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public double getSaldo() {
        return saldo;
    }

    public List<Game> getBiblioteca() {
        return biblioteca;
    }

    public void adicionarSaldo(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor deve ser positivo!");
        }
        this.saldo += valor;
    }

    public void comprarJogo(Game jogo) throws Exception {
        if (jogo.getPreco() > saldo) {
            throw new Exception("Saldo insuficiente para comprar " + jogo.getNome());
        }
        saldo -= jogo.getPreco();
        biblioteca.add(jogo);
    }
}
