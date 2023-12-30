public class Otel extends AbstractOtel {
    private boolean havuzVarMi;

    public Otel(String isim, String konum, int yildizSayisi, boolean havuzVarMi) {
        super(isim, konum, yildizSayisi);
        this.havuzVarMi = havuzVarMi;
    }

    @Override
    public String getOtelTipi() {
        return "Standart Otel";
    }

    // Havuz varlığını kontrol eden metod
    public boolean isHavuzVarMi() {
        return havuzVarMi;
    }
}
