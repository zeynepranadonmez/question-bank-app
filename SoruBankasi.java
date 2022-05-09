package oop.homework;

import java.util.*;
import java.util.regex.Pattern;

public class SoruBankasi{

    static Scanner sc = new Scanner(System.in);
    private List<Soru> arr = new ArrayList<Soru>();

    public SoruBankasi(){ }

    public void anaMenu(){
        StringBuilder menu = new StringBuilder();
        menu.append("------------- SORU BANKASI -------------\n");
        menu.append("\n1- Soru Ekle\n");
        menu.append("2- Soru Cikar\n");
        menu.append("3- Sorulari Listele\n");
        menu.append("4- Bir Onceki Menuye Don\n");
        menu.append("\nYapmak Istediginiz Islemin Numarasini Giriniz : ");
        System.out.print(menu.toString());
    }

    private void soruEkleMenu(){
        StringBuilder menu = new StringBuilder();
        menu.append("------------- SORU EKLE -------------\n");
        menu.append("\n1- Klasik Soru Ekle\n");
        menu.append("2- Dogru Yanlis Soru Ekle\n");
        menu.append("3- Coktan Secmeli Soru Ekle\n");
        menu.append("4- Bosluk Doldurmali Soru Ekle\n");
        menu.append("5- Bir Onceki Menuye Don Ekle\n");
        menu.append("\nYapmak Istediginiz Islemin Numarasini Giriniz : ");
        System.out.print(menu.toString());
    }

    private void soruCikarMenu(){
        StringBuilder menu = new StringBuilder();
        menu.append("------------- SORU CIKAR -------------\n");
        menu.append("\nSoru cikartmak icin oncelikle soru metnine gore arama yapmalisiniz\n");
        menu.append(" Bir Onceki Menuye Donmek Icin 'e' harfini giriniz\n");
        menu.append("\nSoru metni ya da e harfini Giriniz : ");
        System.out.print(menu.toString());
    }

    private void soruListeleMenu(){
        StringBuilder menu = new StringBuilder();
        menu.append("------------- SORU LISTELEME -------------\n");
        menu.append("\n1- Soru Metnine Gore Filtreleyerek Listele\n");
        menu.append("2- Soru Siklarinin Icindeki Metinlere Gore Filtreleyerek Listele\n");
        menu.append("3- Dogru Sikka Gore Filtreleyerek Listele\n");
        menu.append("4- Puana Gore Filtreleyerek Listele\n");
        menu.append("5- Zorluga Gore Filtreleyerek Listele\n");
        menu.append("6- Tumunu Listele\n");
        menu.append("7- Bir Onceki Menuye Don Ekle\n");
        menu.append("\nYapmak Istediginiz Islemin Numarasini Giriniz : ");
        System.out.print(menu.toString());
    }

    public void anaSecim(){
        while(true){
            Scanner sc = new Scanner(System.in);
            byte secim = sc.nextByte();

            if (secim == 1){
                soruEkleMenu();
                soruEkleSecim();
            } else if (secim == 2){
                if (arr.size() == 0) {
                    System.out.println("Isleminizi gerceklestiremiyoruz. Soru bankasi bos.");
                } else {
                    soruCikarMenu();
                    soruCikarSecim();
                }
            } else if (secim == 3){
                if (arr.size() == 0) {
                    System.out.println("Isleminizi gerceklestiremiyoruz. Soru bankasi bos.");
                } else {
                    soruListeleMenu();
                    soruListeleSecim();
                }
            } else if (secim == 4){
                break;
            } else {
                System.out.println("Gecersiz giris. lutfen yeniden deneyin.");
                System.out.print("Yapmak Istediginiz Islemin Numarasini Giriniz : ");
            }

            if(secim > 0 && secim < 4)
                anaMenu();
        }
    }

    private void soruListeleSecim(){
        while(true){
            byte secim = Main.scanner.nextByte();

            if (secim == 1){
                System.out.print("Metin giriniz: ");
                String metin = sc.nextLine();
                filtreleyerekListele(ListelemeTipi.SORU_METNI, metin);
            } else if  (secim == 2){
                System.out.print("Soru sikki giriniz: ");
                String soruSikki = sc.nextLine();
                filtreleyerekListele(ListelemeTipi.SORU_SIKLARI, soruSikki);
            } else if (secim == 3){
                System.out.print("Dogru soru sikki giriniz: ");
                String soruSikki = sc.nextLine();
                filtreleyerekListele(ListelemeTipi.DOGRU_SIK, soruSikki);
            } else if (secim == 4){
                System.out.print("Puan giriniz: ");
                double puan = Main.scanner.nextDouble();
                filtreleyerekListele(ListelemeTipi.PUAN, puan);
            } else if (secim == 5) {
                Zorluk z;
                while(true){
                    System.out.print("Zorluk giriniz (KOLAY-NORMAL-ZOR): ");
                    String zorluk = Main.scanner.next();

                    if (zorluk.equalsIgnoreCase("kolay")){
                        z = Zorluk.KOLAY;
                        break;
                    } else if(zorluk.equalsIgnoreCase("normal")){
                        z = Zorluk.NORMAL;
                        break;
                    } else if(zorluk.equalsIgnoreCase("zor")){
                        z = Zorluk.ZOR;
                        break;
                    } else {
                        System.out.println("Gecersiz giris. Lutfen yeniden deneyin.");
                    }
                }
                filtreleyerekListele(ListelemeTipi.ZORLUK, z);
            } else if (secim == 6) {
                listele();
            } else if (secim == 7) {
                break;
            } else {
                System.out.println("Gecersiz giris. lutfen yeniden deneyin.");
                System.out.print("Yapmak Istediginiz Islemin Numarasini Giriniz : ");
            }

            if(secim > 0 && secim < 7)
                soruListeleMenu();
        }
    }

