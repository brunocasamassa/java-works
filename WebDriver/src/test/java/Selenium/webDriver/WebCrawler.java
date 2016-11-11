/**
 * WEB_CRAWLER_GOOGLE_SEARCH 
 *
 * @author Aury0n
 */
package Selenium.webDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.*;

public class WebCrawler {

	public static void main(String[] args) throws InterruptedException {
		int i = 0;
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		while (i < 100) {
			driver.get("https://www.google.com.br/");
			driver.findElement(By.xpath("//*[@id=\"lst-ib\"]")).sendKeys("caçambas zona sul são paulo");
			driver.findElement(By.xpath("//*[@id=\"sblsbb\"]/button/span")).click();
			driver.findElement(By.className("ads-ad")).click();
	
			String texto = driver.findElement(
					By.xpath("//*[@id=\"content\"]/div[1]/p[3]/b[1]"))
					.getText();
			System.out.println(texto);
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