import java.util.*;

public class VeriDepolama {
    private Map<String, Kullanici> kullaniciMap;
    private Map<String, Otel> TumOteller;
    private List<Rezervasyon> rezervasyonlar;

    public VeriDepolama() {
        this.kullaniciMap = new HashMap<>();
        this.TumOteller = new HashMap<>();
        TumOteller.put("Şehir Oteli", new SehirOteli("Şehir Oteli", "İstanbul", 5, true, true));
        TumOteller.put("Dağ Evi", new DagEvi("Dağ Evi", "Bolu", 3, false, true));
        TumOteller.put("Dağ Evi2", new DagEvi("Dağ Evi", "Düzcede", 2, true, true));
        TumOteller.put("Termal Otel", new TermalOtel("Termal Otel", "Bursa", 5, true, true));
        TumOteller.put("Tatil Köyü", new TatilKoyu("Tatil Köyü", "Muğla", 4, true, true));
        TumOteller.put("Butik Otel", new ButikOtel("Butik Otel", "Ankara", 4, false, false));
        this.rezervasyonlar = new ArrayList<>();
    }

    // Kullanıcı ekleme
    public void kullaniciEkle(Kullanici kullanici) {
        kullaniciMap.put(kullanici.getKullaniciAdi(), kullanici);
    }

    // Otel ekleme
    public void otelEkle(Otel otel) {
        TumOteller.put(otel.getIsim(), otel);
    }

    // Rezervasyon ekleme
    public void rezervasyonEkle(Rezervasyon rezervasyon) {
        rezervasyonlar.add(rezervasyon);
    }

    // Kullanıcı alma
    public Kullanici getKullanici(String kullaniciAdi) {
        return kullaniciMap.get(kullaniciAdi);
    }

    // Otel alma
    /*public Otel getOtel(String otelAdi) {
        return TumOteller.get(otelAdi);
    }

    // Tüm otelleri alma
    public Collection<Otel> getTumOteller() {
        return TumOteller.values();
    }
*/
    public Map<String, Otel> getTumOteller() {
        return new HashMap<>(TumOteller);
    }
    // Rezervasyonları alma
    public List<Rezervasyon> getRezervasyonlar() {
        return new ArrayList<>(rezervasyonlar);
    }

    // Kullanıcıları silme
    public void kullaniciSil(String kullaniciAdi) {
        kullaniciMap.remove(kullaniciAdi);
    }

    // Otel silme
    public void otelSil(String otelAdi) {
        TumOteller.remove(otelAdi);
    }
}
