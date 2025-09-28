package Engine;
import java.util.ArrayList;

public class Dealer {
    Deck myDeck;
    private String dealerhand;

    public ArrayList<Cards> dealerHand = new ArrayList<>();

    public Dealer(String dealer, Deck deck) {
        this.dealerhand = dealer;
        this.myDeck = deck;
    }

    public void dealerFirstCard(){
        for (int i = 0; i < 2; i++) {
            Cards myCard = Deck.drawCard(myDeck.cards);
            if (myCard == null) {
                myDeck.resetDeck();
                myCard = Deck.drawCard(myDeck.cards);
            }
            dealerHand.add(myCard);
        }
    }
    public void dealerLogic() {
    System.out.println("Dealer Rozpoczyna Gre");
        System.out.println("Dealer odsłania zakrytą kartę: " + dealerHand.get(1).getCard());

        while (getHandvalue() < 17) {
            Cards myCard = Deck.drawCard(myDeck.cards);
            if (myCard == null) {
                myDeck.resetDeck();
                myCard = Deck.drawCard(myDeck.cards);
            }
            if (myCard != null) {
                dealerHand.add(myCard);
                System.out.println("Dealer dobiera kartę: " + myCard.getCard());
                System.out.println("Wartość ręki dealera: " + getHandvalue());
            }
        }

        if (getHandvalue() > 21) {
            System.out.println("Dealer Busted!");
            System.out.println("Karty Dealera: ");
            for (int i = 0; i < dealerHand.size(); i++) {
                System.out.println((i + 1) + ". " + dealerHand.get(i).getCard());
            }
        } else {
            System.out.println("Dealer stoi z wartością: " + getHandvalue());
        }
    }


    public int getHandvalue() {
        int value = 0;
        int aces = 0;

        for (Cards card : dealerHand) {
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
}
