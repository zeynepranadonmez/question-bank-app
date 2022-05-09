package oop.homework;

import java.util.List;
import java.util.Scanner;

public class TestSinav extends Sinav {

    public TestSinav(SoruBankasi sb) {
        super();
        boolean basariliMi = sinavOlustur(sb, SinavTipi.TEST);

        if (basariliMi){
            sinaviBaslat();
        }
    }

    public TestSinav(List<Soru> arr) {
        super(arr);
        sinaviBaslat();
    }

    @Override
    public void soruGetir() {
        Scanner scanner = new Scanner(System.in);

        for(Soru e:getArr()){
            System.out.println();
            System.out.println(e.toString(true, false));
            System.out.print("Cevabiniz: ");
            String kullaniciCevabi = scanner.nextLine();
            e.setKullaniciCevabi(kullaniciCevabi);
        }

        System.out.println("Sinaviniz tamamlanmistir.");
        puanYaz();
        txtYaz();
    }



    private void puanYaz(){
        System.out.printf("Aldiginiz Not: %.2f", puanHesapla());
    }

    private double puanHesapla(){
        double puan = 0;

        for(Soru e:getArr())
            if(e.kontrolEt(ListelemeTipi.DOGRU_SIK, e.getKullaniciCevabi()))
                puan += e.getPuan();

        return puan;
    }
}
