public class KullaniciGirdisiDogrulama {

    public void kullaniciAdiDogrula(String kullaniciAdi) throws InvalidInputException {
        if (kullaniciAdi == null || kullaniciAdi.isEmpty()) {
            throw new InvalidInputException("Kullanıcı adı boş olamaz.");
        }
        // Diğer doğrulama kuralları buraya eklenebilir.
    }

    // Benzer şekilde diğer girdi doğrulama metodları.

    // Özel aykırı durum sınıfı
    public static class InvalidInputException extends Exception {
        public InvalidInputException(String message) {
            super(message);
        }
    }
}

