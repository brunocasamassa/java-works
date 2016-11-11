
/**
 * WORD HUNT
 *
 * @author Aury0n
 */

package Selenium.webDriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.security.auth.callback.TextOutputCallback;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WordHunt {
	static int p = 2;
	static int b = 1;
	static String word = null;
	static Scanner scan = null;

	public static void main(String[] args) throws InterruptedException, IOException {
		try {
			scan = new Scanner(new File("C:\\Users\\Auryon.AURYON-PC\\Desktop\\Aula1\\teste.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		;
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		while (scan.hasNextLine()) {
			word = scan.next();
			driver.get("https://www.dicio.com.br/");
			driver.findElement(By.xpath("//*[@id=\"q\"]")).sendKeys(word);
			driver.findElement(By.xpath("//*[@id=\"searchForm\"]/button/span")).click();
			String texto = null;

			while (true) {
				try {
					texto = driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/p[" + p + "]/b[" + b + "]"))
							.getText();
					System.out.println(texto);
				} catch (Exception e) {
					b++;
					if (texto == null && b >= 3) {
						b = 0;
						p++;
					}
				}

			}
		}
		Thread.sleep(2000);
		driver.quit();

		// driver.get("https://www.priberam.pt/dlpo/");
		// driver.findElement(By.xpath("//[@id=\"wordMeaningContentPlaceHolder_wordMeaningControl_SearchDefinitionsRadio\"]")).sendKeys("eu");

		// *[@id="wordMeaningContentPlaceHolder_wordMeaningControl_SearchWordTextBox"]
		// *[@id="wordMeaningContentPlaceHolder_wordMeaningControl_SearchWordTextBox"]

	}

}
