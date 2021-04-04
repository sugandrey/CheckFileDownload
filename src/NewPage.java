import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewPage {
	
	private WebDriver driver;
	
	public NewPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By text = By.xpath("//div[@id='content']/div/p");
	private By downloadButton = By.xpath("//a[@id='download-url']");
	
	public WebElement getTestText() {
		return driver.findElement(text);
	}
	public WebElement getDownloadButton() {
		return driver.findElement(downloadButton);
	}

}
