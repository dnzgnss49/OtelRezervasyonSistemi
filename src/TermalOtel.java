public class TermalOtel extends Otel {
    private boolean spaVarMi;

    public TermalOtel(String isim, String konum, int yildizSayisi, boolean havuzVarMi, boolean spaVarMi) {
        super(isim, konum, yildizSayisi, havuzVarMi);
        this.spaVarMi = spaVarMi;
    }

    @Override
    public String getOtelTipi() {
        return "Termal Otel";
    }

    @Override
    public String getOtelBilgileri() {
        return super.getOtelBilgileri() + ", Spa: " + (spaVarMi ? "Var" : "Yok");
    }
}