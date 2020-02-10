package ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CartPage extends PageObject {
    public static Target cart = Target.the("Cart-Button")
            .locatedBy("//*[@id=\"hlb-view-cart-announce\"]");

    public static Target productName = Target.the("Product-Name")
            .locatedBy("//*[@id=\"sc-item-C62f15ef2-4b35-42e7-a94b-64321b5e6658\"]/div[4]/div/div[1]/div/div/div[2]/ul/li[1]/span/a/span");

    public static Target productPrice = Target.the("Product-Price")
            .located(By.cssSelector("span[class='a-size-medium a-color-price sc-price sc-white-space-nowrap sc-product-price sc-price-sign a-text-bold']"));
//    public String getProductPrice() {
//        waitABit(2000);
//        return getDriver()
//                .findElement(By.ByClassName.className("a-size-medium a-color-price sc-price sc-white-space-nowrap sc-product-price sc-price-sign a-text-bold"))
//                .getText();
//    }
}
