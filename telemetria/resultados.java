// Define o pacote do arquivo, ajudando a organizar as classes do projeto.
package telemetria;

// Importação das bibliotecas necessárias para usar componentes de interface gráfica.
import javax.swing.*;
import java.util.List;

// Declaração da classe `resultados` que estende `JFrame`, permitindo que ela crie uma janela gráfica.
public class resultados extends JFrame {
    // Construtor da classe, que aceita uma lista de strings como parâmetro.
    public resultados(List<String> times) {
        super("Resultados"); // Chama o construtor da classe mãe JFrame com o título da janela "Resultados".
        setSize(300, 400); // Define o tamanho da janela como 300 pixels de largura por 400 pixels de altura.

        // Cria um objeto JTextArea, que é um componente de área de texto para exibir textos.
        JTextArea resultsArea = new JTextArea();
        // Loop através de cada string na lista `times` passada como argumento.
        for (String time : times) {
            resultsArea.append(time + "\n"); // Adiciona cada tempo ao JTextArea seguido de uma quebra de linha.
        }
        resultsArea.setEditable(false); // Define a área de texto como não editável, apenas para visualização.

        // Adiciona a área de texto dentro de um JScrollPane, que permite a rolagem se o conteúdo exceder o tamanho da área visível.
        add(new JScrollPane(resultsArea));
        // Define a operação padrão de fechamento da janela para descartar a janela quando fechada.
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
