import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class KullaniciKayit {
    private Map<String, Kullanici> kullaniciVeritabani;

    public KullaniciKayit() {
        this.kullaniciVeritabani = new HashMap<>();
    }

    public void yeniKullaniciKaydet() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Kullanıcı adı oluşturunuz: ");
        String kullaniciAdi = scanner.nextLine();
        System.out.print("Şifre oluşturunuz: ");
        String sifre = scanner.nextLine();
        System.out.print("Adınız: ");
        String ad = scanner.nextLine();
        System.out.print("Soyadınız: ");
        String soyad = scanner.nextLine();
        System.out.print("Email adresiniz: ");
        String email = scanner.nextLine();

        if (kullaniciVeritabani.containsKey(kullaniciAdi)) {
            System.out.println("Bu kullanıcı adı zaten alınmış. Başka bir kullanıcı adı deneyiniz.");
        } else {
            Kullanici yeniKullanici = new Kullanici(kullaniciAdi, sifre);
            yeniKullanici.setAd(ad);
            yeniKullanici.setSoyad(soyad);
            yeniKullanici.setEmail(email);
            kullaniciVeritabani.put(kullaniciAdi, yeniKullanici);
            System.out.println("Kullanıcı başarıyla kaydedildi.");
        }
    }

    public Kullanici kullaniciGirisYap() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Kullanıcı adınızı giriniz: ");
        String kullaniciAdi = scanner.nextLine();
        System.out.print("Şifrenizi giriniz: ");
        String sifre = scanner.nextLine();

        Kullanici kullanici = kullaniciVeritabani.get(kullaniciAdi);
        if (kullanici != null && kullanici.dogrula(kullaniciAdi, sifre)) {
            System.out.println("Giriş başarılı.");
            return kullanici;
        } else {
            System.out.println("Kullanıcı adı veya şifre yanlış.");
            return null;
        }
    }

    // Kullanıcı bilgilerini almak için ekstra metodlar eklenebilir
}

