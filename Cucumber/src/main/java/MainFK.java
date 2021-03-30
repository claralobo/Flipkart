import java.io.File;
import java.io.FileInputStream;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;



import java.io.File;

import java.io.FileInputStream;

import java.io.FileNotFoundException;

import java.io.FileOutputStream;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;


import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.ss.usermodel.CellBase;

import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.ss.usermodel.Workbook;

public class MainFK {

	public static void main(String[] args) throws InterruptedException, IOException {
		
				WebDriverManager.chromedriver().setup();
				WebDriver driver=new ChromeDriver();
				driver.get("https://www.flipkart.com");
				

			

	driver.manage().window().setSize(new Dimension(1280, 680));
    driver.findElement(By.cssSelector(".\\_2doB4z")).click();
    driver.findElement(By.name("q")).click();
    driver.findElement(By.name("q")).sendKeys("iphone");
    driver.findElement(By.tagName("button")).click();
    Thread.sleep(2000);
    driver.findElement(By.cssSelector("div._36fx1h._6t1WkM._3HqJxg div._1YokD2._2GoDe3:nth-child(1) div._1YokD2._3Mn1Gg:nth-child(2) div._1AtVbE.col-12-12:nth-child(2) div._13oc-S div:nth-child(1) > div._4ddWXP")).click();
    
    String parent=driver.getWindowHandle();

    Set<String>s=driver.getWindowHandles();

    // Now iterate using Iterator
    Iterator<String> I1= s.iterator();

    while(I1.hasNext())
    {
    
    	String child_window=I1.next();


    	if(!parent.equals(child_window))
    	{
    	driver.switchTo().window(child_window);

    	System.out.println(driver.switchTo().window(child_window).getTitle());
    	Thread.sleep(1000);
    	
    	File file = new File("//Cucumber//target//Filpkart - Sheet1.csv");


    	FileInputStream inputStream = new FileInputStream(file);


    	XSSFWorkbook wb = new XSSFWorkbook(inputStream);


    	XSSFSheet sheet = wb.getSheet("sheet1");
       
    	 WebElement we = driver.findElement(By.xpath("//span[contains(text(),'APPLE iPhone 11 (White, 64 GB)')]"));
    	 WebElement we2 = driver.findElement(By.cssSelector("div._2c7YLP.UtUXW0._6t1WkM._3HqJxg div._1YokD2._2GoDe3 div._1YokD2._3Mn1Gg.col-8-12:nth-child(2) div._1AtVbE.col-12-12:nth-child(6) div._3wmLAA div.ffYZ17.col.col-12-12:nth-child(2) div._22QfJJ ul._1q8vHb li._3V2wfe:nth-child(1) > a._1fGeJ5.PP89tw"));

         String PhoneName = we.getAttribute("innerHTML");
         String Storage = we2.getAttribute("innerHTML");

         FileInputStream fis = new FileInputStream(file);

         Workbook workbook = new XSSFWorkbook(fis);   

      

    		Sheet sheet1 = workbook.getSheetAt(0);

    		Row row = sheet1.getRow(0);

    		org.apache.poi.ss.usermodel.Cell cell = row.createCell(4);

    		((org.apache.poi.ss.usermodel.Cell) cell).setCellValue(PhoneName);

    		Row row1 = sheet1.getRow(1);

    		org.apache.poi.ss.usermodel.Cell cell1 = row1.createCell(4);

    		((org.apache.poi.ss.usermodel.Cell) cell1).setCellValue(Storage);

    		FileOutputStream fos = new FileOutputStream(file);

    		workbook.write(fos);

    		fos.close();

    	
    	driver.close();
    	}

    }
    driver.switchTo().window(parent);

    driver.close();
	driver.quit();
}	
		

}


