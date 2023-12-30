import java.util.Date;

public class Rezervasyon {
    private Otel otel;
    private Date baslangicTarihi;
    private Date bitisTarihi;
    private String musteriAdi;

    public Rezervasyon(Otel otel, Date baslangicTarihi, Date bitisTarihi, String musteriAdi) {
        this.otel = otel;
        this.baslangicTarihi = baslangicTarihi;
        this.bitisTarihi = bitisTarihi;
        this.musteriAdi = musteriAdi;
    }

    // Getter ve Setter metodları
    public Otel getOtel() {
        return otel;
    }

    public void setOtel(Otel otel) {
        this.otel = otel;
    }

    public Date getBaslangicTarihi() {
        return baslangicTarihi;
    }

    public void setBaslangicTarihi(Date baslangicTarihi) {
        this.baslangicTarihi = baslangicTarihi;
    }

    public Date getBitisTarihi() {
        return bitisTarihi;
    }

    public void setBitisTarihi(Date bitisTarihi) {
        this.bitisTarihi = bitisTarihi;
    }

    public String getMusteriAdi() {
        return musteriAdi;
    }

    public void setMusteriAdi(String musteriAdi) {
        this.musteriAdi = musteriAdi;
    }
}