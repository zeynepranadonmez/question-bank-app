package oop.homework;

import java.util.List;

public class KarisikSinav extends Sinav {
    public KarisikSinav(SoruBankasi sb) {
        super();
        boolean basariliMi = sinavOlustur(sb, SinavTipi.KARISIK);

        if (basariliMi){
            sinaviBaslat();
        }
    }

    public KarisikSinav(List<Soru> arr) {
        super(arr);
        sinaviBaslat();
    }
}
