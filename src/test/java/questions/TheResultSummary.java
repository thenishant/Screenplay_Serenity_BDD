package questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import ui.TrainResultSummaryPage;

public class TheResultSummary {
    public static Question<String> origin() {
        return actor -> Text.of(TrainResultSummaryPage.ORIGIN).viewedBy(actor).asString();
    }

    public static Question<String> destination() {
        return actor -> Text.of(TrainResultSummaryPage.DESTINATION).viewedBy(actor).asString();
    }
}
