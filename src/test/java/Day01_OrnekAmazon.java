import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day01_OrnekAmazon {
    // amazona git
    //arama kutusuna baby stroller yaz
    //2. siradaki urune tikla
    //urun sayfasina gittikten sonra urunu toplam fiyatini alacagiz
    //urunun oratlama puanini alacagiz

    @Test
    public void amazon() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to("http://amazon.com");
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("baby stroller");
        searchBox.submit();
        WebElement stroll = driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[2]"));
        stroll.click();
        String fiyat = driver.findElement(By.id("price_inside_buybox")).getText();
        System.out.println("Urunun fiyati : " + fiyat);
       // String puan = driver.findElement(By.id("averageCustomerReviews")).getText();
      //  System.out.println("Urunun puanlamasi : " + puan);
    }
    @Test
    public void test2(){
        //google.com gec  navigate.to
        //kemal ozden yazdirialim
      // karsimiza cikan sonucu yazdiralim

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to("http://google.com");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("kemal ozden");
        searchBox.submit();
        WebElement toplamSayi = driver.findElement(By.id("result-stats"));
        System.out.println(toplamSayi.getText());
    }
}

