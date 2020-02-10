package tasks;

import model.Category;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.waits.WaitUntil;
import ui.AmazonHomePage;
import ui.NavigationBar;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;


public class NavigateTo implements Task {
    private Category category;
    private AmazonHomePage amazonHomePage;

    public NavigateTo(Category category) {
        this.category = category;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.browserOn(amazonHomePage),
                Click.on(NavigationBar.category()),
                WaitUntil.the(NavigationBar.viewDeals(), isVisible()),
                Click.on(NavigationBar.viewDeals())
        );
    }

    public static Performable theCategory(Category category) {
        return new NavigateTo(category);
    }
}
