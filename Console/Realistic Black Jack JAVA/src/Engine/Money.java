package Engine;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Money {
    private int money;

    public Money() {
        this.money = 100;

    }
    public Money(int money) {
        this.money = money;
    }


    public void MoneyWin(int bet){
        money += bet*2;
        saveProgress();
        System.out.println("Wygrałeś " + bet + ". Posiadasz teraz: " + money);
    }
    public int getMoney() {
        return money;
    }

    public boolean  transaction(int bet) {
        if(bet > money){
            System.out.println("Nie masz tyle pieniędzy! Transakcja anulowana.");
            return false;
        } else {
            money -= bet;
            saveProgress();
            return true;
        }
    }
    public void remis(int bet) {
        System.out.println("Remis - zwrot stawki: " + bet);
        money += bet;
        saveProgress();
    }
    //cheat do dodawania pieniedzy
    public void setMoney(int money) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Podaj ilość pieniedzy: ");
        int cheatmoney = sc.nextInt();
        this.money = cheatmoney;
        saveProgress();
    }


    //obsluga zapisow gry
    public void  saveProgress(){
        try (FileWriter writer = new FileWriter("save.txt")){
            writer.write(String.valueOf(money));
            System.out.println("Zapisano stan gry Balans: "+ money);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void deleteSave(){
        File file = new File("save.txt");
        if(file.exists()){
            if(file.delete()){
                System.out.println("Usunieto plik zapisu");
            }else{
                System.out.println("Nieudało się usunać pliku zapisu");
            }
        }else{
            System.out.println("Plik nie istnieje");
        }

    }
    public static Money loadProgress() {
        try (Scanner sc = new Scanner(new File("save.txt"))) {
            if (sc.hasNextInt()) {
                return new Money(sc.nextInt());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Brak pliku zapisu, ustawiam domyślne 100.");
        }
        return new Money(); // domyślna kasa
    }

    @Override
    public String toString() {
        return money+"";
    }
    //----
}
