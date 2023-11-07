package rushi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;

public class AutomateFirefox {
    WebDriver driver;

    public AutomateFirefox() {
        // Set the path to GeckoDriver
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\rushi\\Downloads\\geckodriver-v0.33.0-win64\\geckodriver.exe");
        
        // Initialize the FirefoxDriver
        driver = new FirefoxDriver();
        
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); // Updated timeout value
        
        driver.get("https://www.dypcoei.edu.in/");
        
        // Validate the website's title
        String expectedTitle = "DR.D.Y.PATIL College of Engineering and Innovation";
        String actualTitle = driver.getTitle();
        
        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Title matches. Test passed.");
        } else {
            System.out.println("Title doesn't match. Test failed.");
        }

        // Find and click on specific elements (e.g., the Admissions link)z
        WebElement admissionsLink = driver.findElement(By.linkText("Admission"));
        admissionsLink.click();
        
     // Test Case 2: Navigation Menu Testing
        String[] menuItems = { "Home", "@DYPEF", "@DYPCOEI", "Departments", "Admission", "Placement", "IQAC", "R & D","Facilities","Activities","Careers"};
        for (String menuItem : menuItems) {
            WebElement link = driver.findElement(By.linkText(menuItem));
            link.click();
            String currentURL = driver.getCurrentUrl();
            if (currentURL.contains(menuItem.toLowerCase().replace(" ", ""))) {
                System.out.println("Failed to navigate to " + menuItem + " page. Test failed.");
            } else {
            	 System.out.println("Navigated to " + menuItem + " page. Test passed.");
            }
        }

    }

    public static void main(String[] args) {
        AutomateFirefox automate = new AutomateFirefox();
        
        // Add interactions with the webpage here
        
        automate.driver.quit(); // Close the WebDriver when done
    }
}
