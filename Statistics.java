package the_monty_hall_paradox;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class Statistics {
    private final Map<Integer, TestStep> results = new HashMap<>();

    public void addResult(TestStep step) {
        results.put(step.getStepNumber(), step);
    }

    public long getWins(boolean switched) {
        return results.values().stream()
                .filter(step -> step.isWin() && step.isSwitched() == switched)
                .count();
    }

    public long getLosses(boolean switched) {
        return results.values().stream()
                .filter(step -> !step.isWin() && step.isSwitched() == switched)
                .count();
    }

    public void printSummary() {
        System.out.println("Общая статистика:");
        System.out.println("Всего игр: " + results.size());
        System.out.println("Побед (смена): " + getWins(true));
        System.out.println("Поражений (смена): " + getLosses(true));
        System.out.println("Побед (без смены): " + getWins(false));
        System.out.println("Поражений (без смены): " + getLosses(false));
    }

    public void printDetailedResults() {
        results.values().forEach(System.out::println);
    }
}

