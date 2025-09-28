package Engine;
import java.util.ArrayList;
import java.util.Scanner;
public class Hand {
    Scanner sc = new Scanner(System.in);
    Deck myDeck;
    Dealer myDealer;
    public int bet;
    public boolean Stand = false;
    private String hand;
    private int numberOfDraw;
    public ArrayList<Cards> drawedCards = new ArrayList<>();
    boolean allinprotection;
    Money myMoney;
    public Hand(String hand, Deck deck,Money money) {
        this.hand = hand;
        this.myDeck = deck;
        this.myDealer = new Dealer(hand, myDeck);
        this.myMoney = money;
    }

    public String getHand() {
        return hand;
    }
    public void setHand(String hand) {
        boolean run = newGame();
        while (run) {
            if(myMoney.getMoney() <= 0 && allinprotection == false) {
                System.out.println("Nie masz pieniędzy. Gra zakończona.");
                run = false;
                break;
            }
            System.out.println("--Menu gry--");
            System.out.println("Karta Dealera " + myDealer.dealerHand.get(0));
            System.out.println("--------------");
            for (int i = 0; i < drawedCards.size(); i++) {
                System.out.println((i + 1) + ". " + drawedCards.get(i));
            }
            System.out.println("Wartość Ręki: " + getHandvalue());
            System.out.println("--------------");
            System.out.println("1. HIT");
            System.out.println("2. STAND");
            System.out.println("--------------");
            System.out.println("Dobrano: " + numberOfDraw + " "+ polishwords());
            System.out.println("Balans: "+ myMoney.getMoney());
            System.out.println("Zakład: "+ bet);
            System.out.println("0. Wyjdź");
            System.out.println("--------------");


            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    hit();
                    break;

                case 2:
                    stand();
                    if (myMoney.getMoney() < 0) {
                        System.out.println("Nie masz pieniędzy. Gra zakończona.");
                        run = false;
                    }
                    break;
                    //CHEAT
                case 444:
                    System.out.println("Karty Dealera");
                    for (int i = 0; i < myDealer.dealerHand.size(); i++) {
                        System.out.println((i + 1) + ". " + myDealer.dealerHand.get(i));
                    }
                    //CHEAT
                case 455:
                    System.out.println( "Pozostało: " +myDeck.cards.size() + " kart)");
                    break;
                case 0:
                    if (getHandvalue() == 0) {
                        numberOfDraw = 0;
                        run = false;
                    }else{
                        System.out.println("Nie można zakończyć gry jeśli posiada sie karty");
                    }
                        break;
            }
        }
    }

    //sprawdza czy przekroczono 21
    public void  checkhandvalue(Dealer dealer) {
            if (getHandvalue() > 21) {
            System.out.println("Busted, Posiadano wartość " + getHandvalue());
            clearHand();
            newGame();
        }
        if (dealer.getHandvalue() > 21) {
            System.out.println("Gracz wygrywa - dealer ma bust!");
            System.out.println("Dealer kończy z wartością: " + dealer.getHandvalue());
            myMoney.MoneyWin(bet);
            clearHand();
            newGame();
        }
            else if (dealer.getHandvalue() > getHandvalue() && Stand == true) {
                System.out.println("Dealer Wygrywa");
                clearHand();
                newGame();
            } else if (dealer.getHandvalue() == getHandvalue() && Stand == true) {
                myMoney.remis(bet);
                clearHand();
                newGame();
            }else if(Stand == true){
                System.out.println("Gracz Wygrywa");
                myMoney.MoneyWin(bet);
                clearHand();
                newGame();
            }

    }

    //tworzy karty na poczatku gry
    public boolean newGame(){
        if (myMoney.getMoney() <= 0) {
            System.out.println("Nie masz pieniedzy");
            bet = 0;
            return false;
        }
        while (true) {
            System.out.println("Nowa partia");
            System.out.println("Aktualny balans: " + myMoney.getMoney());
            System.out.println("Podaj zakład: ");
            bet = sc.nextInt();

            if (bet <= 0 || bet > myMoney.getMoney()) {
                System.out.println("Nieprawidłowy zakład!");
                continue;
            }
            if(myMoney.getMoney() == bet) {
                System.out.println("ALL IN!");
                allinprotection = true;
            }
            break;
        }
        myMoney.transaction(bet);

        myDealer.dealerFirstCard();
            for (int i = 0; i < 2 ; i++) {
                Cards myCard = drawsafe();
                drawedCards.add(myCard);
                numberOfDraw ++;
            }
            return true;
    }


    public void clearHand() {
        numberOfDraw = 0;
        drawedCards.clear();
        myDealer.dealerHand.clear();
        allinprotection = false;
    }
    //oblicza wartosc reki
    public int getHandvalue() {
        int value = 0;
        int aces = 0;

        for (Cards card : drawedCards) {
            value += card.getBackJackValue();
            if (card.getCard().startsWith("A")) {
                aces++;
            }
        }

        // redukcja wartosci asa jesli przekroczono 21
        while (value > 21 && aces > 0) {
            value -= 10;
            aces--;
        }
        return value;
    }
    private Cards drawsafe(){
        Cards card = Deck.drawCard(myDeck.cards);
        if (card == null) {
            myDeck.resetDeck();
            card = Deck.drawCard(myDeck.cards);
        }
        return card;
    }
    public void hit(){

        Cards myCard = drawsafe();
        drawedCards.add(myCard);
        numberOfDraw ++;
        System.out.println("Wylosowana karta: " + myCard.getCard());
        System.out.println("Wartość karty: " + myCard.getBackJackValue());
        checkhandvalue(myDealer);
    }

    public void stand(){
        Stand = true;
        System.out.println("Wstrzymano się");
        myDealer.dealerLogic();
        checkhandvalue(myDealer);
        Stand = false;
    }


    //odmiana slowa karta poniewaz zorietowalem sie ze "1 kart" wyglada dziwnie, nie oczekuje sie że ktoś w jednej partii bedzie miec jakimś cudem 22 karty
    //wiec tyle wystarczy
    public String polishwords() {
        if (numberOfDraw == 1) return "kartę";
        if (numberOfDraw >= 2 && numberOfDraw <= 4) return "karty";
        return "kart"; // liczba 0 lub >=5
    }

}


