package oop.homework;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Objects;

public class CoktanSecmeliSoru extends Soru {

    private Hashtable<String, String> siklar;

    public CoktanSecmeliSoru(){
        super();
        this.siklar = new Hashtable<String, String>();
    }

    public CoktanSecmeliSoru(String soruMetni, double puan, Zorluk zorluk, String dogruCevap, Hashtable<String, String> siklar){
        super(soruMetni, puan, zorluk, dogruCevap);
        this.siklar = siklar;
    }

    public Hashtable<String, String> getSiklar() {
        return siklar;
    }

    public void putSiklar(String anahtar, String deger){
        siklar.put(anahtar, deger);
    }

    @Override
    public <T> boolean kontrolEt(ListelemeTipi tip, T deger){
        boolean temp = false;

        switch(tip){
            case SORU_METNI -> temp = soruMetniKontrolEt(this.getSoruMetni(), (String) deger);
            case SORU_SIKLARI -> {
                for (Enumeration<String> s = siklar.elements(); s.hasMoreElements();){
                    if(soruSikkiKontrolEt(s.nextElement(), (String) deger)){
                        temp = true;
                        break;
                    }
                }
            }
            case PUAN -> temp = puanKontrolEt(this.getPuan(), (Double) deger);
            case ZORLUK -> temp = zorlukKontrolEt(this.getZorluk(), (Zorluk) deger);
            case DOGRU_SIK -> temp = soruSikkiKontrolEt(this.getDogruCevap(), (String) deger);
            default -> System.out.println("Sectiginiz filtreleme turu mevcut degildir.");
        }

        return temp;
    }

    public String toString(boolean sinavMi, boolean kullaniciCevabiGoster) {
        if (sinavMi && !kullaniciCevabiGoster){
            return String.format("SORU: %s\r\nPUAN: %.2f\r\nA: %s\r\nB: %s\r\nC: %s\r\nD: %s\r\n",
                    getSoruMetni(),
                    getPuan(),
                    siklar.get("A"),
                    siklar.get("B"),
                    siklar.get("C"),
                    siklar.get("D"));
        } else if (sinavMi && kullaniciCevabiGoster){
            return String.format("SORU: %s\r\nPUAN: %.2f\r\nZORLUK: %s\r\nA: %s\r\nB: %s\r\nC: %s\r\nD: %s\r\nDOGRU_CEVAP: %s\r\nKULLANICI_CEVABI: %s\r\n",
                    getSoruMetni(),
                    getPuan(),
                    getZorluk().toString(),
                    siklar.get("A"),
                    siklar.get("B"),
                    siklar.get("C"),
                    siklar.get("D"),
                    getDogruCevap(),
                    getKullaniciCevabi());
        }

        return String.format("SORU: %s\r\nPUAN: %.2f\r\nZORLUK: %s\r\nA: %s\r\nB: %s\r\nC: %s\r\nD: %s\r\nDOGRU_CEVAP: %s\r\n",
                getSoruMetni(),
                getPuan(),
                getZorluk().toString(),
                siklar.get("A"),
                siklar.get("B"),
                siklar.get("C"),
                siklar.get("D"),
                getDogruCevap());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CoktanSecmeliSoru that = (CoktanSecmeliSoru) o;
        return siklar.equals(that.siklar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), siklar);
    }
}


