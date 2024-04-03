import java.util.Scanner;

public class morse {
    public static void main(Scanner mensagem) {
        String opcao;

        do {
            System.out.println("\nEscolha a opção desejada:");
            System.out.println("1 - Traduzir texto para código Morse");
            System.out.println("2 - Traduzir código Morse para texto");
            System.out.println("3 - Voltar para o menu principal");

            opcao = mensagem.nextLine().trim();

            switch (opcao) {
                case "1":
                    textoParaMorse(mensagem);
                    break;
                case "2":
                    morseParaTexto(mensagem);
                    break;
                case "3":
                    System.out.println("Voltando para o menu principal.");
                    return; // Retorna ao menu principal
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
        } while (!opcao.equals("3"));
    }

    public static void textoParaMorse(Scanner scanner) {
        String texto;

        do {
            System.out.println("\nDigite o texto que você deseja converter para código Morse:");
            texto = scanner.nextLine().toUpperCase();

            if (!texto.matches("[A-Z0-9 ]+")) {
                System.out.println("Texto em formato inadequado. Utilize apenas letras do alfabeto, números e espaços (sem caracteres especiais).");
            }
        } while (!texto.matches("[A-Z0-9 ]+")); // Continua no loop até que a entrada seja válida

        StringBuilder morse = new StringBuilder();
        for (int i = 0; i < texto.length(); i++) {
            char caractere = texto.charAt(i);
            String codigo = "";

            if (caractere >= 'A' && caractere <= 'Z') {
                codigo = MORSE_CODE[caractere - 'A'];
            } else if (caractere >= '0' && caractere <= '9') {
                codigo = MORSE_CODE[26 + (caractere - '0')];
            } else if (caractere == ' ') {
                codigo = "/";
            }

            morse.append(codigo).append(" ");
        }

        System.out.println("Texto em código Morse: " + morse.toString().trim());
        realizarNovaTraducao(scanner);
    }

    public static void morseParaTexto(Scanner scanner) {
        String morse;

        do {
            System.out.println("\nPara traduzir o código Morse adequadamente, é necessário acrescentar um espaço em branco (' ') entre cada letra e uma barra (/) entre cada palavra.");
            System.out.println("Digite o código Morse que você deseja converter para texto:");
            morse = scanner.nextLine();

            if (!morse.matches("[\\.\\-\\s/]+")) {
                System.out.println("Código Morse em formato inadequado. Utilize apenas pontos (.) e traços (-) para representar letras, espaços para separar letras e barras (/) para separar palavras.");
            }
        } while (!morse.matches("[\\.\\-\\s/]+")); // Continua no loop até que a entrada seja válida

        StringBuilder texto = new StringBuilder();
        String[] palavras = morse.split("\\s*/\\s*");
        for (String palavra : palavras) {
            String[] letras = palavra.split("\\s+");
            for (String letra : letras) {
                char caractere = '?';
                for (int i = 0; i < MORSE_CODE.length; i++) {
                    if (MORSE_CODE[i].equals(letra)) {
                        if (i < 26) {
                            caractere = (char) ('A' + i);
                        } else {
                            caractere = (char) ('0' + (i - 26));
                        }
                        break;
                    }
                }
                texto.append(caractere);
            }
            texto.append(" ");
        }

        System.out.println("Código Morse convertido para texto: " + texto.toString().trim());
        realizarNovaTraducao(scanner);
    }

    public static void realizarNovaTraducao(Scanner scanner) {
        String opcao;
        do {
            System.out.println("\nO que deseja fazer agora?");
            System.out.println("1 - Fazer nova tradução");
            System.out.println("2 - Sair do programa");

            opcao = scanner.nextLine().trim();

            switch (opcao) {
                case "1":
                    // Continuar com nova tradução
                    break;
                case "2":
                    System.out.println("\nEncerrando o programa. Até mais!");
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
        } while (!opcao.equals("1") && !opcao.equals("2"));
    }

    // Tabela de códigos Morse para letras A-Z e números 0-9
    private static final String[] MORSE_CODE = {
        ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.",
        "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..",
        "-----", ".----", "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----."
    };
}