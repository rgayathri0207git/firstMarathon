package firstMarathon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesforceContact {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();


		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-notifications");
		ChromeDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://login.salesforce.com/");
		
		//enter username
		driver.findElement(By.id("username")).sendKeys("ramkumar.ramaiah@testleaf.com");
		
		//enter password
		driver.findElement(By.id("password")).sendKeys("Password#123");
		
		//click login button
		driver.findElement(By.id("Login")).click();
		Thread.sleep(3000);
		
		//Click on toggle menu button from the left corner
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		
		//Click view All and click Sales from App Launcher
		driver.findElement(By.xpath("//button[@aria-label='View All Applications']")).click();
		driver.findElement(By.xpath("//div[@data-name='Sales']")).click();
		
		//Click on Accounts tab
		JavascriptExecutor executor = (JavascriptExecutor)driver;
	  	WebElement Account = driver.findElement(By.xpath("//a[@title='Accounts']"));
		executor.executeScript("arguments[0].click();", Account);
		Thread.sleep(3000);
		
		//Click on New button
		driver.findElement(By.xpath("//a[@title='New']")).click();
		
		//Enter 'your name' as account name
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("Gayathri");
		
		//Select Ownership as Public
		WebElement ownership = driver.findElement(By.xpath("//label[text()='Ownership']/parent::lightning-combobox//lightning-icon"));
		executor.executeScript("arguments[0].click();", ownership);		
		driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Public']")).click();
		
		//click save
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		
		//verify message
		WebElement success = driver.findElement(By.xpath("//span[contains(@class,'toastMessage')]/a"));
		System.out.println(success.getAttribute("title"));
		driver.close();
	}

}
