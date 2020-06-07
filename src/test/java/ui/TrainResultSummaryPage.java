package ui;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class TrainResultSummaryPage extends PageObject {
    public static Target ORIGIN = Target.the("Departure")
            .located(By.cssSelector("strong[data-test='change-journey-header-origin']"));

    public static Target DESTINATION = Target.the("Arrival")
            .located(By.cssSelector("strong[data-test='change-journey-header-destination']"));
}
