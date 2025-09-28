import Engine.Cards;
import Engine.Deck;
import Engine.Hand;
import Engine.Money;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Tworzy deck przy kazdym starcie
        Deck myDeck = new Deck();
        Money myMoney =  Money.loadProgress();

        boolean run = true;
        while (run) {
            System.out.println("--Black jack JAVA - Console Edition--");
            System.out.println("1. Graj");
            System.out.println("2. Balans");
            System.out.println("3. Usuń plik zapisu");
            System.out.println("3. Dev Menu");
            System.out.println("0. Wyjdź");
            System.out.println("-------------");


                int choice = checktext();

                switch (choice) {
                    case 1:
                        Hand myHand = new Hand("Gracz", myDeck, myMoney); // Tworzy gracza
                        myHand.setHand("test");
                        break;
                    case 2:
                        System.out.println("Balans: " + Money.loadProgress());
                        break;
                    case 3:
                        myMoney.deleteSave();
                        break;
                    case 4:
                        DEVmenu(myDeck);
                        break;
                    case 0:
                        System.out.println("Wyjście");
                        run = false;
                        break;
                        //CHEAT
                    case 400:
                        myMoney.setMoney(myMoney.getMoney());
                    default:
                        System.out.println("Nieprawidłowa opcja!");
                        break;
                }
            }
        }

        public static void DEVmenu(Deck myDeck) {
            boolean runDEV = true;
            while (runDEV) {
                Scanner sc = new Scanner(System.in);
                System.out.println("--Dev Menu--");
                System.out.println("1. pokaż deck (" + myDeck.cards.size() + " kart)");
                System.out.println("2. wylosuj karte");
                System.out.println("3. resetuj deck");
                System.out.println("4. Utworz testowa reke (hand system)");
                System.out.println("0. Wyjdź");
                if (sc.hasNextInt()){
                int choice = checktext();
                switch (choice) {
                    case 1:
                        pokazdeck(myDeck.cards);
                        break;

                    case 2:
                        Cards myCard = Deck.drawCard(myDeck.cards);
                        if (myCard != null) {
                            System.out.println("Wylosowana karta: " + myCard.getCard());
                            System.out.println("Wartość karty: " + myCard.getBackJackValue());
                        }

                        break;

                    case 3:
                        myDeck.resetDeck();
                        break;

                    case 4:
                        Hand myHand = new Hand("Gracz", myDeck, new Money()); // W dev menu pieniadze są dodawane od nowa
                        myHand.setHand("test");
                        break;
                    case 0:
                        System.out.println("Wyjście");
                        runDEV = false;
                        break;

                    default:
                        System.out.println("Nieprawidłowa opcja!");
                        break;
                }
                }
            }
        }
    //sprawdza czy wpisane do skanera to int czy string(tekst) aby zapobiec wyrzuceniu bledu
        public static int checktext(){
            Scanner sc = new Scanner(System.in);
            int choice;
            while (true) {
            System.out.print("Podaj liczbę: ");
            if (sc.hasNextInt()) {
                choice = sc.nextInt();
                System.out.println("Opcja: " + choice);
                return choice;
            } else {
                System.out.println("To nie jest liczba!");
                sc.next();
            }
            }

        }

public static void pokazdeck (ArrayList<Cards> cards) {

    if (cards.isEmpty()) {
        System.out.println("Lista jest pusta ");
    } else {
        System.out.println("\n=== Karty w talii ===");
        for (int i = 0; i < cards.size(); i++) {
            System.out.println("Karta " + (i + 1) + ": " + cards.get(i).getCard());
        }
        System.out.println("===================");
    }
}
}