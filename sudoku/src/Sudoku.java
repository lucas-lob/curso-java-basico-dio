
import com.sudoku.model.Board;
import com.sudoku.model.Space;
import com.sudoku.util.BoardTemplate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import static java.util.stream.Collectors.toMap;
import java.util.stream.Stream;

public class Sudoku {

    private final static Scanner scanner = new Scanner(System.in);

    private static Board board;
    private final static int BOARD_LIMIT = 9;
    private static int option = -1;

    public static void main(String[] args) throws Exception {
        final Map<String, String> positions = Stream.of(args).
                collect(toMap(
                        k -> k.split(";")[0],
                        v -> v.split(";")[1]));

        while (true) {
            System.out.println("Selecione uma das opções a seguir");
            System.out.println("1 - Iniciar um novo Jogo");
            System.out.println("2 - Colocar um novo número");
            System.out.println("3 - Remover um número");
            System.out.println("4 - Visualizar jogo atual");
            System.out.println("5 - Verificar status do jogo");
            System.out.println("6 - Limpar jogo");
            System.out.println("7 - Finalizar jogo");
            System.out.println("8 - Sair");

            option = scanner.nextInt();

            switch (option) {
                case 1 ->
                    startGame(positions);
                case 2 ->
                    insertNumber();
                case 3 ->
                    removesNumber();
                case 4 ->
                    showCurrentGame();
                case 5 ->
                    getGameStatus();
                case 6 ->
                    clearGame();
                case 7 ->
                    finishGame();
                case 8 ->
                    System.exit(0);
                default ->
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void startGame(Map<String, String> positions) {
        if (Objects.nonNull(board)) {
            System.out.println("O jogo já foi iniciado!");
            return;
        }

        board = new Board(createSpaces(positions));
        System.out.println("O jogo está pronto para começar!");
    }

    private static void insertNumber() {
        if (Objects.isNull(board)) {
            System.out.println("O jogo não foi iniciado!");
            return;
        }

        System.out.println("Insira um número: ");
        int value = runUntilGetValidNumber(1, 9);

        System.out.println("Agora, insira uma coluna:");
        int column = runUntilGetValidNumber(0, 8);

        System.out.println("Agora, insira uma linha:");
        int row = runUntilGetValidNumber(0, 8);

        if (!board.updateSpace(column, row, value)) {
            System.out.println("A posição (%s,%s) tem um valor fixo!".formatted(column, row));
        }
    }

    private static void removesNumber() {
        if (Objects.isNull(board)) {
            System.out.println("O jogo não foi iniciado!");
            return;
        }

        System.out.println("Insira uma coluna:");
        int column = runUntilGetValidNumber(0, 8);

        System.out.println("Agora, insira uma linha:");
        int row = runUntilGetValidNumber(0, 8);

        if (!board.clearSpace(column, row)) {
            System.out.println("A posição (%s,%s) tem um valor fixo!".formatted(column, row));
        }
    }

    private static void showCurrentGame() {
        if (Objects.isNull(board)) {
            System.out.println("O jogo não foi iniciado!");
            return;
        }

        Object[] args = new Object[81];
        int argPos = 0;

        for (int i = 0; i < BOARD_LIMIT; i++) {
            for (List<Space> col : board.getSpaces()) {
                args[argPos++] = " " + (Objects.isNull(col.get(i).getActualValue()) ? " " : col.get(i).getActualValue());
            }
        }

        System.out.println("Seu jogo se encontra dessa forma:");
        System.out.println(BoardTemplate.BOARD_TEMPLATE.formatted(args));
    }

    private static void getGameStatus() {
        System.out.println("O status do game é: ");
        System.out.println(board.getStatus().toString());
    }

    private static void clearGame() {
        if (Objects.isNull(board)) {
            System.out.println("O jogo não foi iniciado!");
            return;
        }

        board.resetBoard();
    }

    private static void finishGame() {
        if (Objects.isNull(board)) {
            System.out.println("O jogo não foi iniciado!");
            return;
        }
        
        if (board.gameIsFinished()) {
            System.out.println("Parabéns! Você finalizou o jogo");
        } else {
            System.out.println("Há algo errado no seu jogo!");
        }
    }

    private static List<List<Space>> createSpaces(Map<String, String> positions) {
        List<List<Space>> spaces = new ArrayList<>();

        for (int i = 0; i < BOARD_LIMIT; i++) {
            spaces.add(new ArrayList<>());

            for (int j = 0; j < BOARD_LIMIT; j++) {
                String[] spaceConfig = positions.get("%s,%s".formatted(i, j)).split(",");

                int spaceValue = Integer.parseInt(spaceConfig[0]);
                boolean spaceFixed = Boolean.parseBoolean(spaceConfig[1]);

                spaces.get(i).add(new Space(spaceValue, spaceFixed));
            }
        }

        return spaces;
    }

    private static int runUntilGetValidNumber(int min, int max) {
        var userInput = scanner.nextInt();
        while (userInput < min || userInput > max) {
            System.out.println("Você inseriu um valor inválido!");

            userInput = scanner.nextInt();
        }

        return userInput;
    }
}
 