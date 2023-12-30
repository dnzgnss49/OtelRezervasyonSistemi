public class DagEvi extends Otel {
    private boolean kayakImkani;

    public DagEvi(String isim, String konum, int yildizSayisi, boolean havuzVarMi, boolean kayakImkani) {
        super(isim, konum, yildizSayisi, havuzVarMi);
        this.kayakImkani = kayakImkani;
    }

    @Override
    public String getOtelTipi() {
        return "Dağ Evi";
    }

    @Override
    public String getOtelBilgileri() {
        return super.getOtelBilgileri() + ", Kayak İmkanı: " + (kayakImkani ? "Var" : "Yok");
    }
}