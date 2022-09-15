package firstMarathon;

import java.time.Duration;
import java.time.LocalDate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RedBus {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();


		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-notifications");
		ChromeDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Load https://www.redbus.in/
		driver.get("https://www.redbus.in/");

		// Type "Chennai" in the FROM text box
		WebElement from_ele = driver.findElement(By.xpath("//input[@data-message='Please enter a source city']"));
		from_ele.sendKeys("Chennai");
		Thread.sleep(3000);

		// Type "Bangalore" in the TO text box
		WebElement to_ele = driver.findElement(By.xpath("//input[@data-message='Please enter a destination city']"));
		to_ele.sendKeys("Bangalore");
		Thread.sleep(3000);

		// Select tomorrow's date in the Date field
		driver.findElement(By.xpath("//input[@id='onward_cal']")).click();
		driver.findElement(By.xpath("(//td[@class='wd day'])[1]")).click();

		// Click Search Buses
		driver.findElement(By.xpath("//button[@id='search_btn']")).click();

		// Print the number of buses shown as results
		String busFound = driver.findElement(By.xpath("//span[@class='w-60 d-block d-found']/span")).getText();
		System.out.println(busFound);
		Thread.sleep(3000);

		// Close the redbus primo notification
		driver.findElement(By.xpath("//div[@class='tripleFive-block']//div[@class='close-primo']")).click();

		// Choose SLEEPER in the left menu
		driver.findElement(By.xpath("//label[@for='bt_SLEEPER']")).click();

		//click on view seats
		driver.findElement(By.xpath("(//div[text()='View Seats'])[1]")).click();

		//print the starting price
		String fare = driver.findElement(By.xpath("(//div[@class='fare d-block'])[1]//span")).getText();
		System.out.println(fare);

		//Print the available seats
		String seats = driver.findElement(By.xpath("(//div[@class='seat-left m-top-30'])[1]")).getText();
		System.out.println(seats);
		driver.close();
	}

}
