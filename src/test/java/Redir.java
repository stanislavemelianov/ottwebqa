import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class Redir {
    @Test
    public void redir() {
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://onetwotrip.com");
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        if(driver.getCurrentUrl().startsWith("https://www."))
            System.out.println("Success");
        else
            System.out.println("Failure");
    }

}
