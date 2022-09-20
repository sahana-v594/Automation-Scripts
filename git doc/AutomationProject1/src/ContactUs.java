import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ContactUs {
    static {
        System.setProperty("webdriver.chrome.driver",
                "C:\\\\Users\\\\sahana.v\\\\Documents\\\\chromedriver_win32\\\\chromedriver.exe");
    }
    WebDriver driver;
    
    @Test(priority = 1)
    public void launchBrowser() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://mobileworld.banyanpro.com/");
    }
    @Test(priority = 2)
    public void clickContactUs() throws InterruptedException {
        driver.findElement(By.xpath("(//a[@id='navbarDropdown'])[2]")).click();
        driver.findElement(By.xpath("(//a[text()='Contact Us'])[1]")).click();
        Thread.sleep(2000);
        Set<String> id = driver.getWindowHandles();
        java.util.Iterator<String> it = id.iterator();
        String parentId = it.next();
        String childId = it.next();
        driver.switchTo().window(childId);
        driver.manage().window().maximize();
    }
    @Test(priority = 2)
    public void enterName() throws InterruptedException {
        driver.findElement(By.name("name")).sendKeys("sahana");
    }
    @Test(priority = 3)
    public void enterMail() throws InterruptedException {
        driver.findElement(By.name("email")).sendKeys("sahanav@gmail.com");
    }
    @Test(priority = 4)
    public void enterPhoneNumber() throws InterruptedException {
        driver.findElement(By.name("phone")).sendKeys("9996913133");
    }
    @Test(priority = 5)
    public void enterMessage() throws InterruptedException {
        driver.findElement(By.name("message")).sendKeys("Hello this is sahana");
        Thread.sleep(5000);
    }
    @Test(priority = 6)
    public void clickOnSend() throws InterruptedException {
        driver.findElement(By.className("btn")).click();
    }
}

