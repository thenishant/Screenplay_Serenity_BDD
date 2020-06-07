import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import questions.TheResultSummary;
import task.SearchTheAvailableTrains;
import ui.ChosenTo;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SerenityRunner.class)
public class TripTest {

    @Managed
    WebDriver browser;
    Actor john;
    String origin = "Manchester";
    String destination = "Birmingham";

    @Before
    public void setTheStage() {
        john = Actor.named("John");
        john.can(BrowseTheWeb.with(browser));
    }

    @Test
    public void bookATrainTicket() {

        john.has(ChosenTo.bookATrainTicket());

        john.attemptsTo(SearchTheAvailableTrains.from(origin).to(destination));

        john.should(
                seeThat("The origin station", TheResultSummary.origin(), equalTo(origin)),
                seeThat("The destination station", TheResultSummary.destination(), equalTo(destination))
        );
    }

}
