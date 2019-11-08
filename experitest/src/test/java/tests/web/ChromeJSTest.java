package tests.web;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;


public class ChromeJSTest {

    private WebDriver driver;

    public ChromeJSTest() {
        System.setProperty("webdriver.chrome.driver", "C:/Drivers/chromedriver.exe");

        driver = new ChromeDriver();
    }

    @Test
    public void testSelenium() {
        driver.get("https://experitest.com");
        WebElement footer = driver.findElement(By.className("book-demo-btn"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", footer);
    }

    @Test
    public void locateElement() {
        driver.get("https://experitest.com");
        WebElement startButton = ((JavascriptExecutor) driver).executeScript("document.getElementsByTagName('a')[13];");
    }

    @Test
    public void clickElement1() {
        driver.get("https://experitest.com");
        ((JavascriptExecutor) driver).executeScript("document.getElementsByTagName('a')[13].click();");
    }

    @Test
    public void clickElement2() {
        driver.get("https://experitest.com");
        WebElement startButton = ((JavascriptExecutor) driver).executeScript("document.getElementsByTagName('a')[13];");
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", startButton );
    }

    @Test
    public void printAlert() {
        driver.get("https://experitest.com");
        ((JavascriptExecutor) driver).executeScript("alert('Welcome to Experitest');");
    }

    @Test
    public void scrollToElement() {
        driver.get("https://experitest.com");
        WebElement footerBtn = driver.findElement(By.className("book-demo-btn"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", footerBtn);
    }

    @Test
    public void changeStyle() {
        driver.get("https://experitest.com");
        ((JavascriptExecutor) driver).executeScript("document.getElementsByTagName('a')[13].style.border = '3px dotted blue'");
    }

    @Test
    public void implementWaits() {
        driver.get("https://experitest.com");
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
        long start = System.currentTimeMillis();
        ((JavascriptExecutor) driver).executeAsyncScript(
            "window.setTimeout(arguments[arguments.length - 1], 5000);");
        ((JavascriptExecutor) driver).executeScript("alert('Waited for ' + arguments[0] + ' seconds');",
            (System.currentTimeMillis() - start) / 1000);
    }
}
