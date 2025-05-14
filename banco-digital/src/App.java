
import com.bank.external.Client;

public class App {

    public static void main(String[] args) {
        Client client1 = new Client("Lucas");
        Client client2 = new Client("Andressa");

        client1.createCurrentAccount("3881", "140191-1");
        client2.createCurrentAccount("3881", "140121-1");

        client1.deposit(1, 20);
        client2.deposit(1, 100);

        System.out.print("");

        if (client1.withdraw(1, 30)) {
            System.out.println("Withdrawal made!");
        } else {
            System.out.println("Insufficient balance!");
        }

        System.out.println("Before transfer:");
        System.out.println(client1.getCurrentAccountBankStatement());
        System.out.println(client2.getCurrentAccountBankStatement());

        if (client1.transfer(1, "140121-1", "3881", 10)) {
            System.out.println("Transfer made!");
        } else {
            System.out.println("Insufficient balance!");
        }

        System.out.println("After transfer:");
        System.out.println(client1.getCurrentAccountBankStatement());
        System.out.println(client2.getCurrentAccountBankStatement());
    }

}
