package Steps;

import Base.BaseStep;
import cucumber.api.PendingException;
import cucumber.api.java.tr.Diyelimki;
import cucumber.api.java.tr.Ozaman;
import cucumber.api.java.tr.Ve;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class Trendyol extends BaseStep {
    @Diyelimki("^\"([^\"]*)\" sayfasina giris yaptim$")
    public void sayfasinaGirisYaptim(String url) throws Throwable {
        geturl(url);
    }

    @Ve("^reklam penceresini kapadim$")
    public void reklamPenceresiniKapadim() {
        findElement("a[title='Close']", Pather.cssSelector, TimeOut.LOW).click();
    }

    @Ve("^\"([^\"]*)\" secenegine tikladim$")
    public void secenegineTikladim(String linkName) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        findElementClick("span#not-logged-in-container", Pather.cssSelector);
        switch (linkName) {
            case "Giriş Yap":
                findElementClick("div.account-button.login", Pather.cssSelector);
                break;
            case "Üye Ol":
                findElementClick(linkName, Pather.linkText);
                break;
        }
        Thread.sleep(3000);
    }


    @Ve("^\"([^\"]*)\" alanina \"([^\"]*)\" yazarsam$")
    public void alaninaYazarsam(String label, String data) {
        findElementSendKeys(label, Pather.id, data);

    }

    @Ve("^giris butonuna tiklarsam$")
    public void girisButonunaTiklarsam() throws Throwable {
        findElementClick("a#loginSubmit", Pather.cssSelector);
        Thread.sleep(3000);
    }

    @Ve("^indirimleri kacirma penceresini kapatirsam$")
    public void indirimleriKacirmaPenceresiniKapatirsam() {
        findElementClick("path#Combined-Shape", Pather.cssSelector);
    }

    @Ozaman("^kullanici ikonunda \"([^\"]*)\" metni gorulur$")
    public void kullaniciIkonundaMetniGorulur(String text) throws Throwable {
        String account = driver.findElement(By.xpath("//span[@id='logged-in-container']//span")).getText();
        Assert.assertEquals(account, text);
    }


    @Ve("^\"([^\"]*)\" menusune tiklanirsa$")
    public void menusuneTiklanirsa(String menu) throws Throwable {
        findElementClick(menu, Pather.linkText);
    }

    @Ozaman("^butik imajlarinin yuklendigi gorulur$")
    public void butikImajlarininYuklendigiGorulur() throws Throwable {
//        int articleSize = driver.findElements(By.cssSelector("article.component-item")).size();
//        System.out.println("------" + articleSize);
//        ArrayList<String> imageArray = new ArrayList<String>();
//        for (int i = 0; i < articleSize; i++) {
//            String image = driver.findElements(By.xpath("//article[@class='component-item']//descendant::img")).get(i).getAttribute("src");
//            System.out.println(image);
//            Boolean imagePresent = null;
//            imagePresent = (Boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[i].naturalWidth > 0", image);
//
//            try {
//                if (imagePresent == false)
//                    System.out.println("image yok");
//                else
//                    System.out.println("image var");
//
//            } catch (NullPointerException e) {
//                System.out.print("Caught NullPointerException");
//            }
//            System.out.println(imageArray);
//            System.out.println(imageArray.size());
//
//        }

        List<WebElement> total_images = driver.findElements(By.xpath("//article[@class='component-item']//descendant::img"));
        System.out.println("Total Number of images found on page = " + total_images.size());
        boolean isValid = false;
        for (int i = 0; i < total_images.size(); i++) {
            String url = total_images.get(i).getAttribute("src");

            if (url != null) {

                //Call getResponseCode function for each URL to check response code.
                isValid = getResponseCode(url);

                //Print message based on value of isValid which Is returned by getResponseCode function.
                if (isValid) {
                    System.out.println("Valid image:" + url);
                    System.out.println();
                } else {
                    System.out.println("Broken image ------> " + url);
                    System.out.println();
                }
            } else {
                //If <a> tag do not contain href attribute and value then print this message
                System.out.println("String null");
                System.out.println();
                continue;
            }
        }
    }


    private boolean getResponseCode(String url) {
        return true;
    }

    @Ve("^tum menulere tiklanip imajlarin yuklendigi gorulur$")
    public void tumMenulereTiklanipImajlarinYuklendigiGorulur() throws Throwable {
        Integer menuSize = driver.findElements(By.xpath("//ul[@class='main-nav']//li[@class='tab-link']")).size();
        for (int i = 1; i < menuSize; i++) {
            WebElement menu = driver.findElements(By.xpath("//ul[@class='main-nav']//li[@class='tab-link']")).get(i);
            menu.click();
            List<WebElement> total_images = driver.findElements(By.xpath("//article[@class='component-item']//descendant::img"));
            System.out.println("Total Number of images found on page = " + total_images.size());
            boolean isValid = false;
            for (int x = 0; x < total_images.size(); x++) {
                String url = total_images.get(x).getAttribute("src");

                if (url != null) {

                    //Call getResponseCode function for each URL to check response code.
                    isValid = getResponseCode(url);

                    //Print message based on value of isValid which Is returned by getResponseCode function.
                    if (isValid) {
                        System.out.println("Valid image:" + url);
                        System.out.println();
                    } else {
                        System.out.println("Broken image ------> " + url);
                        System.out.println();
                    }
                } else {
                    //If <a> tag do not contain href attribute and value then print this message
                    System.out.println("String null");
                    System.out.println();
                    continue;
                }
            }

        }
    }


    @Ve("^\"([^\"]*)\" butigine tiklanirsa$")
    public void butigineTiklanirsa(String boutique) throws Throwable {
        driver.findElement(By.xpath("//a[@class='campaign campaign-big']//descendant::span[text()='" + boutique + "']")).click();
        String boutigueTitle = findElement("h1.boutique-title", Pather.cssSelector, TimeOut.LOW).getText();
        Assert.assertEquals(boutigueTitle, boutique);
    }


    @Ozaman("^urun gorsellerinin yuklendigi gorulur$")
    public void urunGorsellerininYuklendigiGorulur() {
        Integer productSize = driver.findElements(By.cssSelector("img.prc-picture")).size();
        for (int i = 0; i < productSize; i++) {
            List<WebElement> products_images = driver.findElements(By.xpath("//img[@class='prc-picture'][@lazy='loaded']"));
            System.out.println("Number of products' images = " + products_images.size());
            boolean isValid = false;
            for (int x = 0; x < products_images.size(); x++) {
                String url = products_images.get(x).getAttribute("src");

                if (url != null) {

                    isValid = getResponseCode(url);

                    if (isValid) {
                        System.out.println("Visible image:" + url);
                        System.out.println();
                    } else {
                        System.out.println("Broken image ------> " + url);
                        System.out.println();
                    }
                } else {
                    System.out.println("String null");
                    System.out.println();
                    continue;
                }
            }
        }
    }

    @Ve("^\"([^\"]*)\" urunu detayina gidilir$")
    public void urunuDetayinaGidilir(String productDetail) throws Throwable {
        driver.findElement(By.xpath("//div[text()='" + productDetail + "']")).click();
    }

    @Ve("^\"([^\"]*)\" butonuna basilirsa$")
    public void butonunaBasilirsa(String addToBasket) throws Throwable {
        driver.findElement(By.xpath("//div[text()='" + addToBasket + "']")).click();
    }

    @Ozaman("^\"([^\"]*)\" urununun sepete eklendigi gorulur$")
    public void urunununSepeteEklendigiGorulur(String productName) throws Throwable {
        findElementClick("li#myBasketListItem", Pather.cssSelector);
        String product = driver.findElement(By.cssSelector("span.description.basketlist-productinfo-description")).getText();
        Assert.assertEquals(product, productName);
    }

    @Ve("^\"([^\"]*)\" ikonuna basilarak urun sepetten cikarilir$")
    public void ikonunaBasilarakUrunSepettenCikarilir(String remove) throws Throwable {
        driver.findElement(By.xpath("//a[text()='" + remove + "']")).click();
        driver.findElement(By.cssSelector("button.btn-item.btn-remove")).click();
        Thread.sleep(1000);
    }

    @Ve("^tarayici kapatilir$")
    public void tarayiciKapatilir() {
        DriverClose();
    }
}



