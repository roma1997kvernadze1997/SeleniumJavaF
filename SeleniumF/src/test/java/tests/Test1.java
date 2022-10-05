package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.Methods;
import pages.API;

public class Test1 {
	
	WebDriver driver;
	
	@BeforeTest
	public void befortest() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\romak\\Chromedriver\\chromedriver.exe");
        String baseUrl = "https://demoqa.com/login";
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();
	}
	
	@Test(priority = 1)
	public void addBookToCollection() throws Exception {
		LoginPage logPage = new LoginPage(driver);
		logPage.userAuthentication("roma3", "@Roma1997");
		logPage.clickBookStore();
		logPage.chooseBook();
		logPage.clickAddToCollection();
	}
	
	@Test(priority = 2)
	public void checkBookAdded() throws Exception {
		LoginPage logPage = new LoginPage(driver);
		logPage.userAuthentication("roma3", "@Roma1997");
		logPage.verifyBookAdd();
	}
	
	@Test(priority = 3)
	public void deleteBookFromCollection() throws Exception {
		LoginPage logPage = new LoginPage(driver);
		logPage.userAuthentication("roma3", "@Roma1997");
		logPage.clickDeleteAllBooks();
		logPage.confirmDelete();
	}
	
	@Test(priority = 4)
	public void checkBookDeleted() throws Exception {
		LoginPage logPage = new LoginPage(driver);
		logPage.userAuthentication("roma3", "@Roma1997");
		logPage.verifyBookDeleted();
	}

	@Test(priority = 5)
	public void addBookFromAPI() throws Exception {
		API api = new API(driver);
		api.addBookToCollection();
	}
	
	@AfterTest
	public void aftertest() {
		driver.quit();
	}

}