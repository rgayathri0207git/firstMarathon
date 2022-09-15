package firstMarathon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesforceOpportunity {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();

		//disable notifications
		//create instance
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-notifications");
		ChromeDriver driver=new ChromeDriver(options);
		JavascriptExecutor executor = (JavascriptExecutor)driver;

		//manage ur window
		driver.manage().window().maximize();

		//add wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Login to https://login.salesforce.com
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

		//Click on Opportunity tab 
		WebElement Opportunities = driver.findElement(By.xpath("//a[@title='Opportunities']"));
		executor.executeScript("arguments[0].click();", Opportunities);

		//Click on New button
		driver.findElement(By.xpath("//a[@title='New']")).click();

		//Enter 'your name' as account name
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("Gayathri");

		//choose close date
		driver.findElement(By.xpath("//input[@name='CloseDate']")).click();
		driver.findElement(By.xpath("//td[@class='slds-is-today']/span")).click();

		//click stage
		WebElement stage = driver.findElement(By.xpath("//label[text()='Stage']/parent::lightning-combobox//lightning-icon"));
		executor.executeScript("arguments[0].click();", stage);
		driver.findElement(By.xpath("//span[@title='Prospecting']")).click();

		//click save
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();

		//verify message
		WebElement success = driver.findElement(By.xpath("//span[contains(@class,'toastMessage')]/a"));
		System.out.println(success.getAttribute("title"));

		// Close the Browser
		driver.close();


	}

}
