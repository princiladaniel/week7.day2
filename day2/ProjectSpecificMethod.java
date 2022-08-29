package week7.day2;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ProjectSpecificMethod {
	

  public RemoteWebDriver driver;
  public String excelfile;
  @Parameters({"browserName","URL","userName","passWord"})
  @BeforeMethod
  public void preCondition(String browserName,String url,String uname,String pass) {
	  if(browserName.equalsIgnoreCase("Chrome")) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	  }
	  else if(browserName.equalsIgnoreCase("Edge")) {
		  WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
	  }
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("username")).sendKeys(uname);
		driver.findElement(By.id("password")).sendKeys(pass);
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		
		
	}
	@AfterMethod
	public void postCondition() {
		driver.close();

	}
	@DataProvider(name="testData")
	public String[][] fetchdata() throws IOException {
		String[][] readData = LearnReadExcel.readData(excelfile);
		return readData;
	}
	
}
