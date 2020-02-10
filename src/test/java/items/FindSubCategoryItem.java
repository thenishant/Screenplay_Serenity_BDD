package items;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import ui.NavigationBar;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class FindSubCategoryItem implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(NavigationBar.CATEGORY),
                WaitUntil.the(NavigationBar.SUBCATEGORY, isVisible()),
                Click.on(NavigationBar.SUBCATEGORY)
        );

    }
}
