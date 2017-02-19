/**
 * @Author: Aditya Kotak
 * Object to represent a Set.
 */
public class Set {
    GameCard one;
    GameCard two;
    GameCard three;

    /**
     * Constructor for a SET.
     * @param i first card in the SET
     * @param j second card in the SET
     * @param k third card in the SET
     */
    public Set (GameCard i, GameCard j, GameCard k) {
        one = i;
        two = j;
        three = k;
    }
}
