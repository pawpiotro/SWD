package Data;

/**
 * Created by Pawel on 19-Jan-17.
 */
public class Case {
    private float ryzyko;
    private float zysk;
    private float gotowka;
    private int wolumen;
    private float cena;
    private int jakosc;
    private float reklamaTV;
    private float reklamaInt;
    private float reklamaMag;

    /*public Case(float ryzyko1, float zysk1, int wolumen1, float cena1, int jakosc1, float reklamaTV1, float reklamaInt1, float reklamaMag1){
        ryzyko = ryzyko1;
        zysk = zysk1;
        wolumen = wolumen1;
        cena = cena1;
        jakosc = jakosc1;
        reklamaTV = reklamaTV1;
        reklamaInt = reklamaInt1;
        reklamaMag = reklamaMag1;
    }

    public Case(int wolumen1, float cena1, int jakosc1, float reklamaTV1, float reklamaInt1, float reklamaMag1){
        wolumen = wolumen1;
        cena = cena1;
        jakosc = jakosc1;
        reklamaTV = reklamaTV1;
        reklamaInt = reklamaInt1;
        reklamaMag = reklamaMag1;
    }*/

    public float getGotowka() {
        return gotowka;
    }

    public void setGotowka(float gotowka) {
        this.gotowka = gotowka;
    }
    public float getRyzyko() {
        return ryzyko;
    }

    public void setRyzyko(float ryzyko) {
        this.ryzyko = ryzyko;
    }

    public float getZysk() {
        return zysk;
    }

    public void setZysk(float zysk) {
        this.zysk = zysk;
    }

    public int getWolumen() {
        return wolumen;
    }

    public void setWolumen(int wolumen) {
        this.wolumen = wolumen;
    }

    public float getCena() {
        return cena;
    }

    public void setCena(float cena) {
        this.cena = cena;
    }

    public int getJakosc() {
        return jakosc;
    }

    public void setJakosc(int jakosc) {
        this.jakosc = jakosc;
    }

    public float getReklamaTV() {
        return reklamaTV;
    }

    public void setReklamaTV(float reklamaTV) {
        this.reklamaTV = reklamaTV;
    }

    public float getReklamaInt() {
        return reklamaInt;
    }

    public void setReklamaInt(float reklamaInt) {
        this.reklamaInt = reklamaInt;
    }

    public float getReklamaMag() {
        return reklamaMag;
    }

    public void setReklamaMag(float reklamaMag) {
        this.reklamaMag = reklamaMag;
    }

    public void print(){
        System.out.println("ryzyko =      " + ryzyko + "\n" +
                            "zysk =       " + zysk + "\n" +
                            "wolumen =    " + wolumen + "\n" +
                            "cena =       " + cena + "\n" +
                            "jakosc =     " + jakosc + "\n" +
                            "reklamaTV =  " + reklamaTV + "\n" +
                            "reklamaInt = " + reklamaInt + "\n" +
                            "reklamaMag = " + reklamaMag + "\n");
    }
}
