public class TatilKoyu extends Otel {
    private boolean animasyonVarMi;

    public TatilKoyu(String isim, String konum, int yildizSayisi, boolean havuzVarMi, boolean animasyonVarMi) {
        super(isim, konum, yildizSayisi, havuzVarMi);
        this.animasyonVarMi = animasyonVarMi;
    }

    @Override
    public String getOtelTipi() {
        return "Tatil Köyü";
    }

    @Override
    public String getOtelBilgileri() {
        return super.getOtelBilgileri() + ", Animasyon: " + (animasyonVarMi ? "Var" : "Yok");
    }
}
