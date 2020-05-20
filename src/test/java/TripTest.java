import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import ui.ChosenTo;

@RunWith(SerenityRunner.class)
public class TripTest {

    @Managed
    WebDriver browser;
    Actor john;

    @Before
    public void setTheStage() {
        john = Actor.named("John");
        john.can(BrowseTheWeb.with(browser));
    }

    @Test
    public void bookATrainTicket() {
        john.has(ChosenTo.bookATrainTicket());
    }

}
