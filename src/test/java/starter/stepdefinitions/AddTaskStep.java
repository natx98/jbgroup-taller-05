package starter.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.questions.Text;
import org.hamcrest.CoreMatchers;
import starter.whendo.action.MainScreen;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class AddTaskStep {
    Map<String, String> myVariables = new HashMap<String, String>();

    @Before
    public void hook() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("i have access to WhenDo")
    public void iHaveAccessToWhenDo() {}

    @And("i save random {}")
    public void iSaveRandomTask(String nameVariable) {
        myVariables.put(nameVariable, new Date().getTime() + "");
    }

    @When("i create new task:")
    public void iCreateNewTask(Map<String, String> data) {
        OnStage.theActorCalled("JBGroup")
                .attemptsTo(Click.on(MainScreen.addButton));
        OnStage.theActorInTheSpotlight()
                .attemptsTo(Enter.theValue(data.get("title"))
                        .into(MainScreen.titleTextBox));
        OnStage.theActorInTheSpotlight()
                .attemptsTo(Enter.theValue(data.get("notes"))
                        .into(MainScreen.notesTextBox));
        OnStage.theActorInTheSpotlight()
                .attemptsTo(Click.on(MainScreen.saveButton));

    }

    @Then("the task with title {string} and notes {string} should be created")
    public void theTaskShouldBeCreated(String expectedTitle, String expectedNotes) {
        OnStage.theActorInTheSpotlight()
                .should(
                        GivenWhenThen.seeThat("check title added",
                                Text.of(MainScreen.titleLabel),
                                CoreMatchers.equalTo(expectedTitle)
                        )
                );
        OnStage.theActorInTheSpotlight()
                .should(
                        GivenWhenThen.seeThat("check notes added",
                                Text.of(MainScreen.notesLabel),
                                CoreMatchers.equalTo(expectedNotes)
                        )
                );
    }

    @ParameterType(".*")
    public Actor actor(String actorName) {
        return OnStage.theActorCalled(actorName);
    }

}
