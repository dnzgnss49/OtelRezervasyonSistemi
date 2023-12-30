import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;

public class Dosyaİslemleri {

    public void dosyaOku(String dosyaYolu) {
        try {
            String icerik = new String(Files.readAllBytes(Paths.get(dosyaYolu)), StandardCharsets.UTF_8);
            System.out.println(icerik);
        } catch (IOException e) {
            System.err.println("Dosya okunurken hata oluştu: " + e.getMessage());
        } catch (OutOfMemoryError e) {
            System.err.println("Dosya çok büyük, hafıza yetersiz: " + e.getMessage());
        } catch (SecurityException e) {
            System.err.println("Dosya okuma izni yok: " + e.getMessage());
        }
    }

    public void dosyaYaz(String dosyaYolu, String icerik) {
        try {
            Files.write(Paths.get(dosyaYolu), icerik.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            System.err.println("Dosyaya yazılırken hata oluştu: " + e.getMessage());
        } catch (UnsupportedOperationException e) {
            System.err.println("Bu dosya sistemi bu işlemi desteklemiyor: " + e.getMessage());
        } catch (SecurityException e) {
            System.err.println("Dosyaya yazma izni yok: " + e.getMessage());
        }
    }

    // Diğer dosya işlemleri için benzer hata yönetimleri eklenebilir.
}
