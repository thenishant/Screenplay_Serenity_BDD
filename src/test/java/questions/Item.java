package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import ui.CartPage;

public class Item implements Question<String> {

    public static Question displayed() {
        return new Item();
    }

    @Override
    public String answeredBy(Actor actor) {
        return Text
                .of(CartPage.productPrice)
                .viewedBy(actor)
                .asString()
                .replaceAll("[₹ ,.]", "");
    }
}
