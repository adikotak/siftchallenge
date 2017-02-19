/**
 * @Author: Aditya Kotak
 * Creates the GameCard object used in the SET game.
 */
public class GameCard {
    public String color;
    public Character symbol;
    public String shading;
    public int number;
    public String fullName;

    /**
     * Creates a game card.
     * @param c color of the card
     * @param sym symbol of the card
     * @param shade shade of the card
     * @param num number of the card
     * @param name full name of card
     */
    public GameCard(String c, Character sym, String shade, int num, String name) {
        color = c;
        symbol = sym;
        shading = shade;
        number = num;
        fullName = name;
    }

    /**
     * Checks whether this card is a SET with two other cards
     * @param one first card to check with
     * @param two second card to check with
     * @return true if all three form a SET.
     */
    public boolean isSet(GameCard one, GameCard two) {
        return (colorsMatch(one,two) && symbolsMatch(one,two)
                && shadingsMatch(one,two) && numbersMatch(one,two));
    }

    /**
     * Checks whether two cards are the same.
     * @param one card to check with
     * @return true if the cards are the same
     */
    public boolean cardsMatch(GameCard one) {
        return (color.equals(one.color) && symbol == one.symbol && shading.equals(one.shading) && number == one.number);
    }

    /**
     * Checks if the colors of this card and two other cards are the same or all different.
     * @param one first card to check
     * @param two second card to check
     * @return true if colors are all the same or all different
     */
    private boolean colorsMatch(GameCard one, GameCard two) {
        boolean allMatch = color.equals(one.color) && color.equals(two.color);
        boolean noneMatch = !color.equals(one.color) && !color.equals(two.color) && !one.color.equals(two.color);
        return allMatch || noneMatch;
    }

    /**
     * Checks if the symbols of this card and two other cards are the same or all different.
     * @param one first card to check
     * @param two second card to check
     * @return true if symbols are all the same or all different
     */
    private boolean symbolsMatch(GameCard one, GameCard two) {
        boolean allMatch = symbol == one.symbol && symbol == two.symbol;
        boolean noneMatch = symbol != one.symbol && symbol != two.symbol && one.symbol != two.symbol;
        return allMatch || noneMatch;
    }

    /**
     * Checks if the shading of this card and two other cards are the same or all different.
     * @param one first card to check
     * @param two second card to check
     * @return true if shading are all the same or all different
     */
    private boolean shadingsMatch(GameCard one, GameCard two) {
        boolean allMatch = shading.equals(one.shading) && shading.equals(two.shading);
        boolean noneMatch = !(shading.equals(one.shading)) && !(shading.equals(two.shading)) && !(one.shading.equals(two.shading));
        return allMatch || noneMatch;
    }

    /**
     * Checks if the numbers of this card and two other cards are the same or all different.
     * @param one first card to check
     * @param two second card to check
     * @return true if numbers are all the same or all different
     */
    private boolean numbersMatch(GameCard one, GameCard two) {
        boolean allMatch = number == one.number && number == two.number;
        boolean noneMatch = number != one.number && number != two.number && one.number != two.number;
        return allMatch || noneMatch;
    }

}
