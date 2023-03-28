package com.git;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class GitHubTokenGeneration {

	//private WebDriver driver = null;
	
	public static void main(String[] args) throws Throwable {

        // Set the ChromeDriver path
        System.setProperty("webdriver.chrome.driver", "C:/WebDrivers/chromedriver.exe");
        //WebDriver driver = new ChromeDriver();
        WebDriver driver = null;
                
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);

        // Navigate to GitHub user profile view
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
        
        //Navigate Settings
        /*
        //WebElement AvitarImahe = driver.findElement(By.xpath("//img[@class='avatar avatar-small circle']"));
        WebElement AvitarImage = driver.findElement(By.xpath("//div[7]/details/summary"));
        //WebElement SettingsLink = driver.findElement(By.xpath("//a[@role='menuitem'][normalize-space()='Settings']"));
        WebElement SettingsLink = driver.findElement(By.linkText("Settings")); //img[@alt='@mv8167'
        AvitarImage.click();	        
        SettingsLink.click();	        
        */

        //Navigate to Profile/user Settings
        driver.get("https://github.com/settings/profile");
        /*
        // WebElement Settings = driver.findElement(By.xpath("//details[@class='details-overlay details-reset js-feature-preview-indicator-container']/summary[@class='Header-link']");
        WebElement profileSettings = driver.findElement(By.xpath("//a[@role='menuitem'][normalize-space()='Settings']"));
        //a[@role='menuitem'][normalize-space()='Settings']
        profileSettings.click();
        */
        
        // Open developer settings link
        //WebElement developerSettings = driver.findElement(By.linkText("Developer Settings"));
        WebElement developerSettings = driver.findElement(By.xpath("//span[normalize-space()='Developer settings']"));
        developerSettings.click();
        
        // Open Personal tokens
        WebElement personalAccessTokens = driver.findElement(By.xpath("//span[normalize-space()='Personal access tokens']"));
        personalAccessTokens.click();
        
        // Click "Generate new token" button
        driver.get("https://github.com/settings/tokens");
        /*	
        WebElement generateTokenBtn = driver.findElement(By.xpath("//summary[@class='btn btn-sm select-menu-button']"));
        generateTokenBtn.click();
        */
        
        // Click "Tokens (classic) link
        WebElement generateTokenLink = driver.findElement(By.xpath("//span[normalize-space()='Tokens (classic)']"));
        generateTokenLink.click();
        
        // Fill in token details for "QA automations" token
        fillTokenDetails(driver, "QA automations", "7 days", "user, workflow");

        // Fill in token details for "Custom automations" token
        fillTokenDetails(driver, "Custom automations", "1/22/2024", "public_repo, read:user");

        // Quit the driver
        driver.quit();
    }

    private static void fillTokenDetails(WebDriver driver, String tokenName, String tokenExpiration, String tokenScopes) {
	
	    // Fill in token name
	    WebElement tokenNameInput = driver.findElement(By.xpath("//input[@id='oauth_access_description']"));
	    tokenNameInput.sendKeys(tokenName);

	    // Fill in token expiration
	    WebElement tokenExpirationInput = driver.findElement(By.xpath("//select[@id='oauth_access_default_expires_at']"));
	    tokenExpirationInput.sendKeys(tokenExpiration);
	
	    /*
	    // check default "repo" scope
	    WebElement repoScope = driver.findElement(By.xpath("//input[@name='scopes[]' and @value='repo']"));
	    if (repoScope.isSelected()) {
	        repoScope.click();
	    }
	    */
	
	    // Check specified token scopes
	    String[] scopes = tokenScopes.split(", ");
	    for (String scope : scopes) {
	        WebElement scopeCheckbox = driver.findElement(By.xpath("//input[@value='" + scope + "']"));
	        if (!scopeCheckbox.isSelected()) {
	            scopeCheckbox.click();
	        }
	    }
	    // Click Generate button
	    WebElement generateTokenBtn = driver.findElement(By.xpath("//button[normalize-space()='Generate token']"));
	    generateTokenBtn.click();
	}
}


