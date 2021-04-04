import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowPopUp {

	public static void main(String[] args) {
	
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://admin:admin@the-internet.herokuapp.com/");
		driver.findElement(By.xpath("//a[text()='Basic Auth']")).click();
		NewPage newPage = new NewPage(driver);
		System.out.println(newPage.getTestText().getText()); // The first way
//		Set<String> windows = driver.getWindowHandles(); // The second way
//		Iterator<String> iterator = windows.iterator();
//		String childWindow = iterator.next();
//		driver.switchTo().window(childWindow);
//		WebElement element = driver.findElement(By.xpath("//div[@id='content']/div/p"));
//		if(element.isDisplayed()) {
//			System.out.println(element.getText());
//			driver.close();
//		}
//		else {
//			System.out.println("No such element");
//			driver.close();
//		}
			
		
		driver.close();
	}

}
