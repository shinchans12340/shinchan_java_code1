import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoLoginTest {
    public static void main(String[] args) {
//add first line in java code 
        // Set ChromeDriver path (update with your local path)
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\chromedriver.exe");

        // Launch Chrome
        WebDriver driver = new ChromeDriver();

        try {
            // Open demo login page
            driver.get("https://the-internet.herokuapp.com/login");
            driver.manage().window().maximize();

            // Find username and password fields
            WebElement username = driver.findElement(By.id("username"));
            WebElement password = driver.findElement(By.id("password"));

            // Enter login credentials
            username.sendKeys("tomsmith");
            password.sendKeys("SuperSecretPassword!");

            // Click login button
            driver.findElement(By.cssSelector("button.radius")).click();

            // Verify login success
            WebElement message = driver.findElement(By.id("flash"));
            if (message.getText().contains("You logged into a secure area!")) {
                System.out.println("✅ Login Test Passed!");
            } else {
                System.out.println("❌ Login Test Failed!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close browser
           // add last line in java code for test 
            driver.quit();
        }
    }
}
