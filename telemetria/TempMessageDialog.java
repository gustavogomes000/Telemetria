// Define o pacote do arquivo, ajudando na organização do projeto.
package telemetria;

// Importação das bibliotecas necessárias para usar componentes de interface gráfica e temporizadores.
import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

// Declaração da classe `TempMessageDialog` que estende `JDialog`, permitindo criar uma janela de diálogo.
public class TempMessageDialog extends JDialog {
    // Construtor da classe com parâmetros para a janela pai e a mensagem a ser exibida.
    public TempMessageDialog(JFrame parent, String message) {
        super(parent, "Mensagem", true); // Chama o construtor da classe mãe JDialog, configurando o título e o modal.
        setLayout(new BorderLayout()); // Define o layout da janela para BorderLayout.
        
        // Adiciona um rótulo com a mensagem ao centro da janela.
        add(new JLabel(message, SwingConstants.CENTER), BorderLayout.CENTER);
        setSize(300, 100); // Define o tamanho da janela como 300 pixels de largura por 100 pixels de altura.

        // Define a localização da janela de diálogo para ser centralizada no topo da janela pai.
        setLocationRelativeTo(parent); // Centraliza a janela em relação à janela pai.
        int x = parent.getLocation().x + (parent.getWidth() - getWidth()) / 2; // Calcula a posição x para centralizar horizontalmente.
        int y = parent.getLocation().y; // Posiciona a janela no topo da janela pai.
        setLocation(x, y); // Aplica as coordenadas calculadas.

        // Cria um novo Timer para gerenciar o fechamento automático da janela.
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                dispose(); // Fecha a janela quando o tempo do Timer expirar.
            }
        }, 2000); // Define o tempo do Timer para 2000 milissegundos (2 segundos).
    }
}
