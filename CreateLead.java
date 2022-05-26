package week6.day2;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLead extends ProjectSpecificMethods {

	
	@Test(dataProvider="testData")
	public void runCreateLead(String userName, String password, String cName,String fName, String lName) {
		driver.findElement(By.id("username")).sendKeys(userName);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cName);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fName);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lName);
		driver.findElement(By.name("submitButton")).click();
		
	
}
	@DataProvider
	private String[][] testData() throws IOException {
		String[][] data = ReadExcelData.readData("TestData001");
		return data;
	}

	/*@DataProvider
	private String[][] testData() {
		String[][] arr=new String[2][5];
		
		arr[0][0]="Demosalesmanager";
		arr[0][1]="crmsfa";
		arr[0][2]="Test Company";
		arr[0][3]="Test";
		arr[0][4]="Leaf";
		
		arr[1][0]="DemoCSR";
		arr[1][1]="crmsfa";
		arr[1][2]="Test Company";
		arr[1][3]="TestOne";
		arr[1][4]="LeafOne";
		
		return arr;
		
	}*/
}






