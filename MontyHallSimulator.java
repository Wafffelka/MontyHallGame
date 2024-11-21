package the_monty_hall_paradox;

import java.util.Random;

public class MontyHallSimulator {
    private final Random random = new Random();

    public TestStep playRound(int stepNumber, boolean switchChoice) {
        int prizeDoor = random.nextInt(3) + 1;
        int playerChoice = random.nextInt(3) + 1;

        if (switchChoice) {
            playerChoice = findOtherDoor(prizeDoor, playerChoice);
        }

        boolean win = playerChoice == prizeDoor;
        return new TestStep(stepNumber, switchChoice, win);
    }

    private int findOtherDoor(int prizeDoor, int playerChoice) {
        for (int i = 1; i <= 3; i++) {
            if (i != playerChoice && i != prizeDoor) {
                return i;
            }
        }
        throw new IllegalStateException("Не удалось найти другую дверь.");
    }
}

}
