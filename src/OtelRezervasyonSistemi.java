import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class OtelRezervasyonSistemi {

    public static void main(String[] args) {

        VeriDepolama veriDepolama = veriOlustur();
        AramaMotoru aramaMotoru = new AramaMotoru(veriDepolama.getTumOteller().values().stream().toList());
        Map<String, Otel> oteller = veriDepolama.getTumOteller();
        Raporlama raporlama = new Raporlama(veriDepolama.getRezervasyonlar());
        Scanner scanner = new Scanner(System.in);

        System.out.println("Otel Rezervasyon Sistemine Hoş Geldiniz!");
        System.out.print("Lütfen kullanıcı adınızı giriniz: ");
        String kullaniciAdi = scanner.nextLine();

        Kullanici kullanici = veriDepolama.getKullanici(kullaniciAdi);

        if (kullanici == null) {
            System.out.println("Kullanıcı bulunamadı. Kayıt olmak ister misiniz? (evet/hayır)");
            String cevap = scanner.nextLine();
            if ("evet".equalsIgnoreCase(cevap)) {
                System.out.print("Kullanıcı adı oluşturunuz: ");
                String yeniKullaniciAdi = scanner.nextLine();
                System.out.print("Şifre oluşturunuz: ");
                String yeniSifre = scanner.nextLine();
                System.out.print("Adınız: ");
                String ad = scanner.nextLine();
                System.out.print("Soyadınız: ");
                String soyad = scanner.nextLine();
                System.out.print("Email adresiniz: ");
                String email = scanner.nextLine();

                kullanici = new Kullanici(yeniKullaniciAdi, yeniSifre, ad, soyad, email);
                veriDepolama.kullaniciEkle(kullanici);
                System.out.println("Kullanıcı başarıyla kaydedildi.");
            } else {
                System.out.println("Kayıt olmadan sistemi kullanamazsınız.");
                return;
            }
        }

// Ana menü
        List<Otel> bulunanOteller = null;
        while (true) {

            System.out.println("\nYapmak istediğiniz işlemi seçiniz:");
            if (bulunanOteller != null && bulunanOteller.size()>0) {
                System.out.println("1. Yeni Otel Ara");
                System.out.println("2. Bulunan Otellere Rezervasyon Yap");
            } else {
                System.out.println("1. Otel Ara");
                System.out.println("2. Rezervasyon Yap");
            }
            System.out.println("3. Çıkış Yap");
            System.out.print("Seçiminiz: ");
            int secim = scanner.nextInt();
            scanner.nextLine(); // Girdi tamponunu temizle

            if (secim == 1) {
                bulunanOteller = otelAra(aramaMotoru, scanner);
            } else if (secim == 2) {
                rezervasyonYap(aramaMotoru, veriDepolama, scanner, kullanici);
            } else if (secim == 3) {
                break;
            } else {
                System.out.println("Geçersiz seçim, tekrar deneyin.");
            }
        }

        scanner.close();
        System.out.println("Sistemden çıkılıyor.");
    }

    private static List<Otel> otelAra(AramaMotoru aramaMotoru, Scanner scanner) {
        System.out.print("Aramak istediğiniz otel adını giriniz: ");
        String otelAdi = scanner.nextLine();
        List<Otel> tumOteller = aramaMotoru.otelAdinaGoreAra(otelAdi);
        for (Otel otel : tumOteller) {
            System.out.println(otel.getOtelBilgileri());
        }
        if (tumOteller == null || tumOteller.isEmpty()) {
            System.out.println("Belirtilen adla otel bulunamadı.");
        } else {

        }
        return tumOteller;
    }

    private static void rezervasyonYap(AramaMotoru aramaMotoru, VeriDepolama veriDepolama, Scanner scanner, Kullanici kullanici) {
        System.out.print("Rezervasyon yapmak istediğiniz otel adını giriniz: ");
        String otelAdi = scanner.nextLine();
        List<Otel> TumOteller = aramaMotoru.otelAdinaGoreAra(otelAdi);

        if (TumOteller == null || TumOteller.isEmpty()) {
            System.out.println("Belirtilen adla otel bulunamadı.");
            return;
        }

        Otel secilenOtel = TumOteller.get(0); // İlk eşleşen oteli al

        System.out.print("Başlangıç tarihi (yyyy/MM/dd): ");
        String baslangicTarihiStr = scanner.nextLine();
        System.out.print("Bitiş tarihi (yyyy/MM/dd): ");
        String bitisTarihiStr = scanner.nextLine();

        // Tarih formatlama ve dönüşümü
        Date baslangicTarihi = new Date(baslangicTarihiStr);
        Date bitisTarihi = new Date(bitisTarihiStr);

        Rezervasyon yeniRezervasyon = new Rezervasyon(secilenOtel, baslangicTarihi, bitisTarihi, kullanici.getKullaniciAdi());
        veriDepolama.rezervasyonEkle(yeniRezervasyon);

        System.out.println("Rezervasyon başarıyla yapıldı.");
    }

    private static VeriDepolama veriOlustur() {
        VeriDepolama veriDepolama = new VeriDepolama();

        // Kullanıcılar ekleme
        veriDepolama.kullaniciEkle(new Kullanici("", ""));

        return veriDepolama;
    }
}