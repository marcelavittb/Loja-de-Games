public class Game {
    private String nome;
    private double preco;
    private String categoria;

    public Game(String nome, double preco, String categoria) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome do jogo não pode ser vazio!");
        }
        if (preco < 0) {
            throw new IllegalArgumentException("Preço não pode ser negativo!");
        }
        this.nome = nome;
        this.preco = preco;
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public String getCategoria() {
        return categoria;
    }

    @Override
    public String toString() {
        return nome + " | " + categoria + " | R$" + preco;
    }
}
