import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FileUpload {
	
	

	public static void main(String[] args) throws InterruptedException, IOException, AWTException {
		OutputFromFile output = new OutputFromFile();
		String downloadPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\chromedriver.exe");
		
		HashMap<String,Object> chromePrefs = new HashMap<String,Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadPath);
		ChromeOptions co = new ChromeOptions();
	
		co.setExperimentalOption("prefs", chromePrefs);
		WebDriver driver = new ChromeDriver(co);
		driver.get("");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("a[data-toggle='collapse']")).click();
		driver.findElement(By.cssSelector(".cta_four.phantom.dropdown-toggle")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.cssSelector("a[id='localFile']"));
		js.executeScript("arguments[0].click()", element);
		Runtime.getRuntime().exec("C:\\Users\\user\\Desktop\\fileUpload.exe");
		Thread.sleep(3000);
		WebElement text = element.findElement(By.xpath("//span[@id='file-info']"));
		String[] fileNames = text.getText().split(".pdf");
		String fileName = fileNames[0];
		System.out.println(fileName);
		System.out.println(text.getText());
		System.out.println(output.getStringFromFile());
			if (output.getStringFromFile().contains(fileName)) {
				element.findElement(By.xpath("//input[@id='star-conversion-btn']")).click();
			}
			else {
				element.findElement(By.xpath("//input[@id='file-cancel']")).click();
			}
			NewPage page = new NewPage(driver);
			
		WebDriverWait wait = new WebDriverWait(driver, 10);		
		wait.until(ExpectedConditions.visibilityOf(page.getDownloadButton()));
		page.getDownloadButton().click();
		Thread.sleep(5000);
		File file = new File(downloadPath + "/LCBO_form.zip");
		if (file.exists()) {
			System.out.println("Success!!! The file LCBO_form.zip exists!!!");
			driver.close();
			file.delete();
			System.out.println("File deleted!!!");
		}
		else { System.out.println("Fail!!! The file doesn't not exists!!!");
			
		}
	}
}
