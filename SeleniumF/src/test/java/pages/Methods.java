package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Methods {
	
	WebDriver driver;
	
	public Methods(WebDriver driver) {
		this.driver = driver;
	}

    
    //Get text
    public void getText() {
    	String name = driver.findElement(By.xpath("//a[@data-hveid='CAIQAw']")).getText();
        System.out.println(name);
    }
    
    //Get text
    public void getText1() {
    	driver.findElement(By.partialLinkText("")).click();
    }
}
