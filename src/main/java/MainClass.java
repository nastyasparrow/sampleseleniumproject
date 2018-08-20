import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class MainClass{
    static WebDriver driver;


    public static void main(String[] args){
        /*System.setProperty("webdriver.gecko.driver","D:\\IdeaProjects\\Hillel\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver();

        driver.get("http://jira.hillel.it:8080/login.jsp");*/
        System.setProperty("webdriver.chrome.driver","D:\\IdeaProjects\\Hillel\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.get("http://jira.hillel.it:8080/login.jsp");
        driver.manage().timeouts().implicitlyWait(10,  TimeUnit.SECONDS);


        driver.findElement(By.xpath("//*[@id=\"login-form-username\"]")).sendKeys("Nastya_Vorobey");
        driver.findElement(By.xpath("//*[@id=\"login-form-password\"]")).sendKeys("Nastya_Vorobey");
        driver.findElement(By.xpath("//*[@id=\"login-form-submit\"]")).click();

        driver.findElement(By.xpath("//*[@id=\"create_link\"]")).click();

        WebDriverWait wait = (new WebDriverWait(driver,5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"create-issue-dialog\"]/div[1]/h2")));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"issuetype-field\"]"))));
        driver.findElement(By.xpath("//*[@id=\"bug-1\"]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"summary\"]")).sendKeys("TEST Automatically created");
        driver.findElement(By.xpath("//*[@id=\"assign-to-me-trigger\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"create-issue-submit\"]")).click();






    }

}