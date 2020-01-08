package Steps;

import Base.BaseStep;
import cucumber.api.java.tr.Diyelimki;
import cucumber.api.java.tr.Ve;
import org.openqa.selenium.By;
import org.testng.Assert;

public class RegisterStep extends BaseStep {

    @Diyelimki("^Hepsiburada sayfasini \"([^\"]*)\" acalim$")
    public void hepsiburadaSayfasiniAcalim(String webLink) throws Throwable {
        geturl(webLink);
    }

    @Ve("^\"([^\"]*)\" secenegine tiklanir$")
    public void secenegineTiklanir(String linkName) throws Throwable {
        findElementClick("div#MyAccount.widget.MyAccount", Pather.cssSelector);
        switch (linkName) {

            case "Giriş Yap":

                findElementClick("a#login", Pather.cssSelector);
                break;

            case "Üye Ol":
                findElementClick(linkName, Pather.linkText);
                break;
        }

        Thread.sleep(3000);
    }


    @Ve("^\"([^\"]*)\" alanina \"([^\"]*)\" yazilir$")
    public void alaninaYazilir(String label, String data) throws Throwable {
        findElementSendKeys(label, Pather.id, data);

    }


    @Ve("^giris butonuna tiklanir$")
    public void girisButonunaTiklanir() throws Throwable {
        findElementClick("button.btn.full.btn-login-submit", Pather.cssSelector);
    }

    @Ve("^kullanici ikonun yaninda ad soyad kisminin \"([^\"]*)\" oldugu gorulur$")
    public void kullaniciIkonunYanindaAdSoyadKismininOldugunuGorulur(String userName) throws Throwable {
        String name;
        name = findElement("div.usersProsess", Pather.cssSelector, TimeOut.LOW).findElement(By.cssSelector("a.login.user-name")).getText();
        Assert.assertEquals(userName, name);

    }

    @Ve("^arama bolumune \"([^\"]*)\" yazilip ara butonuna basilir$")
    public void aramaBolumuneYazilipAraButonunaBasilir(String product) throws Throwable {
        findElementSendKeys("productSearch", Pather.id, product);
        findElementClick("buttonProductSearch", Pather.id);

    }

    @Ve("^\"([^\"]*)\" adli urun secilir$")
    public void adliUrunSecilir(String arg0) throws Throwable {
        driver.findElements(By.cssSelector("h3.product-title.title")).get(0).click();

    }


    @Ve("^sepete iki adet urun atilir$")
    public void sepeteIkiAdetUrunAtilir() throws Throwable {
        findElementClick("div[class='variant-info'][title='Gold']", Pather.cssSelector);
        findElementClick("button#addToCart.button.big.with-icon", Pather.cssSelector);
        Thread.sleep(5000);
        findElementClick("Alışverişe Devam Et", Pather.linkText);
        PageScrolldown();
        findElementClick("div[class='variant-info'][title='Gold']", Pather.cssSelector);
        PageScrolldown();
        Thread.sleep(1000);
        driver.findElements(By.cssSelector("button.add-to-basket.button.small")).get(0).click();
        findElementClick("Sepete devam et", Pather.linkText);
        // findElementClick("//*[@id=\"merchant-list\"]/tbody/tr[2]/td[4]/form/button",Pather.xPath);
        Thread.sleep(1000);
    }

    @Ve("^atilan urunlerin \"([^\"]*)\" oldugu gorulur$")
    public void atilanUrunlerinOlduguGorulur(String productName) throws Throwable {
        String product1;
        String product2;
        Thread.sleep(3000);
        product1 = driver.findElements(By.cssSelector("div.product-detail")).get(0).findElement(By.cssSelector("h4.product-name")).getText();
        product2 = driver.findElements(By.cssSelector("div.product-detail")).get(1).findElement(By.cssSelector("h4.product-name")).getText();
        Assert.assertEquals(product1, productName);
        Assert.assertEquals(product2, productName);

    }


}
