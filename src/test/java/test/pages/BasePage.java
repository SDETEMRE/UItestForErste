package test.pages;
import org.openqa.selenium.support.PageFactory;
import test.utilities.Driver;

public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }
}