package week7.day2;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead extends ProjectSpecificMethod {
	@BeforeTest
	public void setup() {
		excelfile="EditLead";
	}
	
	
	
	
	/*
	 * @DataProvider(name="testData") public String[][] fetchdata() throws
	 * IOException { String[][] readData = LearnReadExcel.readData("EditLead");
	 * return readData; }
	 */

		/*
		 * String [][] data=new String[2][2]; //1st set of data data[0][0]="99";
		 * data[0][1]="TestLeaf"; //2nd set of data data[1][0]="97";
		 * data[1][1]="Qeagle"; return data;
		 */
		
     @Test(dataProvider="testData")
	public void editLead(String pNum,String cName) throws InterruptedException {
		
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(pNum);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(cName);
		driver.findElement(By.name("submitButton")).click();
		
}
}






