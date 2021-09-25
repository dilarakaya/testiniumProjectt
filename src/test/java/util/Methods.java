package util;

import BaseTest.Base;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

public class Methods extends Base {
  public static String text = "";

  public WebElement findElement(String key) {
    try {
      WebElement element = (new WebDriverWait(driver, 5, 300))
          .until(ExpectedConditions.elementToBeClickable(By.cssSelector(key)));
      return element;

    } catch (Exception ex) {
      Assert.fail("" + key + "'li element 10 saniye boyunca arandı fakat bulunamadı..!!!");
      return null;
    }
  }

  public List<WebElement> findElements(String key) {
    try {
      WebDriverWait waitForFormLabel = new WebDriverWait(driver, 30);
      List<WebElement> elements = driver.findElements(By.cssSelector(key));
      waitForFormLabel.until(ExpectedConditions.visibilityOfAllElements(elements));
      return elements;

    } catch (Exception ex) {
      Assert.fail("" + key + "'li element 10 saniye boyunca arandı fakat bulunamadı..!!!");
      return null;
    }
  }

  public void clickToElement(String key) {
    WebElement element = findElement(key);
    waitSecond(500);
    element.click();
  }

  public void sendKeysToElement(String key, String text) {
    WebElement element = findElement(key);
    waitSecond(500);
    element.sendKeys(text);
  }

  public String getTextElement(WebElement element) {
    waitSecond(500);
    String elemaninTexti = "";
    elemaninTexti = element.getText();
    System.out.println("Elemanın Text değeri: " + elemaninTexti);
    return elemaninTexti;
  }

  public void waitSecond(long milliseconds) {
    try {
      Thread.sleep(milliseconds);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public void navigateTo() {
    driver.navigate().to("https://www.hepsiburada.com/ara?q=bilgisayar&sayfa=2");
  }

  public void getTextControl(String key, String text) {
    WebElement element = findElement(key);
    String elemaninTexti = element.getText();
    System.out.println("Elemanın Text değeri: " + elemaninTexti);
    Assert.assertEquals("Eleman girilen texti içermiyor..!!!", elemaninTexti, text);
    System.out.println("Girilen değer ile Elementin texti uyuşuyor..");
  }

  public void getValueControl(String key, String value) {
    WebElement element = findElement(key);
    String elemaninTexti = element.getAttribute(value);
    System.out.println("Elemanın Text değeri: " + elemaninTexti);
    Assert.assertEquals("Eleman girilen texti içermiyor..!!!", elemaninTexti, text);
    System.out.println("Girilen değer ile Elementin texti uyuşuyor..");
  }

  public void saveStaticString(String key) {
    WebElement element = findElement(key);
    text = element.getText();
    System.out.println("Elementin text değeri text değişkenine kaydedildi: " + text);

  }

  public void textControl(String key) {
    WebElement element = findElement(key);
    Assert.assertTrue("Eleman texti kaydedilen değer ile uyuşmuyor..!!!", getTextElement(element).contains(text));
    System.out.println("Girilen değer ile Elementin texti uyuşuyor..");
  }

  public void randomClick(String key) {
    List<WebElement> elements = findElements(key);
    Random r = new Random();
    int low = 1;
    int high = 24;
    int result = r.nextInt(high - low) + low;
    elements.get(result).click();
    System.out.println(result + ". Elemente tıklandı..");

  }

}
