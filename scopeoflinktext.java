import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class scopeoflinktext {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\prasa\\Downloads\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		// to get link count of footer links
		WebElement footerdriver = driver.findElement(By.id("gf-BIG"));
		System.out.println(footerdriver.findElements(By.tagName("a")).size());
		
		//to get the links count of left column of footer
		WebElement columndriver = driver.findElement(By.xpath("//tbody/tr/td[1]/ul[1]"));
		System.out.println(columndriver.findElements(By.tagName("a")).size());
		
		//to open link and get the header of the link
		
		for (int i = 1;i<columndriver.findElements(By.tagName("a")).size();i++) 
		{
			
			String clickable = Keys.chord(Keys.CONTROL,Keys.ENTER);
			columndriver.findElements(By.tagName("a")).get(i).sendKeys(clickable);
			Thread.sleep(300);
		}
		Set<String> window = driver.getWindowHandles();
		Iterator<String> it = window.iterator();
		while (it.hasNext()) 
		{
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}

	}

}
