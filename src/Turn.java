import java.time.LocalDate;
import java.time.DayOfWeek;

public class Turn {
    private LocalDate currentDate;

    public Turn() {
        this.currentDate = LocalDate.of(2020, 1, 1);
    }

    public void nextTurn() {
        currentDate = currentDate.plusDays(1);
    }

    public boolean isWorkDay() {
        DayOfWeek dayOfWeek = currentDate.getDayOfWeek();
        return dayOfWeek != DayOfWeek.SATURDAY && dayOfWeek != DayOfWeek.SUNDAY;
    }

    public void work() {
        if (isWorkDay()) {
            // pracuj samodzielnie oraz z Twoimi podwykonawcami i pracownikami
        } else {
            // pracuj samodzielnie
        }
    }
}