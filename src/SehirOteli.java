public class SehirOteli extends Otel {
    private boolean toplantiSalonuVarMi;

    public SehirOteli(String isim, String konum, int yildizSayisi, boolean havuzVarMi, boolean toplantiSalonuVarMi) {
        super(isim, konum, yildizSayisi, havuzVarMi);
        this.toplantiSalonuVarMi = toplantiSalonuVarMi;
    }

    @Override
    public String getOtelTipi() {
        return "Şehir Oteli";
    }

    @Override
    public String getOtelBilgileri() {
        return super.getOtelBilgileri() + ", Toplantı Salonu: " + (toplantiSalonuVarMi ? "Var" : "Yok");
    }
}

