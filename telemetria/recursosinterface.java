// Define o pacote do arquivo, que é comum em projetos Java para organizar classes.
package telemetria;

// Declaração da classe `recursosinterface`.
public class recursosinterface {
    // Declaração de variáveis privadas para armazenar informações sobre o corredor e a equipe.
    // Essas variáveis são candidatas a serem interligadas com um banco de dados, por exemplo,
    // para armazenar informações sobre diferentes corredores e suas equipes em uma competição.
    private String corredor;
    private String equipe;

    // Construtor da classe que inicializa as variáveis `corredor` e `equipe` com valores fornecidos.
    public recursosinterface(String corredor, String equipe) {
        this.corredor = corredor;
        this.equipe = equipe;
    }

    // Método público que retorna o nome do corredor.
    // Pode ser usado para recuperar o nome do corredor de um objeto da classe,
    // útil para consultas ou exibições em interfaces de usuário.
    public String getnome_corredor() {
        return this.corredor;
    }

    // Método público que retorna o nome da equipe.
    // Pode ser usado para recuperar o nome da equipe de um objeto da classe,
    // útil para consultas ou exibições em interfaces de usuário.
    public String getnome_equipe() {
        return this.equipe;
    }
}
