import java.util.Scanner;

public class cesar {
    public static void main(Scanner scanner) {
        String opcao;

        do {
            System.out.println("\nEscolha a opção desejada:");
            System.out.println("1 - Criptografar mensagem");
            System.out.println("2 - Descriptografar mensagem");
            System.out.println("3 - Voltar para o menu principal");

            opcao = scanner.nextLine().trim();

            switch (opcao) {
                case "1":
                    criptografarMensagem(scanner);
                    break;
                case "2":
                    descriptografarMensagem(scanner);
                    break;
                case "3":
                    System.out.println("\nVoltando para o menu principal.");
                    break;
                default:
                    System.out.println("\nOpção inválida. Por favor, escolha uma opção válida.");
            }
        } while (!opcao.equals("3"));
    }

    public static void criptografarMensagem(Scanner scanner) {
        String texto;
        do {
            System.out.println("\nDigite o texto que você deseja criptografar:");
            texto = scanner.nextLine().toUpperCase();
            if (!texto.matches("[A-Z ]+")) {
                System.out.println("Texto em formato inadequado. Utilize apenas letras do alfabeto e espaços (sem caracteres especiais ou números).");
            }
        } while (!texto.matches("[A-Z ]+"));

        int nivel;
        do {
            System.out.println("Digite o nível de criptografia (um número inteiro entre 1 e 25):");
            while (!scanner.hasNextInt()) {
                System.out.println("Nível de criptografia inválido. Insira um número inteiro entre 1 e 25.");
                scanner.next(); // Limpar o buffer do scanner
            }
            nivel = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner
        } while (nivel < 1 || nivel > 25);

        String mensagemCriptografada = criptografarTexto(texto, nivel);
        System.out.println("Mensagem criptografada: " + mensagemCriptografada);

        realizarNovaAcao(scanner);
    }

    public static void descriptografarMensagem(Scanner scanner) {
        String texto;
        do {
            System.out.println("\nDigite o texto que você deseja descriptografar:");
            texto = scanner.nextLine().toUpperCase();
            if (!texto.matches("[A-Z ]+")) {
                System.out.println("Texto em formato inadequado. Utilize apenas letras do alfabeto e espaços (sem caracteres especiais ou números).");
            }
        } while (!texto.matches("[A-Z ]+"));

        int nivel;
        do {
            System.out.println("Digite o nível de descriptografia (um número inteiro entre 1 e 25):");
            while (!scanner.hasNextInt()) {
                System.out.println("Nível de descriptografia inválido. Insira um número inteiro entre 1 e 25.");
                scanner.next(); // Limpar o buffer do scanner
            }
            nivel = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner
        } while (nivel < 1 || nivel > 25);

        String mensagemDescriptografada = descriptografarTexto(texto, nivel);
        System.out.println("Mensagem descriptografada: " + mensagemDescriptografada);

        realizarNovaAcao(scanner);
    }

    public static String criptografarTexto(String texto, int nivel) {
        StringBuilder resultado = new StringBuilder();

        for (int i = 0; i < texto.length(); i++) {
            char caractere = texto.charAt(i);
            if (caractere == ' ') {
                resultado.append(' ');
            } else {
                char novoCaractere = (char) ('A' + (caractere - 'A' + nivel) % 26);
                resultado.append(novoCaractere);
            }
        }

        return resultado.toString();
    }

    public static String descriptografarTexto(String texto, int nivel) {
        StringBuilder resultado = new StringBuilder();

        for (int i = 0; i < texto.length(); i++) {
            char caractere = texto.charAt(i);
            if (caractere == ' ') {
                resultado.append(' ');
            } else {
                char novoCaractere = (char) ('A' + (caractere - 'A' - nivel + 26) % 26);
                resultado.append(novoCaractere);
            }
        }

        return resultado.toString();
    }

    public static void realizarNovaAcao(Scanner scanner) {
        String opcao;
        do {
            System.out.println("\nO que deseja fazer agora?");
            System.out.println("1 - Inserir novo texto");
            System.out.println("2 - Sair do programa");

            opcao = scanner.nextLine().trim();

            switch (opcao) {
                case "1":
                    break;
                case "2":
                    System.out.println("\nEncerrando o programa. Até mais!");
                    System.exit(0);
                default:
                    System.out.println("\nOpção inválida. Por favor, escolha uma opção válida.");
            }
        } while (!opcao.equals("1") && !opcao.equals("2"));
    }

}
