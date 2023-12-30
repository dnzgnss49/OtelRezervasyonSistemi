import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Raporlama {
    private List<Rezervasyon> rezervasyonlar;

    public Raporlama(List<Rezervasyon> rezervasyonlar) {
        this.rezervasyonlar = rezervasyonlar;
    }

    // Günlük rezervasyon sayısını raporla
    public Map<String, Long> gunlukRezervasyonSayisi() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return rezervasyonlar.stream()
                .collect(Collectors.groupingBy(
                        rezervasyon -> sdf.format(rezervasyon.getBaslangicTarihi()),
                        Collectors.counting()));
    }

    // Otele göre rezervasyon sayısını raporla
    public Map<String, Long> otelRezervasyonSayilari() {
        return rezervasyonlar.stream()
                .collect(Collectors.groupingBy(
                        rezervasyon -> rezervasyon.getOtel().getIsim(),
                        Collectors.counting()));
    }

    // Konuma göre rezervasyon sayısını raporla
    public Map<String, Long> konumaGoreRezervasyonSayilari() {
        return rezervasyonlar.stream()
                .collect(Collectors.groupingBy(
                        rezervasyon -> rezervasyon.getOtel().getKonum(),
                        Collectors.counting()));
    }

    // Belirli bir tarihten sonra yapılan rezervasyonları listele
    public List<Rezervasyon> belirliTarihtenSonraYapilanRezervasyonlar(Date tarih) {
        return rezervasyonlar.stream()
                .filter(rezervasyon -> rezervasyon.getBaslangicTarihi().after(tarih))
                .collect(Collectors.toList());
    }

    // En çok rezervasyon yapılan oteli bul
    public String enCokRezervasyonYapilanOtel() {
        return otelRezervasyonSayilari().entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("Bilgi Yok");
    }

    // En az rezervasyon yapılan oteli bul
    public String enAzRezervasyonYapilanOtel() {
        return otelRezervasyonSayilari().entrySet().stream()
                .min(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("Bilgi Yok");
    }
}
