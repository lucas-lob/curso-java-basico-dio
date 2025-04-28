import java.util.Locale;
import java.util.Scanner;

public class ContaTerminal {

    public static void main(String[] args) throws Exception {
        String accountName;
        String accountAgency;
        int accountNumber;
        float accountBalance;

        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.ENGLISH);

        System.out.print("Olá! Vamos concluir o seu cadastro.\n");

        System.out.print("Insira o seu nome: ");
        accountName = scanner.nextLine();

        System.out.print("\nInsira o número de sua agência: ");
        accountAgency = scanner.nextLine();

        System.out.print("\nInsira o número da sua conta: ");
        accountNumber = scanner.nextInt();

        System.out.print("\nInsira o seu saldo: ");
        accountBalance = scanner.nextFloat();

        scanner.close();

        System.out.printf("\nOlá %s, obrigado por criar uma conta em nosso banco, sua agência é %s, conta %d e seu saldo %.2f já está disponível para saque", accountName, accountAgency, accountNumber, accountBalance);
    }
}
