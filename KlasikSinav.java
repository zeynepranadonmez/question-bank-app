package oop.homework;

import java.util.List;

public class KlasikSinav extends Sinav{
    public KlasikSinav(SoruBankasi sb) {
        super();
        boolean basariliMi = sinavOlustur(sb, SinavTipi.KLASIK);

        if (basariliMi){
            sinaviBaslat();
        }
    }

    public KlasikSinav(List<Soru> arr) {
        super(arr);
        sinaviBaslat();
    }
}
