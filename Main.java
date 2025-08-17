import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Game> jogos = new ArrayList<>();
        jogos.add(new Game("The Witcher 3", 99.90, "RPG"));
        jogos.add(new Game("Minecraft", 79.90, "Sandbox"));
        jogos.add(new Game("GTA V", 119.90, "Ação"));

        Cliente cliente = new Cliente("Marcela", 200);

        SwingUtilities.invokeLater(() -> {
            Janela janela = new Janela(cliente, jogos);
            janela.setVisible(true);
        });
    }
}
