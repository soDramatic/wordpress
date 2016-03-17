import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Marcin on 2016-03-15.
 */
public class BlogPage {

    public BlogPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    private static final String NEW_BLOG = "//*[contains(@class, 'gridicons-create')]";
    private static final String TITLE = "//div/input[contains(@class, 'editor-title')]";
    private static final String CONTENTS = "//iframe[contains(@id, 'tinymce-1_ifr')]";
    private static final String BOLD = "//i[contains(@class,'mce-i-bold')]";
    private static final String FRAME = "//body/p";
    private static final String PUBLISH_BUTTON = "//div/button[contains(text(),'Opublikuj')]";
    private static final String LOOK_ENTRY = "//a/span[contains(text(),'Zobacz wpis')]";

    @FindBy(xpath = NEW_BLOG)
    private WebElement newBlog;

    @FindBy(xpath = TITLE)
    private WebElement title;

    @FindBy(xpath = CONTENTS)
    private WebElement contents;

    @FindBy(xpath = BOLD)
    private WebElement bold;

    @FindBy(xpath = FRAME)
    private WebElement frame;

    @FindBy(xpath = PUBLISH_BUTTON)
    private WebElement publishButton;

    @FindBy(xpath = LOOK_ENTRY)
    private WebElement lookEntry;

    public WebElement getNewBlog() {
        return newBlog;
    }

    public WebElement getContents(){
        return contents;
    }

    public WebElement getTitle(){
        return title;
    }

    public WebElement getBold(){
        return bold;
    }

    public WebElement getFrame(){
        return frame;
    }

    public WebElement getPublishButton(){
        return publishButton;
    }

    public WebElement getLookEntry(){
        return lookEntry;
    }

}



