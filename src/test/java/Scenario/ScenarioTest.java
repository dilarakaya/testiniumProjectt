package Scenario;

import BaseTest.Base;
import org.junit.Test;
import util.Methods;


public class ScenarioTest extends Base {
    Methods steps = new Methods();

    @Test
    public void TestSenaryosu() throws Exception {
        steps.clickToElement("div[id='myAccount']"); //Giriş yap ikonuna tıkla
        steps.clickToElement("a[id='login']"); //Giriş yap ikonuna tıkla
        steps.waitSecond(1000); //1 saniye bekle
        steps.sendKeysToElement("input[id='txtUserName']", "testiniumtest6@gmail.com"); //email inputuna değeri yaz
        steps.sendKeysToElement("input[id='txtPassword']", "Test1234."); // parola inputuna değeri yaz
        steps.clickToElement("button[id='btnLogin']"); // giriş yap butonuna tıkla
        steps.waitSecond(2000); // 2 saniye bekle
        steps.getTextControl("#myAccount > span > a > span.sf-OldMyAccount-PhY-T", "Hesabım"); //giriş yapılmış mı kontrol et
        steps.sendKeysToElement("input[aria-controls='react-autowhatever-1']", "bilgisayar"); // arama çubuğuna "bilgisayar" yaz
        steps.clickToElement("div[class='SearchBoxOld-buttonContainer']"); //arama ikonuna bas
        steps.waitSecond(2000);
        steps.navigateTo();
        steps.findElement("a[class='page-2 active']");
        steps.randomClick("div[class='box product']"); // rastgele bir ürün seç
        steps.waitSecond(2000); // 2 saniye bekle
        steps.saveStaticString("div.extra-discount-price > span"); //ürünün fiyat bilgisini kaydet
        steps.clickToElement("button[id='addToCart']"); //sepete ekle butonuna bas
        steps.clickToElement("a[class='sf-OldMyAccount-2OvEz sf-OldMyAccount-3TYPj']"); //sepetim ikonuna bas
        steps.waitSecond(2000); // 2 saniye bekle
        steps.textControl("div[class*='co-hbPrice-ibRavm']"); //sepetimde fiyat kontrolü
        steps.clickToElement("a[class='product_increase_3SpEx']"); //ürün adedi artır butonuna bas
        steps.waitSecond(1000);
        steps.getValueControl("div > input[type=number]","2"); // ürün adedi 2 mi kontrol et
        steps.clickToElement("button.sc-AxjAm.iDSyON.sflButton_2fKbY");
        steps.getTextControl("div.content_Z9h8v > h1", "Sepetin şu an boş"); // sepet boş mu kontrol et
    }
}
