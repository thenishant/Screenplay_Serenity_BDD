package ui;

import model.MainMenu;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ChosenTo implements Task {
    public static Performable bookATrainTicket() {
        return instrumented(ChosenTo.class);
    }

    @Override
    @Step("{0} has chosen to buy tickets")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Navigate.to(MainMenu.BuyTrainTicket)
        );
    }
}
