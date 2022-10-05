package newpackage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyClass {
    public static void main(String[] args) {
    	System.setProperty("webdriver.chrome.driver","C:\\Users\\romak\\Chromedriver\\chromedriver.exe");
    	WebDriver driver = new ChromeDriver(); 
        String baseUrl = "https://www.selenium.dev/";
        String tagName = "";
        
        driver.get(baseUrl);
        tagName = driver.findElement(By.id("Selenium")).getTagName();
        System.out.println(tagName);
//        driver.close();
//        System.exit(0);
    	
    }
}