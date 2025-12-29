package testsuite;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.questions.Text;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import starter.whendo.action.MainScreen;

@ExtendWith(SerenityJUnit5Extension.class)
public class WhenDoTest {
    @BeforeEach
    public void openApp() {
        // Appium hub initialized
        OnStage.setTheStage(new OnlineCast());
    }

    @Test
    public void testWriteNote() {
        // Actions
        OnStage.theActorCalled("JBGroup")
                .attemptsTo(Click.on(MainScreen.addButton));
        OnStage.theActorInTheSpotlight()
                .attemptsTo(Enter.theValue("test title")
                        .into(MainScreen.titleTextBox));
        OnStage.theActorInTheSpotlight()
                .attemptsTo(Enter.theValue("test notes")
                        .into(MainScreen.notesTextBox));
        OnStage.theActorInTheSpotlight()
                .attemptsTo(Click.on(MainScreen.saveButton));
        // Expected result
        OnStage.theActorInTheSpotlight()
                .should(
                        GivenWhenThen.seeThat("check title added",
                                Text.of(MainScreen.titleLabel),
                                CoreMatchers.equalTo("test title")
                        )
                );
        OnStage.theActorInTheSpotlight()
                .should(
                        GivenWhenThen.seeThat("check notes added",
                                Text.of(MainScreen.notesLabel),
                                CoreMatchers.equalTo("test notes")
                        )
                );
    }
}
