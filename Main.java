package oop.homework;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static SoruBankasi sb = new SoruBankasi();

    public static void main(String[] args) {
        while(true){
            menu();
            byte secim = scanner.nextByte();

            if(secim == 1){
                sb.anaMenu();
                sb.anaSecim();
            } else if (secim == 2) {
                sinavMenu();
            } else if (secim == 3) {
                break;
            } else {
                System.out.println("Gecersiz bir islem sectiniz. Lutfen tekrar deneyiniz.");
            }
        }
    }

    private static void menu(){
        StringBuilder menu = new StringBuilder();
        menu.append("------------- MENU -------------\n");
        menu.append("\n1- Soru Bankasina Git\n");
        menu.append("2- Sinav Yap\n");
        menu.append("3- Cikis Yap\n");
        menu.append("\nYapmak Istediginiz Islemin Numarasini Giriniz : ");
        System.out.print(menu.toString());
    }

    private static void sinavMenu(){
        StringBuilder menu = new StringBuilder();
        menu.append("------------- SINAV -------------\n");
        menu.append("\n1- Test Sinavi Yap\n");
        menu.append("2- Karisik Sinav Yap\n");
        menu.append("3- Klasik Sinav Yap\n");
        menu.append("4- Bir Onceki Menuye Don\n");
        menu.append("\nYapmak Istediginiz Islemin Numarasini Giriniz : ");
        System.out.print(menu.toString());

        sinavSecim();
    }

    private static void sinavSecim(){
        while(true){
            byte secim = scanner.nextByte();

            if (secim == 1){
               new TestSinav(sb);
            } else if (secim == 2){
                new KarisikSinav(sb);
            } else if (secim == 3){
                new KlasikSinav(sb);
            } else if(secim == 4) {
                break;
            } else {
                System.out.println("Gecersiz giris. lutfen yeniden deneyin.");
            }

            if(secim > 0 && secim < 4)
                break;
        }
    }
}
