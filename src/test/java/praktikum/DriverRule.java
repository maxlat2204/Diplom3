package praktikum;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class DriverRule extends ExternalResource {
    protected WebDriver driver;

    //Метод Before
    @Override
    protected void before() throws Throwable {
        initDriver();//открывает браузер
        driver.get(EnvConfig.BASE_URL);//открывает страницу
        RestAssured.baseURI = EnvConfig.BASE_URL;
    }

    //Метод After(закрывает браузер)
    @Override
    protected void after() {
        driver.quit();
    }

    //Запуск через yandex описан в файле readme.md
    public void initDriver() throws Exception{
        if ("yandex".equalsIgnoreCase(System.getProperty("browser"))){
            startBrowserYandex();
        } else {
            startBrowserChrome();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

    //    Открывает браузер Chrome
    public void startBrowserChrome(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(EnvConfig.IMLICIT_WAIT));
    }

    //Открывает браузер Яндекс
    public void startBrowserYandex(){
        WebDriverManager.chromedriver().driverVersion(System.getProperty("driver.version")).setup();
        var opts = new ChromeOptions()
                .setBinary(System.getProperty("path.browser"));
        driver = new ChromeDriver(opts);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(EnvConfig.IMLICIT_WAIT));
    }

}
