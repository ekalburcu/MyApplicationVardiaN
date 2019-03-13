package vardia.com.tr.myapplication;

public class Globals {


    private static Globals instance;


    private String baslik;
    private String ilce;
    private String tarih;
    private String saat;
    private String pozisyon;
    private String kiyafet;
    private String ucret;


    private Globals(){

    }


    public String getBaslik() {
        return baslik;
    }

    public void setBaslik(String baslik) {
        this.baslik = baslik;
    }

    public String getIlce() {
        return ilce;
    }

    public void setIlce(String ilce) {
        this.ilce = ilce;
    }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }

    public String getSaat() {
        return saat;
    }

    public void setSaat(String saat) {
        this.saat = saat;
    }

    public String getPozisyon() {
        return pozisyon;
    }

    public void setPozisyon(String pozisyon) {
        this.pozisyon = pozisyon;
    }

    public String getKiyafet() {
        return kiyafet;
    }

    public void setKiyafet(String kiyafet) {
        this.kiyafet = kiyafet;
    }

    public String getUcret() {
        return ucret;
    }

    public void setUcret(String ucret) {
        this.ucret = ucret;
    }


    public static Globals getInstance(){
        if (instance == null){
            instance = new Globals();
        }
        return instance;
    }
}
