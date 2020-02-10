package tasks;

import model.Product;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.questions.Text;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.ProductPage;
import utils.Context;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class AddThe implements Task, Question {
    private Product firstProduct;

    @FindBy(xpath = "//*[@id=\"productTitle\"]")
    private static WebElement productTitle;

    public AddThe(Product firstProduct) {
        this.firstProduct = firstProduct;
    }

    public static Performable FirstProductToCart(Product firstProduct) {
        String sessionVariable = ProductPage.getProductPrice(theActorInTheSpotlight())
                .replaceAll("[₹ ,.]", "");

        Serenity.setSessionVariable(Context.productPrice)
                .to(sessionVariable);
        return new AddThe(firstProduct);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Scroll.to(ProductPage.addItemToCart()),
                Click.on(ProductPage.addItemToCart())
        );
    }

    @Override
    public Object answeredBy(Actor actor) {
        return Text
                .of(ProductPage.productPrice)
                .viewedBy(actor)
                .asString();
    }
}
