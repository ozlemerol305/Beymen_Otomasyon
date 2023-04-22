package page;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.example.AutomationConstant.URL;
import static org.junit.Assert.assertEquals;

public class Commonlib {

    public WebDriver webDriver;
    public String productprice1;
    public String productprice2;
    public String productprice3;
    private static final Log log = LogFactory.getLog(Commonlib.class);


    public Commonlib() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();

    }

    public void openHome() {
        webDriver.get(URL);
        webDriver.findElement(By.id("onetrust-accept-btn-handler")).click();
        webDriver.findElement(By.xpath("(//*[@class='icon icon-close'])[2]")).click();
    }

    public void kelimeAra(String term) {
        log.info("====Arama yapılıyor====");
        webDriver.findElement(By.xpath("//div[@class='input-wrapper']")).click();
        WebElement searchEt = webDriver.findElement(By.xpath("//input[@class='default-input o-header__search--input']"));
        searchEt.sendKeys(term);
        WebElement aramaIcon = webDriver.findElement(By.xpath("//*[@class='o-header__search--btn bmi-search']"));
        aramaIcon.click();

    }


    public void productTik(Integer productNo) throws InterruptedException {
        log.info(productNo + ". product is selecting");
        Thread.sleep(5000);
        PageScrolldown();
        WebElement productTikla = webDriver.findElement(By.xpath("(//div[@class='m-productCard'])[" + productNo + "]"));
        Thread.sleep(5000);
        WebElement TL = webDriver.findElement(By.xpath("(//span[@class='m-productCard__newPrice'])[" + productNo + "]"));
        productprice1 = (TL.getText() + " TL");
        System.out.println("Ürün fiyatı:" + productprice1);
        productTikla.click();
        Thread.sleep(5000);
    }


    public void addToCart() throws InterruptedException {
        log.info("====Secilen urun sepete ekleniyor====");
        WebElement beden = webDriver.findElement(By.xpath("(//span[@class='m-variation__item'])[1]"));
        PageScrolldown();
        beden.click();
        WebElement TL = webDriver.findElement(By.id("priceNew"));
        productprice2 = (TL.getText());
        System.out.println("Ürün fiyatı:" + productprice2);
        webDriver.findElement(By.id("addBasket")).click();
        Thread.sleep(5000);
        WebElement sepeteGit = webDriver.findElement(By.xpath("//a[@title='Sepetim']"));
        sepeteGit.click();
        Thread.sleep(5000);
        WebElement checkUrun2 = webDriver.findElement(By.xpath("//span[@class='m-productPrice__salePrice']"));
        System.out.println("Ürün fiyatı:" + checkUrun2.getText());
        productprice3 = checkUrun2.getText();

        log.info("====Price kontrolü yapılıyor====");
        assertEquals(productprice1, productprice2, productprice3);
    }

    public void driverQuit() {
        webDriver.quit();
    }


    public void PageScrolldown() {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
    js.executeScript("window.scrollBy(0,250)","");
}

    }




