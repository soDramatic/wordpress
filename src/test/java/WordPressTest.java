import org.junit.*;
import org.openqa.selenium.WebDriver;
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
        System.setProperty("webdriver.chrome.driver", "E:\\Programowanie\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Before
    public void setUp(){
        driver.get("https://pl.wordpress.com/");
        wp = new Wordpress(driver);
    }


    @Test
    public void loginTest() throws InterruptedException {

        Thread.sleep(5000);

        assertTrue("Button is not displayed", wp.getLoginButton().isDisplayed());
        wp.getLoginButton().click();
        Thread.sleep(3000);

        wp.getLoginTextbox().sendKeys("marcin123321");
        Thread.sleep(2000);
        assertEquals("This is not this same value", "marcin123321", wp.getLoginTextbox().getText());


        wp.getPasswordTextbox().sendKeys("Marcin1910");

        assertTrue("Button is not displayed", wp.getSubmitButton().isDisplayed());
        wp.getSubmitButton().click();
        Thread.sleep(3000);
    }

    @Test
    @Ignore
    public void newBlog() throws InterruptedException {

        Thread.sleep(5000);
        bp.getTitle().sendKeys("This is title.");
        assertEquals("Title is wrong", bp.getTitle(), "This is title.");


        assertTrue("Button is not displayed", bp.getBold().isDisplayed());
        bp.getBold().click();

        Thread.sleep(5000);
        driver.switchTo().frame(bp.getContents());
        assertEquals("Content is wrong", bp.getContents().getText(), "This is content");
        bp.getFrame().sendKeys("This is content");
        driver.switchTo().defaultContent();

        Thread.sleep(2000);
        assertTrue("Button is not displayed", bp.getPublishButton().isDisplayed());
        bp.getPublishButton().click();

        Thread.sleep(4000);
        assertTrue("Content is not published", bp.getLookEntry().isDisplayed());
        bp.getLookEntry().click();

    }

    @After
    public void tearDown(){
        //driver.quit();
    }

}
