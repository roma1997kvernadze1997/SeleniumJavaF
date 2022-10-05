package mk.ukim.finki.seleniumtesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class Methods {
	
	WebDriver driver;
	
	public Methods(WebDriver driver) {
		this.driver = driver;
	}
	
	 // Check title
    public void getTitle() {
    	
    	String expectedTitle = "";
        String actualTitle = "";
        actualTitle = driver.getTitle();
        System.out.println(actualTitle);
        
    	if (actualTitle.contentEquals(expectedTitle)) {
          System.out.println("Test Passed!");
        } else {
          System.out.println("Test Failed");
        }
    }
    
    //Get text
    public void getText() {
    	String name = driver.findElement(By.xpath("")).getText();
        System.out.println(name);
    }
    
    //Get text
    public void getText1() {
    	driver.findElement(By.partialLinkText("")).click();
    }
    
    //Close browser
    public void close() {
    	driver.close();
    }
    
    //SOME
    public void some() {
    	List<WebElement> links = driver.findElements(By.className("hdtb-mitem"));
    	System.out.println(links.toString());
	}
    
}
