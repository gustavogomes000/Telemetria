// Define o pacote do arquivo, organizando as classes de maneira lógica.
package telemetria;

// Importações das bibliotecas para manipulação de componentes gráficos e eventos.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// Declaração da classe Interface01 que estende JFrame (cria uma janela) e implementa ActionListener (trata eventos).
public class Interface01 extends JFrame implements ActionListener {
    // Declaração de variáveis para os rótulos (labels) dos campos de texto.
    private JLabel labelPiloto, labelEquipe;  // Variáveis para os rótulos dos campos de entrada.
    private JTextField textPiloto, textEquipe;  // Variáveis para entrada de texto - potencial armazenamento no banco de dados.
    private JButton buttonIniciar;  // Variável para o botão que inicia o processo.

    // Construtor da classe que inicializa a interface gráfica.
    public Interface01() {
        super("Dados do Piloto e Equipe"); // Título da janela.
        setSize(370, 300); // Define o tamanho da janela.
        setLayout(new FlowLayout()); // Define o layout da janela para o tipo FlowLayout.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Define a operação de fechamento (fechar a aplicação ao fechar a janela).

        // Inicialização dos componentes da interface.
        labelPiloto = new JLabel("Nome do piloto:"); // Cria um rótulo para o nome do piloto.
        textPiloto = new JTextField(20); // Cria um campo de texto para entrada do nome do piloto. lincar no banco 
        labelEquipe = new JLabel("Nome da equipe:"); // Cria um rótulo para o nome da equipe.
        textEquipe = new JTextField(20); // Cria um campo de texto para entrada do nome da equipe. lincar no banco 
        buttonIniciar = new JButton("Iniciar"); // Cria um botão com o texto "Iniciar".

        // Adiciona os componentes à janela.
        add(labelPiloto);  // Adiciona o rótulo do piloto à janela.
        add(textPiloto);  // Adiciona o campo de texto do piloto à janela.
        add(labelEquipe);  // Adiciona o rótulo da equipe à janela.
        add(textEquipe);  // Adiciona o campo de texto da equipe à janela.
        add(buttonIniciar);  // Adiciona o botão à janela.

        // Adiciona um listener ao botão para tratar o evento de clique.
        buttonIniciar.addActionListener(this);  // Configura a janela para responder ao clique no botão.
    }

    // Método obrigatório por implementar a interface ActionListener, chamado quando um evento ocorre.
    public void actionPerformed(ActionEvent e) {
        String piloto = textPiloto.getText().trim();  // Recupera e limpa o texto do campo do piloto.
        String equipe = textEquipe.getText().trim();  // Recupera e limpa o texto do campo da equipe.
        // Verifica se os campos não estão vazios.
        if (!piloto.isEmpty() && !equipe.isEmpty()) {
            this.setVisible(false);  // Esconde esta janela.
            new cronometro(piloto, equipe).setVisible(true);  // Cria e exibe uma nova janela de cronômetro.
        } else {
            // Exibe uma mensagem de erro se algum campo estiver vazio.
            JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos antes de iniciar o cronômetro.");
        }
    }

    // Método main para executar a aplicação.
    public static void main(String[] args) {
        Interface01 interface01 = new Interface01();  // Cria uma instância da janela.
        interface01.setVisible(true);  // Torna a janela visível.
    }
}
