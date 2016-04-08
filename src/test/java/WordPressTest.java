import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


/**
 * Created by Marcin on 2016-03-15.
 */
public class WordPressTest {
    private static WebDriver driver;

    Wordpress wp;
    BlogPage bp;
    //Login: marcin123321
    //Pass: Marcin1910

    @BeforeClass
    public static void setUpBeforeClass(){
        System.setProperty("webdriver.chrome.driver", "D:\\Wordpress\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Before
    public void setUp(){
        driver.get("https://pl.wordpress.com/");
        wp = new Wordpress(driver);
        bp = new BlogPage(driver);
    }


    @Test
    public void loginTest() throws InterruptedException {

        Thread.sleep(5000);

        assertTrue("Button is not displayed", wp.getLoginButton().isDisplayed());
        wp.getLoginButton().click();
        Thread.sleep(3000);

        wp.getLoginTextbox().sendKeys("marcin123321");
        Thread.sleep(2000);
        assertEquals("This is not this same value", "marcin123321", wp.getLoginTextbox().getAttribute("value"));

        wp.getPasswordTextbox().sendKeys("Marcin1910");

        assertTrue("Button is not displayed", wp.getSubmitButton().isDisplayed());
        wp.getSubmitButton().click();
        Thread.sleep(3000);
    }

    @Test
    public void newBlogTest() throws InterruptedException {

        Thread.sleep(5000);
        assertTrue("There is not new article button", bp.getNewBlog().isEnabled());
        bp.getNewBlog().click();

        Thread.sleep(5000);
        bp.getTitle().sendKeys("This is title.");
        assertEquals("Title is wrong", bp.getTitle().getAttribute("value"), "This is title.");


        driver.switchTo().frame("tinymce-1_ifr");
        WebElement el = driver.findElement(By.xpath("//html//body"));
        el.clear();
        el.click();
        el.sendKeys("This is content");
        assertEquals("Content is wrong", "This is content", el.getText());
        driver.switchTo().defaultContent();

        Thread.sleep(2000);
        assertTrue("Button is not displayed", bp.getPublishButton().isDisplayed());
        bp.getPublishButton().click();

        Thread.sleep(7000);
        WebElement lookEntryButton = driver.findElement(By.xpath("//a/span[contains(text(),'Zobacz wpis')]"));
        assertTrue("Content is not published", lookEntryButton.isDisplayed());
        assertTrue("Button is not displayed", bp.getBold().isDisplayed());
        bp.getBold().click();

        Thread.sleep(5000);
        lookEntryButton.click();

    }

    @After
    public void tearDown(){
        //driver.quit();
    }

}