    private void soruEkleSecim(){
        while(true){
            byte secim = Main.scanner.nextByte();

            if (secim == 1){
                klasikSoruEkle();
            } else if (secim == 2){
                dogruYanlisSoruEkle();
            } else if (secim == 3){
                coktanSecmeliSoruEkle();
            } else if (secim == 4){
                boslukDoldurmaliSoruEkle();
            } else if (secim == 5){
                break;
            } else {
                System.out.println("Gecersiz giris. lutfen yeniden deneyin.");
                System.out.print("Yapmak Istediginiz Islemin Numarasini Giriniz : ");
            }

            if (secim > 0 && secim < 5)
                soruEkleMenu();
        }
    }

    private void klasikSoruEkle(){
        System.out.print("Soru metni giriniz: ");
        String soruMetni = sc.nextLine();

        System.out.print("Puan giriniz: ");
        double puan = Main.scanner.nextDouble();

        Zorluk z;
        while(true){
            System.out.print("Zorluk giriniz (KOLAY-NORMAL-ZOR): ");
            String zorluk = Main.scanner.next();

            if (zorluk.equalsIgnoreCase("kolay")){
                z = Zorluk.KOLAY;
                break;
            } else if(zorluk.equalsIgnoreCase("normal")){
                z = Zorluk.NORMAL;
                break;
            } else if(zorluk.equalsIgnoreCase("zor")){
                z = Zorluk.ZOR;
                break;
            } else {
                System.out.println("Gecersiz giris. Lutfen yeniden deneyin.");
            }
        }

        Soru soru = new KlasikSoru(soruMetni, puan, z);

        soruEkle(soru);
    }

    private void dogruYanlisSoruEkle(){
        System.out.print("Soru metni giriniz: ");
        String soruMetni = sc.nextLine();

        System.out.print("Puan giriniz: ");
        double puan = Main.scanner.nextDouble();

        Zorluk z;
        while(true){
            System.out.print("Zorluk giriniz (KOLAY-NORMAL-ZOR): ");
            String zorluk = Main.scanner.next();

            if (zorluk.equalsIgnoreCase("kolay")){
                z = Zorluk.KOLAY;
                break;
            } else if(zorluk.equalsIgnoreCase("normal")){
                z = Zorluk.NORMAL;
                break;
            } else if(zorluk.equalsIgnoreCase("zor")){
                z = Zorluk.ZOR;
                break;
            } else {
                System.out.println("Gecersiz giris. Lutfen yeniden deneyin.");
            }
        }

        String dogruCevap;
        while(true){
            try{
                Scanner sc = new Scanner(System.in);
                System.out.print("Dogru cevap giriniz: ");
                Pattern pattern = Pattern.compile("[DY]", Pattern.CASE_INSENSITIVE);
                dogruCevap = sc.next(pattern);
                break;
            } catch(InputMismatchException e) {
                System.out.println("Sadece D ve Y harflerini girebilirsiniz.");
            }
        }

        Soru soru = new DogruYanlisSoru(soruMetni, puan, z, dogruCevap);

        soruEkle(soru);
    }

    private void coktanSecmeliSoruEkle(){
        System.out.print("Soru metni giriniz: ");
        String soruMetni = sc.nextLine();

        System.out.print("Puan giriniz: ");
        double puan = Main.scanner.nextDouble();

        Zorluk z;
        while(true){
            System.out.print("Zorluk giriniz (KOLAY-NORMAL-ZOR): ");
            String zorluk = Main.scanner.next();

            if (zorluk.equalsIgnoreCase("kolay")){
                z = Zorluk.KOLAY;
                break;
            } else if(zorluk.equalsIgnoreCase("normal")){
                z = Zorluk.NORMAL;
                break;
            } else if(zorluk.equalsIgnoreCase("zor")){
                z = Zorluk.ZOR;
                break;
            } else {
                System.out.println("Gecersiz giris. Lutfen yeniden deneyin.");
            }
        }


        Hashtable<String, String> dic = new Hashtable<String, String>();

        System.out.print("A sikkini giriniz: ");
        String aSikki = sc.nextLine();
        dic.put("A",aSikki);

        System.out.print("B sikkini giriniz: ");
        String bSikki = sc.nextLine();
        dic.put("B",bSikki);

        System.out.print("C sikkini giriniz: ");
        String cSikki = sc.nextLine();
        dic.put("C",cSikki);

        System.out.print("D sikkini giriniz: ");
        String dSikki = sc.nextLine();
        dic.put("D",dSikki);

        String dogruCevap;
        while(true){
            try{
                Scanner sc = new Scanner(System.in);
                System.out.print("Dogru cevap giriniz: ");
                Pattern pattern = Pattern.compile("[A-D]", Pattern.CASE_INSENSITIVE);
                dogruCevap = sc.next(pattern);
                break;
            } catch(InputMismatchException e) {
                System.out.println("A ile D arasinda harf girebilirsiniz.");
            }
        }

        Soru soru = new CoktanSecmeliSoru(soruMetni, puan, z, dogruCevap, dic);

        soruEkle(soru);
    }

