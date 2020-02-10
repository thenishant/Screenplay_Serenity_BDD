package ui;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;

public class ProductPage {

    public static Target productName = Target.the("Product-Name")
            .locatedBy("//*[@id=\"productTitle\"]");

    public static Target productPrice = Target.the("Product-Name")
            .locatedBy("//*[@id=\"priceblock_dealprice\"]");

    public static Target addItemToCart() {
        return Target.the("First-Item")
                .locatedBy("//*[@id=\"add-to-cart-button\"]");
    }

    public static String getProductPrice(Actor actor) {
        return Text
                .of(ProductPage.productPrice)
                .viewedBy(actor)
                .asString();
    }
}
