package starter.whendo.action;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class MainScreen {
    public static Target addButton = Target.the("add button")
            .located(By.id("com.vrproductiveapps.whendo:id/fab"));
    public static Target titleTextBox = Target.the("title text box")
            .located(By.id("com.vrproductiveapps.whendo:id/noteTextTitle"));
    public static Target notesTextBox = Target.the("notes textbox")
            .located(By.id("com.vrproductiveapps.whendo:id/noteTextNotes"));
    public static Target saveButton = Target.the("save button")
            .located(By.id("com.vrproductiveapps.whendo:id/saveItem"));
    public static Target titleLabel = Target.the("title label")
            .located(By.id("com.vrproductiveapps.whendo:id/home_list_item_text"));
    public static Target notesLabel = Target.the("notes label")
            .located(By.id("com.vrproductiveapps.whendo:id/home_list_item_text2"));
}
