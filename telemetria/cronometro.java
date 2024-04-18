// Define o pacote do arquivo, organizando as classes logicamente.
package telemetria;

// Importação das bibliotecas necessárias para manipulação de componentes gráficos e eventos.
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

// Declaração da classe 'cronometro' que estende 'JFrame' para criar uma janela e implementa 'ActionListener' para tratar eventos.
public class cronometro extends JFrame implements ActionListener {
    // Componentes de interface gráfica para mostrar informações e receber interações do usuário.
    private JLabel labelTimer, labelPilotoEquipe;  // Rótulos para mostrar o tempo e os dados do piloto/equipe.
    private JButton buttonStart, buttonStop, buttonReset, buttonSave, buttonNew, buttonResults;  // Botões para diferentes ações.
    private Timer timer;  // Timer para atualizar o cronômetro.
    private long startTime;  // Armazena o momento de início do cronômetro.
    private int lapNumber = 1;  // Contador de voltas.
    private String piloto, equipe;  // Dados do piloto e da equipe, candidatos para armazenamento no banco de dados.
    private List<String> savedTimes = new ArrayList<>();  // Lista para armazenar os tempos marcados,  uso em banco de dados. bd 

    // Construtor que inicializa a janela e seus componentes.
    public cronometro(String piloto, String equipe) {
        super("Cronômetro - " + piloto + " - " + equipe);  // Título da janela com nome do piloto e equipe.
        this.piloto = piloto;//ligar no bd
        this.equipe = equipe;//ligar no bd
        setSize(800, 500);  // Define o tamanho da janela.
        setLayout(new BorderLayout(10, 10));  // Define o layout como BorderLayout com espaçamento.
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  // Define o comportamento ao fechar a janela.

        // Cria e configura o rótulo com informações do piloto e da equipe.
        labelPilotoEquipe = new JLabel("Piloto: " + piloto + " | Equipe: " + equipe, SwingConstants.CENTER);
        labelPilotoEquipe.setFont(new Font("Serif", Font.BOLD, 18));

        // Cria e configura o rótulo do cronômetro.
        labelTimer = new JLabel("00:00:00.000", SwingConstants.CENTER);
        labelTimer.setFont(new Font("Serif", Font.BOLD, 32));

        // Painel para organizar os botões.
        JPanel panelButtons = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonStart = new JButton("Iniciar");
        buttonStop = new JButton("Parar");
        buttonReset = new JButton("Resetar");
        buttonSave = new JButton("Salvar volta");
        buttonNew = new JButton("Novo Grid");
        buttonResults = new JButton("Resultados");

        // Adiciona o tratamento de evento para os botões.
        buttonStart.addActionListener(this);
        buttonStop.addActionListener(this);
        buttonReset.addActionListener(this);
        buttonSave.addActionListener(this);
        buttonNew.addActionListener(this);
        buttonResults.addActionListener(this);

        // Adiciona os botões ao painel e este à janela.
        panelButtons.add(buttonStart);
        panelButtons.add(buttonStop);
        panelButtons.add(buttonReset);
        panelButtons.add(buttonSave);
        panelButtons.add(buttonNew);
        panelButtons.add(buttonResults);

        // Adiciona os componentes à janela.
        add(labelPilotoEquipe, BorderLayout.NORTH);
        add(labelTimer, BorderLayout.CENTER);
        add(panelButtons, BorderLayout.SOUTH);

        // Inicializa o Timer para atualizar o cronômetro.
        timer = new Timer(1, e -> updateTimer());
    }

    // Método para atualizar o display do cronômetro.
    private void updateTimer() {
        long elapsedTime = System.currentTimeMillis() - startTime;
        long millis = elapsedTime % 1000;
        long second = (elapsedTime / 1000) % 60;
        long minute = (elapsedTime / (1000 * 60)) % 60;
        labelTimer.setText(String.format("%02d:%02d:%03d", minute, second, millis));
    }

    // Método implementado da interface ActionListener para responder a eventos.
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == buttonStart) {
            startTime = System.currentTimeMillis();
            timer.start();
        } else if (source == buttonStop) {
            timer.stop();
        } else if (source == buttonReset) {
            timer.stop();
            labelTimer.setText("00:00:00.000");
            lapNumber = 1;
        } else if (source == buttonSave) {
            String time = labelTimer.getText();
            savedTimes.add("Volta " + lapNumber + ": " + time + " - Piloto: " + piloto + ", Equipe: " + equipe);
            lapNumber++;
            new TempMessageDialog(this, "Volta marcada").setVisible(true);
        } else if (source == buttonNew) {
            this.dispose();
            new Interface01().setVisible(true);
        } else if (source == buttonResults) {
            new resultados(savedTimes).setVisible(true);
        }
    }

    // Método principal para executar a aplicação.
    public static void main(String[] args) {
        new cronometro("Piloto Teste", "Equipe Teste").setVisible(true);
    }
}
