import java.util.List;
import java.util.Scanner;
import java.util.Date;

public class KonsolArayuzu {
    private AramaMotoru aramaMotoru;
    private Raporlama raporlama;
    private VeriDepolama veriDepolama;
    private Scanner scanner;

    public KonsolArayuzu(AramaMotoru aramaMotoru, Raporlama raporlama, VeriDepolama veriDepolama) {
        this.aramaMotoru = aramaMotoru;
        this.raporlama = raporlama;
        this.veriDepolama = veriDepolama;
        this.scanner = new Scanner(System.in);
    }

    public void baslat() {
        String komut;
        System.out.println("Otel Rezervasyon Sistemine Hoş Geldiniz!");

        while (true) {
            System.out.println("\nKomutları giriniz ('cikis' ile çıkabilirsiniz): ");
            komut = scanner.nextLine();

            if ("cikis".equalsIgnoreCase(komut)) {
                break;
            }

            islemleriYonet(komut);
        }

        scanner.close();
        System.out.println("Sistemden çıkılıyor.");
    }

    private void islemleriYonet(String komut) {
        switch (komut) {
            case "otelAra":
                otelAra();
                break;
            case "rezervasyonYap":
                rezervasyonYap();
                break;
            case "raporGoruntule":
                raporGoruntule();
                break;
            default:
                System.out.println("Bilinmeyen komut. Lütfen geçerli bir komut giriniz.");
        }
    }

    private void otelAra() {
        System.out.println("Otel arama kriterlerini giriniz (örn: yıldız sayısı): ");
        int yildizSayisi = scanner.nextInt();
        List<Otel> bulunanOteller = aramaMotoru.yildizSayisinaGoreAra(yildizSayisi);
        bulunanOteller.forEach(otel -> System.out.println(otel.getOtelBilgileri()));
    }

    private void rezervasyonYap() {
        // Kullanıcıdan rezervasyon bilgileri alınır ve işlenir
        // Örnek olarak basit bir rezervasyon işlemi
        System.out.println("Rezervasyon yapılacak otelin adını giriniz: ");
        String otelAdi = scanner.next();
        // ... Diğer rezervasyon bilgileri alınır ve işlenir
        System.out.println("Rezervasyon başarıyla yapıldı.");
    }

    private void raporGoruntule() {
        // Raporlama işlevleri
        System.out.println("Raporlar burada gösterilecek.");
        //En çok rezervasyon yapılan oteli gösterir
        String populerOtel = raporlama.enCokRezervasyonYapilanOtel();
        System.out.println("En çok rezervasyon yapılan otel: " + populerOtel);
    }
}

