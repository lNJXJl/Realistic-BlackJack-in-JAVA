package Engine;

public class Money {
    private int money;

    public Money() {
        this.money = 100;

    }


    public void MoneyWin(int bet){
        money += bet*2;
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
            return true;
        }
    }
    public void remis(int bet) {
        System.out.println("Remis - zwrot stawki: " + bet);
        money += bet;
    }
}
