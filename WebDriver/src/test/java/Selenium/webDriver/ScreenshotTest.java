package Selenium.webDriver;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Time;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.Stack;
import java.util.concurrent.Delayed;

import javax.imageio.ImageIO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenshotTest {

	public static void start() throws AWTException {
		Random rand = new Random();
		int i = rand.nextInt(10);
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.msn.com/pt-br");

		try {

			Rectangle screenResolution = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
			BufferedImage screenshot = new Robot().createScreenCapture(screenResolution);
			ImageIO.write(screenshot, "JPG", new File("C:\\Users\\bruno\\Desktop\\advertise" + i + ".jpg"));

		}

		catch (IOException error) {
			error.printStackTrace();
		}

		driver.close();
		return;

	}

	public static void main(String[] args) throws AWTException {
		String target = "17:28";
		Stack<String> hourList = new Stack<String>();
		hourList.push(target);

		while (true) {
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
			Date hora = Calendar.getInstance().getTime();
			String formatedData = sdf.format(hora);
			// System.out.println(formatedData);

			//if (hourList.contains(formatedData)) {
			System.out.println("got it");
			start();

			 //}

		}

	}
}
