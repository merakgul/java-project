#language:tr
Özellik: Hepsiburada test
#  @register

  Senaryo: Kullanici girisi yapilarak sepete urun eklenmesi hepsiburada
    Diyelim ki Hepsiburada sayfasini "https://www.hepsiburada.com/" acalim
    Ve "Giriş Yap" secenegine tiklanir
    Ve "email" alanina "akgul.meryem@gmail.com" yazilir
    Ve "password" alanina "test.123" yazilir
    Ve giris butonuna tiklanir
    Ve kullanici ikonun yaninda ad soyad kisminin "Meryem Akgül" oldugu gorulur
    Ve arama bolumune "Apple iPhone 8 64 GB (Apple Türkiye Garantili) (64 GB Gold)" yazilip ara butonuna basilir
    Ve "Apple iPhone 8  64 GB (Apple Türkiye Garantili) (64 GB Gold)" adli urun secilir
    Ve sepete iki adet urun atilir
    Ve atilan urunlerin "Apple iPhone 8 64 GB (Apple Türkiye Garantili) (64 GB Gold)" oldugu gorulur

#  @register
  Senaryo: Kullanici girisi yapilmadan sepete urun eklenmesi hepsiburada
    Diyelim ki Hepsiburada sayfasini "https://www.hepsiburada.com/" acalim
    Ve arama bolumune "Apple iPhone 8 64 GB (Apple Türkiye Garantili) (64 GB Gold)" yazilip ara butonuna basilir
    Ve "Apple iPhone 8  64 GB (Apple Türkiye Garantili) (64 GB Gold)" adli urun secilir
    Ve sepete iki adet urun atilir
    Ve atilan urunlerin "Apple iPhone 8 64 GB (Apple Türkiye Garantili) (64 GB Gold)" oldugu gorulur


