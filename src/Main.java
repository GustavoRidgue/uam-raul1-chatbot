import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Map<String, String> palavrasChaves = new HashMap<>();
        popularPalavrasChave(palavrasChaves);

        Scanner scan = new Scanner(System.in);
        System.out.println("Qual seu nome?");
        String nome = scan.nextLine();
        System.out.println("Olá " + nome + " o que deseja perguntar?");

        boolean continua = true;
        while(continua) {
            String resp = scan.nextLine();

            if (resp.equals("sair")) {
                System.out.println("Até mais!");
                continua = false;
            } else if (Arrays.asList("data", "hora", "data e hora").contains(resp)) {
                LocalDateTime agora = LocalDateTime.now();

                DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("dd/MM/uuuu HH:mm:ss");
                String dataFormatada = formatterData.format(agora);

                System.out.println("A data autal é " + dataFormatada);
            } else if (palavrasChaves.containsKey(resp)) {
                System.out.println(palavrasChaves.get(resp));
            } else {
                System.out.println("Não entendi o que quis dizer, poderia por favor reformular a pergunta");
            }
        }
    }

    public static void popularPalavrasChave(Map<String, String> palavras) {
        palavras.put("oi", "Olá, tudo bem?");
        palavras.put("ola", "Olá, tudo bem?");
        palavras.put("tempo", "O tempo está nublado");
        palavras.put("tchau", "a data e hora de hoje é ...");
    }

}