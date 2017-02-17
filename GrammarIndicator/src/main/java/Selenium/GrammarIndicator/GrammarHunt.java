/**
 *
 * GRAMMAR HUNT
 * 
 * @author bruno.casamassa
 *
 */

package Selenium.webDriver;

import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class GrammarHunt {
	static int p = 1;
	static int b = 3;

	static String texto = null;

	public static void main(String[] args) throws IOException, InterruptedException {
		Scanner scan = null;
		int i = 0;
		// Scanner scan = null;
		// eu anfibios a comandos bola é comandos com comandos nao brinca se
		// amora
		scan = new Scanner(
				new FileReader("C:\\Users\\Auryon.AURYON-PC\\Desktop\\flatWiki.txt"));

		// scan = new Scanner(new
		// File("C:\\Users\\Auryon.AURYON-PC\\Desktop\\flatWiki.txt"));

		String s = scan.toString();
		// System.out.println(s);
		// System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		while (scan.hasNextLine()) {
			WebDriver driver = new HtmlUnitDriver();
			s = scan.next();
			//System.out.println(s);
			driver.get("https://www.dicio.com.br/" + s);
			// driver.findElement(By.xpath("//*[@id=\"q\"]")).sendKeys(s);
			// driver.findElement(By.xpath("//*[@id=\"searchForm\"]/button/span")).click();
			try {
				driver.findElement(By.xpath("//*[contains(text(),'Classe gramatical:')]")); //RANGE ALVO
				List<WebElement> frame = driver.findElements(By.tagName("b"));  // CAPTURA GRAMATICA
				System.out.println(frame.get(0).getText());  //PRINT CLASSE GRAMATICAL
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			driver.quit();

		}

		// }

		

		// driver.get("https://www.priberam.pt/dlpo/");
		// driver.findElement(By.xpath("//[@id=\"wordMeaningContentPlaceHolder_wordMeaningControl_SearchDefinitionsRadio\"]")).sendKeys("eu");

		// *[@id="wordMeaningContentPlaceHolder_wordMeaningControl_SearchWordTextBox"]
		// *[@id="wordMeaningContentPlaceHolder_wordMeaningControl_SearchWordTextBox"]

	}

}
