package sit707_week2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BunningsLoginPageTest {
    private WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.bunnings.com.au/login");
    }
    
    @Test
	public void testStudentIdentity() {
    	String studentId = "220194805";
		Assert.assertNotNull("Student ID is: ", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Jayani Vithanage";
		Assert.assertNotNull("Student name is: ", studentName);
	}

    @Test
    public void testSuccessfulLogin() {
        WebElement userName = driver.findElement(By.id("okta-signin-username"));
        WebElement password = driver.findElement(By.id("okta-signin-password"));
        WebElement loginButton = driver.findElement(By.xpath("//input[@id='okta-signin-submit']"));

        userName.sendKeys("jayaniv.vithanag1@gmail.com");
        password.sendKeys("Deakin@321");
        loginButton.click();

        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals("https://www.bunnings.com.au/login", currentUrl);
    }

    @Test
    public void testLoginIncorrectPasswordFailed() {
    	WebElement userName = driver.findElement(By.id("okta-signin-username"));
        WebElement password = driver.findElement(By.id("okta-signin-password"));
        WebElement loginButton = driver.findElement(By.xpath("//input[@id='okta-signin-submit']"));

        userName.sendKeys("jayaniv.vithanage@gmail.com");
        password.sendKeys("Deakin@54321");
        loginButton.click();

        //checking the current url
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals("https://www.bunnings.com.au/login", currentUrl);
    }

    @Test
    public void testLoginIncorrectUsernameFailed() {
    	WebElement userName = driver.findElement(By.id("okta-signin-username"));
        WebElement password = driver.findElement(By.id("okta-signin-password"));
        WebElement loginButton = driver.findElement(By.xpath("//input[@id='okta-signin-submit']"));

        userName.sendKeys("abc@gmail.com");
        password.sendKeys("Deakin@321");
        loginButton.click();

        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals("https://www.bunnings.com.au/login", currentUrl);
    }

    @Test
    public void testLoginUserNameANDPasswordIncorrectFailed() {
    	WebElement userName = driver.findElement(By.id("okta-signin-username"));
        WebElement password = driver.findElement(By.id("okta-signin-password"));
        WebElement loginButton = driver.findElement(By.xpath("//input[@id='okta-signin-submit']"));

        userName.sendKeys("abc@gmail.com");
        password.sendKeys("deakin@#$123");
        loginButton.click();

        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals("https://www.bunnings.com.au/login", currentUrl);
    }
}

