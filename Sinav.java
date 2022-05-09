package oop.homework;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Sinav {
    private List<Soru> arr = new ArrayList<Soru>();

    public Sinav(){ }

    public Sinav(List<Soru> arr) {
        this.arr = arr;
    }

    public List<Soru> getArr() {
        return arr;
    }

    public void setArr(List<Soru> arr) {
        this.arr = arr;
    }

    public void soruEkle(Soru soru){
        arr.add(soru);
    }

    public boolean sinavOlustur(SoruBankasi sb, SinavTipi tip){
        double toplamPuan = 0;
        boolean basariliMi = false;

        List<Soru> arr = sb.filtrele(tip);

        double filtrelenmisToplamPuan = SoruBankasi.toplamPuan(arr);

        if(filtrelenmisToplamPuan < 100){
            System.out.println("\nBu sinav turu icin yeteri kadar soru bulunmamaktadir.\n"+
                                "Lutfen soru bankasina soru ekleyiniz.\n");
            return false;
        }

        while(true){
            if(toplamPuan >= 100 && toplamPuan <= 110){
                basariliMi = true;
                break;
            }

            Random random = new Random();
            Soru soru = arr.get(random.nextInt(arr.size()));

            if(!varMi(this.arr, soru)){
                toplamPuan += soru.getPuan();
                soruEkle(soru);
            }
        }

        return basariliMi;
    }

    public boolean varMi(List<Soru> arr, Soru soru){
        for(Soru e: arr)
            if(e.equals(soru))
                return true;

        return false;
    }

    public void sinaviBaslat(){
        System.out.println("Sinavinizda "+arr.size()+" adet soru bulunmaktadir.");
        System.out.println("Basarilar.");

        soruGetir();
    }



    public void soruGetir() {
        Scanner scanner = new Scanner(System.in);

        for(Soru e:arr){
            System.out.println();
            System.out.println(e.toString(true, false));
            System.out.print("Cevabiniz: ");
            String kullaniciCevabi = scanner.nextLine();
            e.setKullaniciCevabi(kullaniciCevabi);
        }

        System.out.println("Sinaviniz tamamlanmistir.");

        txtYaz();
    }

    public String arrToString(){
        StringBuilder sb = new StringBuilder();
        for(Soru s: arr)
            sb.append(s.toString(true, true)).append("\n");

        return sb.toString();
    }

    public void txtYaz() {
        try{
            FileWriter fw = new FileWriter("sinav.txt");
            PrintWriter pw = new PrintWriter(fw);

            pw.println(arrToString());

            pw.close();
        } catch (IOException e) {
            System.err.println(e);
        }
    }

}
