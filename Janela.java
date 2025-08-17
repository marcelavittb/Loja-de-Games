import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;

public class Janela extends JFrame {
    private Cliente cliente;
    private DefaultListModel<Game> model;
    private List<Game> jogosOriginais;

    public Janela(Cliente cliente, List<Game> jogos) {
        this.cliente = cliente;
        this.jogosOriginais = jogos;

        setTitle("Loja de Games");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        model = new DefaultListModel<>();
        jogos.forEach(model::addElement);

        JList<Game> listaJogos = new JList<>(model);
        JScrollPane scrollPane = new JScrollPane(listaJogos);

        JButton btnComprar = new JButton("Comprar Jogo");
        JButton btnAddSaldo = new JButton("Adicionar Saldo");
        JButton btnFiltrar = new JButton("Filtrar");
        JButton btnDetalhes = new JButton("Exibir Detalhes");
        JButton btnResetar = new JButton("Mostrar Todos");

        JPanel painel = new JPanel();
        painel.add(btnComprar);
        painel.add(btnAddSaldo);
        painel.add(btnFiltrar);
        painel.add(btnDetalhes);
        painel.add(btnResetar);

        add(scrollPane, BorderLayout.CENTER);
        add(painel, BorderLayout.SOUTH);

        // Comprar jogo
        btnComprar.addActionListener(e -> {
            Game jogo = listaJogos.getSelectedValue();
            if (jogo != null) {
                try {
                    cliente.comprarJogo(jogo);
                    JOptionPane.showMessageDialog(this, "Jogo comprado: " + jogo.getNome());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Adicionar saldo
        btnAddSaldo.addActionListener(e -> {
            String valor = JOptionPane.showInputDialog("Digite o valor para adicionar:");
            try {
                double v = Double.parseDouble(valor);
                cliente.adicionarSaldo(v);
                JOptionPane.showMessageDialog(this, "Novo saldo: R$" + cliente.getSaldo());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Entrada inválida!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Filtrar jogos
        btnFiltrar.addActionListener(e -> {
            String[] opcoes = {"Categoria", "Preço máximo"};
            String escolha = (String) JOptionPane.showInputDialog(
                    this, "Filtrar por:", "Filtro",
                    JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);

            if (escolha != null) {
                if (escolha.equals("Categoria")) {
                    String categoria = JOptionPane.showInputDialog("Digite a categoria:");
                    if (categoria != null && !categoria.isEmpty()) {
                        atualizarLista(jogosOriginais.stream()
                                .filter(j -> j.getCategoria().equalsIgnoreCase(categoria))
                                .collect(Collectors.toList()));
                    }
                } else if (escolha.equals("Preço máximo")) {
                    String valor = JOptionPane.showInputDialog("Digite o preço máximo:");
                    try {
                        double precoMax = Double.parseDouble(valor);
                        atualizarLista(jogosOriginais.stream()
                                .filter(j -> j.getPreco() <= precoMax)
                                .collect(Collectors.toList()));
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(this, "Preço inválido!");
                    }
                }
            }
        });

        // Exibir detalhes
        btnDetalhes.addActionListener(e -> {
            Game jogo = listaJogos.getSelectedValue();
            if (jogo != null) {
                JOptionPane.showMessageDialog(this,
                        "Nome: " + jogo.getNome() +
                        "\nCategoria: " + jogo.getCategoria() +
                        "\nPreço: R$" + jogo.getPreco());
            }
        });

        // Resetar lista
        btnResetar.addActionListener(e -> atualizarLista(jogosOriginais));
    }

    private void atualizarLista(List<Game> jogos) {
        model.clear();
        jogos.forEach(model::addElement);
    }
}
