
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static int resourceID = 0;

    public static void main(String[] args) throws Exception {
        iPhone myPhone = new iPhone();

        System.out.println("====================");

        System.out.println("Seja bem vindo ao iPhone!");

        while (true) {
            do {
                System.out.println("Selecione um dos recurso: ");
                System.out.println("1 - Reprodutor musical");
                System.out.println("2 - Telefone");
                System.out.println("3 - Navegador de internet");

                resourceID = scanner.nextInt();
            } while (resourceID > 3 || resourceID < 1);

            switch (resourceID) {
                case 1 -> {
                    int optionID = 0;
                    do {
                        System.out.println("Selecione um dos recursos: ");
                        System.out.println("1 - Escolher música");
                        System.out.println("2 - Tocar música");
                        System.out.println("3 - Pausa música");
                        System.out.println("4 - Sair");

                        optionID = scanner.nextInt();
                    } while (optionID > 4 || optionID < 1);

                    switch (optionID) {
                        case 1 -> {
                            System.out.println("Insira o nome da música: ");
                            String musicName = scanner.next();
                            myPhone.selectMusic(musicName);
                        }
                        case 2 ->
                            myPhone.playMusic();
                        case 3 ->
                            myPhone.pauseMusic();
                        default -> {
                        }
                    }
                }

                case 2 -> {
                    int optionID = 0;
                    do {
                        System.out.println("Selecione um dos recurso: ");
                        System.out.println("1 - Ligar");
                        System.out.println("2 - Atender");
                        System.out.println("3 - Correio de voz");
                        System.out.println("4 - Sair");

                        optionID = scanner.nextInt();
                    } while (optionID > 4 || optionID < 1);

                    switch (optionID) {
                        case 1 -> {
                            System.out.println("Insira o número que deseja ligar: ");
                            String number = scanner.next();
                            myPhone.turnOn(number);
                        }
                        case 2 ->
                            myPhone.toResponde();
                        case 3 ->
                            myPhone.voiceMail();
                        default -> {
                        }
                    }
                }

                default -> {
                    int optionID = 0;
                    do {
                        System.out.println("Selecione um dos recurso: ");
                        System.out.println("1 - Nova aba");
                        System.out.println("2 - Carregar site");
                        System.out.println("3 - Atualizar a página");
                        System.out.println("4 - Sair");

                        optionID = scanner.nextInt();
                    } while (optionID > 4 || optionID < 1);

                    switch (optionID) {
                        case 1 ->
                            myPhone.newTab();
                        case 2 -> {
                            System.out.println("Insira o número que deseja ligar: ");
                            String url = scanner.next();
                            myPhone.showPage(url);
                        }
                        case 3 ->
                            myPhone.updatePage();
                        default -> {
                        }
                    }
                }
            }

            System.out.println("====================");
        }
    }
}
