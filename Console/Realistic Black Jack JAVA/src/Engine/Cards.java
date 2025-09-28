package Engine;
public class Cards {
    private String rank;
    private String suit;


    //Konstrukcja Karty
    public Cards(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    //zwraca wylosowana karte
    public String getCard() {
        return rank + " " + suit;
    }

//    public String getRank() {
//        return rank;
//    }
//
//    public String getSuit() {
//        return suit;
//    }


    //funkcja do zwracania wartości karty
    public int  getBackJackValue() {
        switch (rank) {
            case "A":
                return 11;

            case "K":
            case "Q":
            case "J":
                return 10;
            default:
                return Integer.parseInt(rank);
        }
    }
    @Override
    public String toString() {
        return getCard();
    }

}
