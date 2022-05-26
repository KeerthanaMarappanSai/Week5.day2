package week6.day2;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead extends ProjectSpecificMethods{

	@Test(dataProvider="testData")
	public void runEditLead(String userName, String password, String phNum,String cName) throws InterruptedException {
		driver.findElement(By.id("username")).sendKeys(userName);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(phNum);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(cName);
		driver.findElement(By.name("submitButton")).click();
		
}
	
	@DataProvider
	private String[][] testData() throws IOException {
		String[][] data = ReadExcelData.readData("TestData002");
		return data;
	}
	
	/*@DataProvider
	private String[][] testData() {
		String[][] arr=new String[2][4];
		
		arr[0][0]="Demosalesmanager";
		arr[0][1]="crmsfa";
		arr[0][2]="12345";
		arr[0][3]="TestLeaf";
		
		
		arr[1][0]="DemoCSR";
		arr[1][1]="crmsfa";
		arr[1][2]="123456";
		arr[1][3]="TestLeafOne";
		
		return arr;
		
	}*/
}






