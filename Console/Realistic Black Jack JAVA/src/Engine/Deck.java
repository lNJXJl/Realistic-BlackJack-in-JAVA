package Engine;
import java.util.ArrayList;
import java.util.Random;



public class Deck {


    public ArrayList<String> ranks = new ArrayList<>();
    public ArrayList<String> suits = new ArrayList<>();

    //Lista dla tworzenia kart
    public ArrayList<Cards> cards = new ArrayList<>();

    //Dostepne karty dodawane dla istniejacych arrayow "ranks" oraz "suits"
    public Deck() {
        //ranks
        ranks.add("A");
        ranks.add("2");
        ranks.add("3");
        ranks.add("4");
        ranks.add("5");
        ranks.add("6");
        ranks.add("7");
        ranks.add("8");
        ranks.add("9");
        ranks.add("10");
        ranks.add("J");
        ranks.add("Q");
        ranks.add("K");

        //suits
        suits.add("(Black) Spades (♠)");
        suits.add("(Red) Hearts (♥)");
        suits.add("(Red) Diamonds (♦)");
        suits.add("(Black) Clubs (♣)");

        int i;
        int j;

        //tworzy kazda mozliwa kombinacje dla dostepnych kart wynikiem jest pełen deck 52 kart
        for (i = 0; i < ranks.size(); i++) {
            for (j = 0; j < suits.size(); j++) {
                Cards c = new Cards(ranks.get(i), suits.get(j));
                cards.add(c);
            }
        }

    }

    //pobiera karte
    public static Cards drawCard(ArrayList<Cards> cards) {
        if (cards.isEmpty()) {
            System.out.println("Talia jest pusta nie można dobrać karty");
            return null;
        }else{
            Random rand = new Random();
            int i = rand.nextInt(cards.size());
            Cards c = cards.get(i);
            cards.remove(i);
            return c;
        }
    }


    //reset decku
    public void resetDeck() {
        cards.clear();

        int i;
        int j;
        for (i = 0; i < ranks.size(); i++) {
            for (j = 0; j < suits.size(); j++) {
                Cards c = new Cards(ranks.get(i), suits.get(j));
                cards.add(c);
            }
        }
        System.out.println("Talia została potasowana");
    }
}