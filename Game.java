import java.util.Scanner;

public class Game {
    private final MontyHallSimulator simulator = new MontyHallSimulator();
    private final Statistics statistics = new Statistics();
    private final Scanner scanner = new Scanner(System.in);

    public void start() {
        System.out.println("Добро пожаловать в игру Монти Холла!");
        int step = 1;

        while (true) {
            System.out.println("\nИгра №" + step);

            boolean switchChoice = askSwitchChoice();

            TestStep result = simulator.playRound(step, switchChoice);
            statistics.addStep(result);

            System.out.println(result);

            if (!askPlayAgain()) {
                break;
            }
            step++;
        }

        System.out.println("\nИгра завершена.");
        statistics.printStatistics();
        statistics.printDetails();
    }

    private boolean askSwitchChoice() {
        System.out.print("Хотите сменить дверь? (да/нет): ");
        return scanner.nextLine().trim().equalsIgnoreCase("да");
    }

    private boolean askPlayAgain() {
        System.out.print("Хотите сыграть еще раз? (да/нет): ");
        return scanner.nextLine().trim().equalsIgnoreCase("да");
    }
}

