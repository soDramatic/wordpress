import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Marcin on 2016-03-15.
 */
public class Wordpress {


    public Wordpress(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    private static final String LOGIN_BUTTON = "//li[@class='login']";

    private static final String LOGIN_TEXTBOX = "//input[@id='user_login']";
    private static final String PASSWORD_TEXTBOX = "//input[@id='user_pass']";
    private static final String SUBMIT_BUTTON = "//input[@id='wp-submit']";

    private static final String NEW_BLOG = "//*[contains(@class, 'gridicons-create')]";


    @FindBy(xpath = LOGIN_BUTTON)
    private WebElement loginButton;

    @FindBy(xpath = LOGIN_TEXTBOX)
    private WebElement loginTextbox;

    @FindBy(xpath = PASSWORD_TEXTBOX)
    private WebElement passwordTextbox;

    @FindBy(xpath = SUBMIT_BUTTON)
    private WebElement submitButton;

    @FindBy(xpath = NEW_BLOG)
    private WebElement newBlog;



    public WebElement getLoginButton() {
        return loginButton;
    }

    public WebElement getLoginTextbox() {
        return loginTextbox;
    }

    public WebElement getPasswordTextbox() {
        return passwordTextbox;
    }

    public WebElement getSubmitButton() {
        return submitButton;
    }

    public WebElement getNewBlog() {
        return newBlog;
    }


    public BlogPage submitLoginForm(WebDriver driver) {

        return new BlogPage(driver);
    }
    public Wordpress fillUsername(String username) {

        return this;
    }



}
