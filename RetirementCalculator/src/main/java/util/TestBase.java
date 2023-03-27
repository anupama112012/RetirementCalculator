package util;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
public class TestBase {
	 public static WebDriver driver;
	public static Properties prop;
	public TestBase() {
	try{
	prop=new Properties();
	String configpath1=prop.getProperty("configpath");
	FileInputStream fis=new FileInputStream("I:/ANU IMP OFFICE AND INTERVIEW QUESTIONS FILES/ANU OLD COMP FILES/ANUPAMA OFFICE FILES/selenium/RetCalc/src/main/java/config/config.properties");
	prop.load(fis);
	}
	catch(IOException e){
	e.getMessage();
	e.printStackTrace();
	}
}
	public static void initialize(){
		String browserName=prop.getProperty("browser");
		if (browserName.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver",prop.getProperty("chromedriver"));
		driver=new ChromeDriver();
		}
		else if (browserName.equals("IE")) {
		System.setProperty("webdriver.internetexplorer.driver","IEdriver");
		driver=new InternetExplorerDriver();
		}
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		}
}
