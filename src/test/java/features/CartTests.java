package features;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import questions.Item;
import tasks.AddThe;
import tasks.NavigateTo;
import tasks.SeeThe;
import utils.Context;

import static model.Category.CATEGORY;
import static model.Product.FIRST_PRODUCT;
import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SerenityRunner.class)
public class CartTests {

    @Managed(driver = "chrome")
    WebDriver browser;

    @Test
    public void shouldBeAbleToAddItemToCart() {

        OnStage.setTheStage(new OnlineCast());

        Actor james = theActorCalled("James");

        james.can(BrowseTheWeb.with(browser));

        when(james).attemptsTo(NavigateTo.theCategory(CATEGORY));

        and(james).attemptsTo(AddThe.FirstProductToCart(FIRST_PRODUCT));

        and(james).attemptsTo(SeeThe.cart());

        then(james).should(seeThat(Item.displayed(), equalTo(Serenity.sessionVariableCalled(Context.productPrice))));
    }
}
