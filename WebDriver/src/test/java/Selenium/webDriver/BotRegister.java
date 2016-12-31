/**
 * BOT_REGISTER
 *
 * @author 4ury0n
 */

package Selenium.webDriver;

import java.util.Random;
import java.util.Timer;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class BotRegister {

	private static void breakDoor(WebDriver driver) {
		int i = 0;
		int delay = 1000;
		Timer timer = new Timer();
		Random rand = new Random();

		driver.get("https://w1n.w1finance.com.br/index.php");
		driver.findElement(By.name("pers_id")).sendKeys("999995484");
		driver.findElement(By.name("password")).sendKeys("JM2F5cL");
		driver.findElement(By.xpath("/html/body/form/div[2]/div[2]/input[3]")).click();
		while (delay > 0) {
			try {
				driver.findElement(By.xpath("//*[@id='countdowntillclose']/button")).click();
			} catch (Exception e) {
				// TODO: handle exception
			}
			delay--;

		}

	}

	private static void startBot(WebDriver driver) {
		String[] nomes = { "Alan", "Alessandra", "Amanda", "Amanda", "Amanda Rh", "Amanda", "Anderson", "Andy", "Paula",
				"Beto", "Bianca", "Bruno", "Caio", "Caio", "Carol", "Charlote", "Dionei", "Eduardo", "Elaine", "Eric",
				"Fabio", "Giovana", "Helena", "Israel", "Rafael", "Onar", "Steh", "Thais", "Nathaly", "Patrick", "Raul",
				"Paola", "Wesley", "Otavio", "Larissa", "Leo", "Leonardo", "Matheus", "Leticia", "Marta", "Steh",
				"Thais", "Diogo", "Capitao", "Tenente", "Sargento", "Soldado", "Capitao", "Capitao", "Tenente", "Bruno",
				"Fernando", "Plinio", "Sara", "Francesca", "Nicholas", "Fernanda", "Joana", "Joao", "Julia", "Gustavo",
				"Felipe", "Higor", "Tatiana", "Priscila", "Caroline", "Gabriel", "Roberto", "Joao", "Stephanie",
				"Gabriela", "Nathalia", "Nadia", "Sara", "José", "Tania", "Jairo", "Doris", "Vera", "Joacir", "Maria",
				"Eli", "Abel", "Ana Clara", "Cristina", "Maria Luisa", "Jean", "Amauri", "Pedro", "Americo", "Leyla",
				"Mayla", "Gunter", "Sandra", "Alberto", "Isabella", "Giovanna", "Danillo", "Daniel", "Diogo" };

		String[] subnomes = { "Crowley", "Tinder", "Costa", "Marcelino", "Bar Secreto", "Z", "Zeus", "Nascimento",
				"Celandroni", "Sahdo", "Brooks", "Fraga", "Duarte", "Haguena", "Canhos", "Rosa", "Lacerda", "Ramada",
				"Nanny", "Obi", "Matyas", "Martinhao", "Azevedo", "Olivetti", "Sorocaba", "Santana", "Cortelli",
				"Klann", "Tinder", "Urbano", "Melo", "Oliveira", "Ibm", "Meira", "Botelho", "Maranhao", "Pi2", "Calvin",
				"Eric", "Chiva", "Usp", "De Lana", "Nogueira", "Motta", "Santana", "Barbosa", "Salatiel", "Riso",
				"Barbosa", "Cordeiro", "Almeida", "Oliveira", "Ferraz", "Motores", "Rosa", "Cruz", "Pabavic",
				"Carriere", "Pereira", "Santos", "Silva", "Ukhan", "Rodrigues", "Rodrigues", "Silva", "Silva",
				"Gerassi", "Gerassi", "Gerassi", "Casamassa", "Casamassa", "Trevisolli", "Tinder", "Ramada", "Alemida",
				"Rodrigues", "Alemida", "Pereira", "Dos Santos", "Peppe", "Festa Mack", "Cervejada Usp", "Rodrigues",
				"Silva", "Jokhan", "Silva", "Romagnolli", "Moreira", "Parator", "Tomo", "Kjaer", "Moraes", "Silva",
				"Vaz Guimaraes", "Rosa", "Reis Lima", "Rodrigues", "Horta", "Estarde", "Nogueira" };

		String[] telefones = { "98957-3341", "946574938", "96244-5556", "965118074", "982289748", "95252-0252",
				"949687585", "956399414", "99155-8223", "98754-0670", "98137-5186", "353899882086", "98265-1811",
				"972854771", "14 99700-0912", "+330611346681", "+55 11 99230-3053", "+55 11 99277-0630", "964396056",
				"+55 11 94714-4899", "998061911", "988828742", "959451304", "+55 11 95029-5224", ",955784947",
				"+55 11 95421-8229", "+55 11 98141-2520", "98348-5994", ",(11) 99559-6679", "011972658621",
				"+55 11 97109-2088", "+55 11 97060-4353", "941483446", "976766651", "98647-4698", "99615-5634",
				"975677900", "975677993", "985898050", "998235194", "+55 11 99792-8752", "+55 11 96290-7454",
				"934573438", "934572338", "883640587", "993750489", "938495850", "982930484", "982930495", "982940405",
				"849508697", "938403059", "77565988", "773802902", "792839384", "928393843", "928484938", "938594859",
				"929384950", "928394840", "928234840", "928323840", "92839484029", "934573438", "97263774", "934573438",
				"998389494", "923324555", "992383948", "925463789", "925468293", "982943789", "928474857", "982938464",
				"993849475", "992839374", "982448733", "992878998", "982776648", "992039440", "992839484", "992847465",
				"983849434", "992038643", "993639452", "999282947", "929827494", "982949494", "992843525", "992839475",
				"992839322", "982937405", "992745212", "934573438", "934573438", "993849583", "992839475", "982749587",
				"992748576", "972649748" };

		driver.findElement(By.xpath("//*[@id='sidebar']/ul/li[3]/a")).click();
		driver.findElement(By.xpath("//*[@id='sidebar']/ul/li[3]/ul/li[1]/a")).click();

		for (int cont = 0; cont <= 100; cont++) {
			// WEBPAGE2
			driver.findElement(By
					.xpath("//*[@id='main-container']/div[2]/div/div[2]/div[3]/div/div/div/div/div[4]/div/div[2]/div/a"))
					.click();
			driver.findElement(By
					.xpath("//*[@id='main-container']/div[2]/div[1]/div[2]/div[3]/div/div/form/div/div/div/div[1]/div[1]/div[2]/div/table/tbody/tr/td[3]/div/label"))
					.click();
			driver.findElement(By.name("firstname")).sendKeys(nomes[cont]);
			driver.findElement(By.name("lastname")).sendKeys(subnomes[cont]);
			driver.findElement(By.name("mobile")).sendKeys(telefones[cont]);
			driver.findElement(By.name("create")).click();
			// TODO RETURN WEB PAGES
		}
		driver.close();

	}

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver(); // change to htmlUnit driver
		breakDoor(driver);
		startBot(driver);
		
	}

}