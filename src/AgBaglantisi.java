import java.net.HttpURLConnection;
import java.net.URL;

public class AgBaglantisi {

    public void urlBaglan(String urlAdresi) {
        try {
            URL url = new URL(urlAdresi);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Bağlantı başarılı
            } else {
                // Hata durumu
            }
        } catch (Exception e) {
            System.err.println("URL bağlantısı sırasında hata oluştu: " + e.getMessage());
        }
    }
    
}

