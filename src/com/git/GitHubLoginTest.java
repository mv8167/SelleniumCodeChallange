package com.git;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;


	public class GitHubLoginTest {
	    //private WebDriver driver;
		private WebDriver driver = null;


		@BeforeTest
	    public void setUp() {
	        System.setProperty("webdriver.chrome.driver", "C:/WebDrivers/chromedriver.exe");
	        //driver = new ChromeDriver();
	        
	        //public static WebDriver driver;
	        //WebDriverManager.chromedriver().setup();
	        ChromeOptions options = new ChromeOptions();
	        options.addArguments("--remote-allow-origins=*");
	        /*options.addArguments("--disable notifications");
	        DesiredCapabilities cp = new DesiredCapabilities();
	        cp.setCapability(ChromeOptions.CAPABILITY, options);
	        options.merge(cp);*/
	        driver = new ChromeDriver(options);

	    }

		@AfterTest
	    public void tearDown() {
	      // 	driver.quit();
	    }

	    @Test(priority = 1)
	    public void testIncorrectLogin() throws Throwable {
	        driver.get("https://github.com/login");
	        WebElement usernameField = driver.findElement(By.id("login_field"));
	        WebElement passwordField = driver.findElement(By.id("password"));
	        WebElement signInButton = driver.findElement(By.name("commit"));

	        usernameField.sendKeys("incorrectusername");
	        passwordField.sendKeys("incorrectpassword");
	        signInButton.click();

	        //WebElement errorMessage = driver.findElement(By.xpath("//div[@class='js-flash-alert'"));
	        WebElement errorMessage = driver.findElement(By.xpath("//div[contains(text(),'Incorrect username or password.')]"));
	        String actualErrorMessage = errorMessage.getText();
	        String expectedErrorMessage = "Incorrect username or password.";
	        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
	        
	        //driver.wait(3000);
	        Thread.sleep(3000);
	    }

	    @Test(priority = 2)
	    public void testCorrectLogin() throws Throwable {
	        driver.get("https://github.com/login");
	        WebElement usernameField = driver.findElement(By.id("login_field"));
	        WebElement passwordField = driver.findElement(By.id("password"));
	        WebElement signInButton = driver.findElement(By.name("commit"));

	        usernameField.sendKeys("mv8167");
	        passwordField.sendKeys("Mike1995?mike1995?");
	        signInButton.click();

	        String expectedTitle = "GitHub";
	        String actualTitle = driver.getTitle();
	        Assert.assertEquals(actualTitle, expectedTitle);
	        
	        Thread.sleep(5000);
	        
	        
	    }
	}
