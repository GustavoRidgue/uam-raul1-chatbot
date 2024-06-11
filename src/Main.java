import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Map que armazena pares chave-valor para saudações
        Map<String,String> palavrasChaves = popularPalavrasChave();
        // Map que armazena pares chave-valor da data e hora
        List<String> palavrasChaveData = Arrays.asList("data", "data e hora", "tempo");
        // Map que armazena pares chave-valor para despedidas
        List<String> palavrasChaveDespedida = Arrays.asList("sair", "tchau", "até");

        // Inicializar Scanner para ler o que for digitado no console
        Scanner scan = new Scanner(System.in);

        System.out.println("Qual seu nome?");
        String nome = scan.nextLine();

        System.out.println("Ola " + nome + " o que deseja perguntar?");

        // While para iniciar um loop infinito com a conversa do ChatBot até que saia do loop
        while(true) {
            String resp = scan.nextLine();

            // Verifica se usuário digitou palavra chave de despedida para encerrar o programa
            if (palavrasChaveDespedida.contains(resp.toLowerCase())) {
                System.out.println("Ate mais!");
                break;

            // Verifica se usuário digitou palavra chave de data para pegar a data atual
            } else if (palavrasChaveData.contains(resp.toLowerCase())) {
                System.out.println("A data autal e " + dataAtualFormatada());

            // Verifica se usuário digitou palavra chave
            } else if (palavrasChaves.containsKey(resp.toLowerCase())) {
                System.out.println(palavrasChaves.get(resp.toLowerCase()));

            // Caso não seja encontrado nenhuma palavra chave, perguntar novamente
            } else {
                System.out.println("Nao entendi o que quis dizer, poderia por favor reformular a pergunta");
            }
        }
    }

    // Método para retornar Map palavras chaves e suas respectivas respostas
    public static Map<String, String> popularPalavrasChave() {
        Map<String, String> palavras = new HashMap<>();

        palavras.put("oi", "Ola, tudo bem?");
        palavras.put("ola", "Ola, tudo bem?");
        palavras.put("opa", "Ola, tudo bem?");
        palavras.put("clima", "O tempo esta nublado");
        palavras.put("pais", "Este codigo foi criado no Brasil");
        palavras.put("piada", "Por que os quimicos sao otimos em resolver problemas? Porque eles tem todas as solucoes!");
        palavras.put("teste", "Teste funcionando");
        palavras.put("futebol", "Brasil e o pais do futebol");
        palavras.put("uam", "Universidade Anhembi Morumbi");
        palavras.put("bom dia", "Bom dia");
        palavras.put("boa tarde", "Boa tarde");
        palavras.put("boa noite", "Boa noite");
        palavras.put("grupo", "Grupo B08");

        return palavras;
    }

    // Método para pegar a data e hora atual
    public static String dataAtualFormatada() {
        LocalDateTime agora = LocalDateTime.now();
        DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("dd/MM/uuuu HH:mm:ss");

        return formatterData.format(agora);
    }
}
