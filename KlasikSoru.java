package oop.homework;

public class KlasikSoru extends Soru {
    public KlasikSoru() {
        super();
    }

    public KlasikSoru(String soruMetni, double puan, Zorluk zorluk) {
        super(soruMetni, puan, zorluk, "");
    }

    public String toString(boolean sinavMi, boolean kullaniciCevabiGoster) {
        if (sinavMi && !kullaniciCevabiGoster){
            return String.format("SORU: %s\r\nPUAN: %.2f\r\n",
                    getSoruMetni(),
                    getPuan());
        } else if (sinavMi && kullaniciCevabiGoster){
            return String.format("SORU: %s\r\nPUAN: %.2f\r\nZORLUK: %s\r\nKULLANICI_CEVABI: %s\r\n",
                    getSoruMetni(),
                    getPuan(),
                    getZorluk().toString(),
                    getKullaniciCevabi());
        }

        return String.format("SORU: %s\r\nPUAN: %.2f\r\nZORLUK: %s\r\n",
                getSoruMetni(),
                getPuan(),
                getZorluk().toString());
    }
}
