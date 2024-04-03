import java.util.Scanner;

public class criptografia {
    public static void main(String[] args) {
        Scanner menu = new Scanner(System.in);

        while (true) {
            System.out.println("\nEscolha a ferramenta desejada:");
            System.out.println("1 - Tradutor de código Morse");
            System.out.println("2 - Cifra de César");
            System.out.println("3 - Sair do programa");

            String opcao = menu.nextLine().trim();

            switch (opcao) {
                case "1":
                    morse.main(menu);
                    break;
                case "2":
                    cesar.main(menu);
                    break;
                case "3":
                    System.out.println("Encerrando o programa. Até mais!");
                    menu.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
        }
    }
}