    private void boslukDoldurmaliSoruEkle(){
        System.out.print("Soru metni giriniz: ");
        String soruMetni = sc.nextLine();

        System.out.print("Puan giriniz: ");
        double puan = Main.scanner.nextDouble();

        Zorluk z;
        while(true){
            System.out.print("Zorluk giriniz (KOLAY-NORMAL-ZOR): ");
            String zorluk = Main.scanner.next();

            if (zorluk.equalsIgnoreCase("kolay")){
                z = Zorluk.KOLAY;
                break;
            } else if(zorluk.equalsIgnoreCase("normal")){
                z = Zorluk.NORMAL;
                break;
            } else if(zorluk.equalsIgnoreCase("zor")){
                z = Zorluk.ZOR;
                break;
            } else {
                System.out.println("Gecersiz giris. Lutfen yeniden deneyin.");
            }
        }

        System.out.print("Dogru cevap giriniz: ");
        String dogruCevap = sc.nextLine();

        Soru soru = new BoslukDoldurmaliSoru(soruMetni, puan, z, dogruCevap);

        soruEkle(soru);
    }

    private void soruCikarSecim(){
        String secim = sc.nextLine();

        if (secim.equalsIgnoreCase("e")){
            anaMenu();
            return;
        }
        List<Soru> arr = silmeListesi(secim);
        System.out.print("Silmek istediginiz sorunun numarasini giriniz: ");

        int soruNo = Main.scanner.nextInt();
        int hashCode = arr.get(soruNo-1).hashCode();
        soruSil(hashCode);

        anaMenu();
    }

    public void soruEkle(Soru soru){
        arr.add(soru);
    }

    public boolean soruSil(Soru soru) {
        return arr.remove(soru);
    }

    public boolean soruSil(int hashCode) {
        boolean temp = false;
        List<Soru> tempArr = new ArrayList<Soru>();

        for(Soru e: arr)
            if(hashCode == e.hashCode())
                tempArr.add(e);

        arr.removeAll(tempArr);

        return temp;
    }

    public static boolean soruSil(List<Soru> arr, Soru soru) {
        return arr.remove(soru);
    }

    public <T> List<Soru> filtrele(ListelemeTipi tip, T deger){
        List<Soru> temp = new ArrayList<Soru>();

        for(Soru e: arr)
            if (e.kontrolEt(tip,deger))
                temp.add(e);

        return temp;
    }

    public List<Soru> filtrele(SinavTipi tip){
        List<Soru> temp = new ArrayList<Soru>();

        for(Soru e: arr)
            switch (tip){
                case TEST -> {
                    if (e.getClass() == CoktanSecmeliSoru.class)
                        temp.add(e);
                }
                case KLASIK -> {
                    if (e.getClass() == KlasikSoru.class)
                        temp.add(e);
                }
                case KARISIK -> {
                    temp = arr;
                }
            }

        return temp;
    }

    public List<Soru> sirala(){
        Collections.sort(arr);
        return arr;
    }

    public static List<Soru> sirala(List<Soru> arr){
        Collections.sort(arr);
        return arr;
    }

    public <T> void filtreleyerekListele(ListelemeTipi tip, T deger){
        List<Soru> filteredList = filtrele(tip, deger);
        List<Soru> sortedList = sirala(filteredList);

        for(Soru s: sortedList)
            System.out.println(s.toString(false, false));
    }

    public <T> List<Soru> silmeListesi(String deger){
        List<Soru> filteredList = filtrele(ListelemeTipi.SORU_METNI, deger);
        List<Soru> sortedList = sirala(filteredList);

        int no = 1;
        for(Soru s: sortedList)
            System.out.println("SORU NO: "
                                +(no++)
                                +"\n"
                                +s.toString(false, false));
        return sortedList;
    }

    public static <T> void listele(List<Soru> arr){
        for(Soru s: arr)
            System.out.println(s.toString(false, false));
    }

    public void listele(){
        for(Soru s: arr)
            System.out.println(s.toString(false, false));
    }

    public int esitMi(Soru soru){
        int hashCode = 0;

        for(Soru e: arr)
            if(e.equals(soru))
                hashCode = e.hashCode();

        return hashCode;
    }

    public static double toplamPuan(List<Soru> arr){
        double toplamPuan = 0;

        for(Soru e: arr)
            toplamPuan += e.getPuan();

        return toplamPuan;
    }
}
