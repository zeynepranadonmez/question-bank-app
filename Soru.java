package oop.homework;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Soru implements Comparable<Soru> {

    private String soruMetni;
    private double puan;
    private Zorluk zorluk;
    private String dogruCevap;
    private String kullaniciCevabi;

    public Soru(){
        this.soruMetni = "";
        this.puan = 0.0;
        this.zorluk = Zorluk.NORMAL;
        this.dogruCevap = "";
        this.kullaniciCevabi = "";
    }

    public Soru(String soruMetni, double puan, Zorluk zorluk, String dogruCevap){
        this.soruMetni = soruMetni;
        this.puan = puan;
        this.zorluk = zorluk;
        this.dogruCevap = dogruCevap;
        this.kullaniciCevabi = "";
    }


    public String getSoruMetni(){
        return soruMetni;
    }

    public void setSoruMetni(String deger){
        this.soruMetni = deger;
    }

    public double getPuan(){
        return puan;
    }

    public void setPuan(double deger){
        this.puan = deger;
    }

    public Zorluk getZorluk(){
        return zorluk;
    }

    public void setZorluk(Zorluk deger){
        this.zorluk = deger;
    }

    public String getDogruCevap(){
        return dogruCevap;
    }

    public void setDogruCevap(String deger){
        this.dogruCevap = deger;
    }

    public String getKullaniciCevabi(){
        return kullaniciCevabi;
    }

    public void setKullaniciCevabi(String deger){
        this.kullaniciCevabi = deger;
    }

    public <T> boolean kontrolEt(ListelemeTipi tip, T deger) {
        boolean temp = false;

        switch (tip) {
            case SORU_METNI -> temp = soruMetniKontrolEt(this.getSoruMetni(), (String) deger);
            case PUAN -> temp = puanKontrolEt(this.getPuan(), (Double) deger);
            case ZORLUK -> temp = zorlukKontrolEt(this.getZorluk(), (Zorluk) deger);
            case DOGRU_SIK -> temp = soruSikkiKontrolEt(this.getDogruCevap(), (String) deger);
            default -> System.out.println("Sectiginiz filtreleme turu mevcut degildir.");
        }

        return temp;
    }

    public boolean soruMetniKontrolEt(String anahtar ,String deger){
        Pattern pattern = Pattern.compile(deger, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);

        Matcher matcher = pattern.matcher(anahtar);

        return matcher.find();
    }

    public boolean soruSikkiKontrolEt(String anahtar ,String deger){
        Pattern pattern = Pattern.compile(deger, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);

        Matcher matcher = pattern.matcher(anahtar);

        return matcher.find();
    }


    public boolean puanKontrolEt(double anahtar , double deger){
        Pattern pattern = Pattern.compile("\\d+[.,]?\\d+", Pattern.UNICODE_CHARACTER_CLASS);

        String degerStr = Double.toString(deger);

        Matcher matcher = pattern.matcher(degerStr);

        boolean matchFound = matcher.find();

        if (!matchFound){
            return false;
        }

        return anahtar == deger;
    }

    public boolean zorlukKontrolEt(Zorluk anahtar ,Zorluk deger){
        return anahtar == deger;
    }

    public String toString(boolean sinavMi, boolean kullaniciCevabiGoster) {
        if(sinavMi && !kullaniciCevabiGoster){
            return String.format("SORU: %s\r\nPUAN: %.2f\r\n",
                    soruMetni, puan);
        } else if (sinavMi && kullaniciCevabiGoster){
            return String.format("SORU: %s\r\nPUAN: %.2f\r\nZORLUK: %s\r\nDOGRU_CEVAP: %s\r\nKULLANICI_CEVABI: %s\r\n",
                    soruMetni, puan, zorluk.toString(), dogruCevap, kullaniciCevabi);
        }

        return String.format("SORU: %s\r\nPUAN: %.2f\r\nZORLUK: %s\r\nDOGRU_CEVAP: %s\r\n",
                soruMetni, puan, zorluk.toString(), dogruCevap);
    }

    @Override
    public int compareTo(Soru s) {
        return Double.compare(puan, s.puan);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Soru soru = (Soru) o;
        return Double.compare(soru.puan, puan) == 0 && soruMetni.equals(soru.soruMetni) && zorluk == soru.zorluk && dogruCevap.equals(soru.dogruCevap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(soruMetni, puan, zorluk, dogruCevap);
    }
}
