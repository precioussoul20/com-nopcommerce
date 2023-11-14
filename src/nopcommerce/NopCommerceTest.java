package nopcommerce;
/*Project-1 - ProjectName : com-nopcommerce
        BaseUrl = https://demo.nopcommerce.com/
        1. Setup Chrome browser.
        2. Open URL.
        3. Print the title of the page.
        4. Print the current url.
        5. Print the page source.
        6. Navigate to Url.
        “https://demo.nopcommerce.com/login?returnUrl=
        %2F”
        7. Print the current url.
        8. Navigate back to the home page.
        9. Navigate to the login page.
        10. Print the current url.
        11. Refresh the page.
        12. Enter the email to email field.
        13. Enter the password to password field.
        14. Click on Login Button.
        15. Close the browser.*/

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class NopCommerceTest {

    static  String browser = "Chrome";
    static  String baseUrl = "https://demo.nopcommerce.com/";
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else {
            System.out.println("Wrong Browser name");
        }
        //
        // Open the Url into the Browser
        driver.get(baseUrl);
        Thread.sleep(5000);

        //Maximise the Browser
        driver.manage().window().maximize();

        // We give implicit wait to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Get the title of the page
        String title = driver.getTitle();
        System.out.println(title);
        Thread.sleep(5000);

        // Get the current Url
        System.out.println("The current Url" + driver.getCurrentUrl());

        // Get the page source
        System.out.println(driver.getPageSource());

        // Navigate to Url
        String loginUrl = "https://demo.nopcommerce.com/login?returnUrl=%2F";
        driver.navigate().to(loginUrl);
        Thread.sleep(5000);
        //print current Url
        System.out.println("Get current Url " + driver.getCurrentUrl());

        // Navigate back to Homepage
        driver.navigate().back();
        Thread.sleep(5000);

        //Navigate the Current Login Page
        driver.navigate().to(loginUrl);
        Thread.sleep(5000);

        // Print the current Url
        System.out.println("Get current Url " + driver.getCurrentUrl());

        // Refresh the page
        driver.navigate().refresh();

        // Enter the Email to email Field
        WebElement emailField = driver.findElement(By.id("Email"));
        emailField.sendKeys("prime123@gmail.com");
        Thread.sleep(5000);

        // Enter the password to the password field
        WebElement passwordField = driver.findElement(By.id("Password"));
        passwordField.sendKeys("Prime123");
        Thread.sleep(5000);

        // Click on Login Button
        WebElement loginButton = driver.findElement(By.xpath(("(//button[@type='submit'])[2]")));
        loginButton.click();
        Thread.sleep(5000);

        // close the browser
        driver.quit();
    }

}
