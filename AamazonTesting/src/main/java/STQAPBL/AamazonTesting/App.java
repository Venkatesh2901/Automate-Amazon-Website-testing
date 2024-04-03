package STQAPBL.AamazonTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class App 
{
	private static WebDriver driver;
	
	 public static void initializeDriver() {
	        // Set ChromeDriver path
	        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/java/drivers/chromedriver.exe");

	        driver = new ChromeDriver();
	    }
	 
	 
	 public static void searchAndAddToCart() {
	        driver.get("https://www.amazon.com");
	        driver.manage().window().maximize();

	        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
	        searchBox.sendKeys("AC");
	        searchBox.submit();

	        // Add delay for page load and element detection
	        try {
	            Thread.sleep(2000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }

	        driver.findElement(By.linkText("Portable Air Conditioners, 3-IN-1 Evaporative Swamp Cooler, Windowless Air Conditioner, 4 Modes & 3 Speeds, 12H Timer, Child Lock, Smart Remote & Touch Control, Portable Ac, Air Cooler for Room,Indoor")).click();
	        driver.findElement(By.id("add-to-cart-button")).click();
	        
	        driver.findElement(By.className("a-button-input")).click();
	    }
	 
	 
	 
	 public static void login(String number, String password) {
	        WebElement phone = driver.findElement(By.id("ap_email"));
	        phone.sendKeys(number);
	        phone.submit();

	        // Add delay for page load and element detection
	        try {
	            Thread.sleep(2000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }

	        WebElement passwordInput = driver.findElement(By.id("ap_password"));
	        passwordInput.sendKeys(password);
	        passwordInput.submit();
	    }
	 
	 
	 
     public static void main( String[] args ){  
        initializeDriver();

        searchAndAddToCart();

        login("919999999999", "abc@123");

        //driver.quit();
     }
}
