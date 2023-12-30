public class ButikOtel extends Otel {
    private String tasarimTemi;

    public ButikOtel(String isim, String konum, int yildizSayisi, boolean havuzVarMi, boolean tasarimTemi) {
        super(isim, konum, yildizSayisi, havuzVarMi);
        this.tasarimTemi = String.valueOf(tasarimTemi);
    }

    @Override
    public String getOtelTipi() {
        return "Butik Otel";
    }

    @Override
    public String getOtelBilgileri() {
        return super.getOtelBilgileri() + ", Tasarım Teması: " + tasarimTemi;
    }
}
