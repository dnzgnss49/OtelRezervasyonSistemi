import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AramaMotoru {
    private List<Otel> TumOteller;

    public AramaMotoru(List<Otel> oteller) {
        this.TumOteller = oteller;
    }

    // Yıldız sayısına göre otel arama
    public List<Otel> yildizSayisinaGoreAra(int yildizSayisi) {
        return TumOteller.stream()
                .filter(otel -> otel.getYildizSayisi() == yildizSayisi)
                .collect(Collectors.toList());
    }

    // Havuz olan otelleri arama
    public List<Otel> havuzluOtelleriAra() {
        return TumOteller.stream()
                .filter(Otel::isHavuzVarMi)
                .collect(Collectors.toList());
    }

    // Otel adına göre otel arama
    public List<Otel> otelAdinaGoreAra(String otelAdi) {
        return TumOteller.stream()
                .filter(otel -> otel.getIsim().toLowerCase().contains(otelAdi.toLowerCase()))
                .collect(Collectors.toList());
    }
}
