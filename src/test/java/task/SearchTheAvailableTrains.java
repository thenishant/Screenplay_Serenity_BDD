package task;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.Keys;
import ui.TrainFormPage;

public class SearchTheAvailableTrains implements Task {
    private final String from;
    private final String to;

    public SearchTheAvailableTrains(String from, String to) {
        this.from = from;
        this.to = to;
    }

    public static SearchTheAvailableFLightsBuilder from(String from) {
        return new SearchTheAvailableFLightsBuilder(from);
    }

    @Override
    @Step("{0} searches available tickets from #from to #to")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(from).into(TrainFormPage.FROM).thenHit(Keys.TAB),
                Enter.theValue(to).into(TrainFormPage.TO).thenHit(Keys.TAB),
                Click.on(TrainFormPage.SELECT_DATE_PICKER),
                Click.on(TrainFormPage.DEPART_DATE),
                Click.on(TrainFormPage.SEARCH_TICKETS)
        );
    }

    public static class SearchTheAvailableFLightsBuilder {
        private String from;

        public SearchTheAvailableFLightsBuilder(String from) {
            this.from = from;
        }

        public Performable to(String to) {
            return Instrumented.instanceOf(SearchTheAvailableTrains.class)
                    .withProperties(from, to);
        }
    }
}
