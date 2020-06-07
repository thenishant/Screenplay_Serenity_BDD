package ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class TrainFormPage extends PageObject {
    public static Target FROM = Target.the("From")
            .located(By.cssSelector("input[name='from.text']"));

    public static Target TO = Target.the("To")
            .located(By.cssSelector("input[name='to.text']"));

    public static Target SELECT_DATE_PICKER = Target.the("date picker")
            .located(By.cssSelector("input[id='page.journeySearchForm.outbound.title']"));

    public static Target DEPART_DATE = tomorrowsDate();

    public static Target SEARCH_FLIGHTS = Target.the("Search flight")
            .located(By.cssSelector("button[data-test='submit-journey-search-button'"));

    public static Target tomorrowsDate() {
        return Target.the("Tomorrow's Date")
                .located(By.cssSelector(String.format("a[id= 'page.journeySearchForm.outbound.title%s']", getTomorrowsDate())));
    }

    private static String getTomorrowsDate() {
        Date date = new Date();
        LocalDateTime localDateTime = LocalDateTime.from(date.toInstant().atZone(ZoneId.of("UTC"))).plusDays(1);
        int dayOfMonth = localDateTime.getDayOfMonth();
        int month = localDateTime.getMonthValue();
        return String.format("%d-%d", month, dayOfMonth);
    }
}
