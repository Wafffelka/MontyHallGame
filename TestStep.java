package the_monty_hall_paradox;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class TestStep {
    private final int stepNumber;
    private final boolean switched;
    private final boolean win;

    public String getResult() {
        return win ? "Победа" : "Поражение";
    }
}

