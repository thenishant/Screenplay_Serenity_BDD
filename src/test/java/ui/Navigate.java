package ui;

import model.MainMenu;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;

public class Navigate implements Interaction {

    private final MainMenu mainMenuOption;
    private BuyTrainTicketsPage buyTrainTicketsPage;

    public Navigate(MainMenu mainMenuOption) {
        this.mainMenuOption = mainMenuOption;
    }

    public static Performable to(MainMenu mainMenuOption) {
        return Instrumented.instanceOf(Navigate.class).withProperties(mainMenuOption);
    }

    @Override
    @Step("{0} navigates to #mainMenuOption")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.browserOn().the(buyTrainTicketsPage)
        );
    }
}
