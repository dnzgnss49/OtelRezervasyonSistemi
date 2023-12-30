public class Kullanici {
    private String kullaniciAdi;
    private String sifre;
    private String ad;
    private String soyad;
    private String email;

    public Kullanici(String kullaniciAdi, String sifre) {
        this.kullaniciAdi = kullaniciAdi;
        this.sifre = sifre;
        this.ad = ad;
        this.soyad = soyad;
        this.email = email;
    }

    public Kullanici(String yeniKullaniciAdi, String yeniSifre, String ad, String soyad, String email) {
    }

    // Getter ve Setter metodları
    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public void setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Kullanıcı bilgilerini döndüren metod
    public String getKullaniciBilgileri() {
        return "Kullanıcı Adı: " + kullaniciAdi + ", Ad: " + ad + ", Soyad: " + soyad + ", Email: " + email;
    }

    // Kullanıcı girişi doğrulama
    public boolean dogrula(String kullaniciAdi, String sifre) {
        return this.kullaniciAdi.equals(kullaniciAdi) && this.sifre.equals(sifre);
    }
}

