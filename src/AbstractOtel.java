public abstract class AbstractOtel {
    protected String isim;
    protected String konum;
    protected int yildizSayisi;

    public AbstractOtel(String isim, String konum, int yildizSayisi) {
        this.isim = isim;
        this.konum = konum;
        this.yildizSayisi = yildizSayisi;
    }

    // Getter ve Setter metodları
    public String getIsim() {
        return isim;
    }

    public String getKonum() {
        return konum;
    }

    public int getYildizSayisi() {
        return yildizSayisi;
    }

    // Soyut metod
    public abstract String getOtelTipi();

    // Ortak metod
    public String getOtelBilgileri() {
        return "Otel Adı: " + isim + ", Konum: " + konum + ", Yıldız Sayısı: " + yildizSayisi + ", Tip: " + getOtelTipi();
    }
}
