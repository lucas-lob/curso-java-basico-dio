import java.util.Scanner;

public class Contador {

    public static void main(String[] args) {
        int firstNumber, secondNumber;
        Scanner scanner = new Scanner(System.in);

        System.out.print("=== DESAFIO DE CONTROLE DE FLUXO DA DIO ===\n");

        System.out.print("Insira o primeiro número: ");
        firstNumber = scanner.nextInt();

        System.out.print("Insira o segundo número: ");
        secondNumber = scanner.nextInt();

        try {
            printInterval(firstNumber, secondNumber);
        } catch (ParametrosInvalidosException e) {
            System.out.print("O segundo parâmetro deve ser maior que o primeiro");
        }

        scanner.close();
        System.out.print("=== FIM ===\n");
    }

    private static void printInterval(int firstNumber, int secondNumber) throws ParametrosInvalidosException {
        if(firstNumber > secondNumber){
            throw new ParametrosInvalidosException();
        } else {
            int actualNumber = firstNumber;

            for(int i = firstNumber; i <= secondNumber; i++){
                System.out.print("Imprimindo o número " + actualNumber + "\n");
                actualNumber++;
            }
        }
    }
}
