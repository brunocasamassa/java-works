/**
 * WEB_CRAWLER_G._SEARCH 
 *
 * @author Aury0n
 */

package Selenium.webDriver;


import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebCrawler {

	public static void main(String[] args) throws InterruptedException {
		int i = 0;
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver(); //change to htmlUnit driver
		while (i < 1) {
			driver.get("https://www.google.com.br/");
			driver.findElement(By.name("q")).sendKeys("caçambas zona sul são paulo");
			driver.findElement(By.id("vs0p1c0")).click();
			driver.getPageSource();
			System.out.println(driver);
			i++;
		}
		// driver.get("https://www.priberam.pt/dlpo/");
		// driver.findElement(By.xpath("//[@id=\"wordMeaningContentPlaceHolder_wordMeaningControl_SearchDefinitionsRadio\"]")).sendKeys("eu");
		Thread.sleep(200);
		driver.quit();
		// *[@id="wordMeaningContentPlaceHolder_wordMeaningControl_SearchWordTextBox"]
		// *[@id="wordMeaningContentPlaceHolder_wordMeaningControl_SearchWordTextBox"]

	}

}