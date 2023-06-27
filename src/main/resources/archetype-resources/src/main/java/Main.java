package ${package};

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lib.commons.browser.DriverFactory;
import lib.commons.notification.TelegramNotification;
import rpa.people.generator.model.RobotStatistics;

public class Main {

	private static final Logger log = LoggerFactory.getLogger(Main.class);
	
	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Kris\\Desktop\\Deploy\\chromedriver\\chromedriver.exe");

		RobotStatistics.initializeItems();
		RobotStatistics.startDateTime = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").format(LocalDateTime.now());

		// TODO: Insert your code here

		RobotStatistics.endDateTime = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").format(LocalDateTime.now());
		TelegramNotification.sendMessage(finalMessage());

	}
	
	public static void navigate() {
		try (DriverFactory driverFactory = new DriverFactory()){
			WebDriver driver = driverFactory.getChromeDriver();
			driver.get("");
			
			// TODO: insert your code here
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}