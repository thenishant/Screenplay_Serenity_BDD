package ui;

import net.serenitybdd.screenplay.targets.Target;

public class NavigationBar {
    public static final Target CATEGORY = Target.the("").locatedBy("//*[@id=\"navbar\"]/ul/li[1]/a");
    public static final Target SUBCATEGORY = Target.the("").locatedBy("//*[@id=\"navBarMegaNav\"]/li[1]/aa");

    public static Target category() {
        return Target.the("category")
                .locatedBy("//*[@id=\"nav-xshop\"]/a[4]");
    }

    public static Target viewDeals() {
        return Target.the("subCategory")
                .locatedBy("//*[@id=\"101 b2ba84fd-announce\"]");
    }
}
