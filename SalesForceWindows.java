package home.week4.day1;


import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesForceWindows {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//Pseudo Code
		
	    //1. Launch the browser 
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));	
		
		//2. Load the URL "https://login.salesforce.com/"
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		
		//3 &4. Enter UserName and Password 
		driver.findElement(By.id("username")).sendKeys("ramkumar.ramaiah@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Password$123");
		
		//5. Click on Login Button 
		driver.findElement(By.id("Login")).click();
		//6. Click on Learn more option
		driver.findElement(By.xpath("//button[@title='Learn More']")).click();
		
	    //7.Navigating to second window
		String parentwindow =driver.getWindowHandle();
		System.out.println(parentwindow);
		Set<String> windows=driver.getWindowHandles();
		List<String> windowslist=new ArrayList<String>(windows);
		driver.switchTo().window(windowslist.get(1));
	
		//8. Click on Confirm
		driver.findElement(By.xpath("//button[text()='Confirm']")).click();
		
		// 9. Get the title
		String titlenameofSecondWindow=driver.getTitle();
		System.out.println("The title of the second window is" +titlenameofSecondWindow);
		
		//10.Back to parent window
		driver.switchTo().window(parentwindow);
		
		//11.close the window
		driver.quit();
		
	}

}
