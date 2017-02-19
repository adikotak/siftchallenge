import java.lang.reflect.Array;
import java.util.*;

/**
 * @Author: Aditya Kotak
 * Launches a game of SET.
 */
public class SetLauncher {
    public static GameCard[] cards;
    public static Scanner in = new Scanner(System.in);
    public static ArrayList<Set>  sets = new ArrayList<Set>();
    public static ArrayList<Set> disjoints = new ArrayList<Set>();

    /**
     * Takes in the input for the SET game.
     */
    public static void getInput() {
        int numCards = in.nextInt();
        in.nextLine();
        cards = new GameCard[numCards];
        for (int i = 0; i < numCards; i++) {
            String input = in.nextLine();
            String[] word = input.split(" ");
            String color = word[0];
            Character sym = getSymbol(word[1].charAt(0));
            String shading = checkShading(word[1].charAt(0));
            int number = word[1].length();
            cards[i] = new GameCard(color, sym, shading, number, input);
        }
    }

    /**
     * Finds all the sets present through use of a brute force algorithm.
     */
    public static void findSets() {
        int ans = 0;
        for (int i = 0; i < cards.length; i++) {
            for (int j = i+1; j < cards.length; j++) {
                for (int k = j+1; k < cards.length; k++) {
                    if (cards[i].isSet(cards[j], cards[k])) {
                        sets.add(new Set(cards[i], cards[j], cards[k]));
                        ans++;
                    }
                }
            }
        }
        System.out.println(ans);
    }

    /**
     * Finds all the disjoints sets in the current set based on a different first entry.
     * @param test The first entry to the disjoint list.
     * @return an ArrayList for the disjoint set.
     */
    public static ArrayList<Set> findDisjointSets(Set test) {
        boolean flag;
        ArrayList<Set> disjointsCheck = new ArrayList<Set>();
        disjointsCheck.add(test);
        for (int i = 0; i < sets.size(); i++) {
            flag = true;
            for (int j = 0; j < disjointsCheck.size(); j++) {
                if (sets.get(i).one.cardsMatch(disjointsCheck.get(j).one)) { flag = false; break; }
                if (sets.get(i).one.cardsMatch(disjointsCheck.get(j).two)) { flag = false; break; }
                if (sets.get(i).one.cardsMatch(disjointsCheck.get(j).three)) { flag = false; break; }
                if (sets.get(i).two.cardsMatch(disjointsCheck.get(j).one)) { flag = false; break; }
                if (sets.get(i).two.cardsMatch(disjointsCheck.get(j).two)) { flag = false; break; }
                if (sets.get(i).two.cardsMatch(disjointsCheck.get(j).three)) { flag = false; break; }
                if (sets.get(i).three.cardsMatch(disjointsCheck.get(j).one)) { flag = false; break; }
                if (sets.get(i).three.cardsMatch(disjointsCheck.get(j).two)) { flag = false; break; }
                if (sets.get(i).three.cardsMatch(disjointsCheck.get(j).three)) { flag = false; break; }
            }
            if (flag) {
                disjointsCheck.add(sets.get(i));
            }
        }
        return disjointsCheck;
    }

    /**
     * Finds the max disjoint ArrayList set by checking multiple first entry points.
     */
    public static void findMaxDisjoint() {
       int max = -1;
       for (int i = 0; i < sets.size(); i++){
           if (findDisjointSets(sets.get(i)).size() > max) {
               disjoints = findDisjointSets(sets.get(i));
               max = disjoints.size();
           }
       }
        System.out.println(max);
    }

    /**
     * Prints the sets.
     */
    public static void printDisjointSets() {
        for (int i = 0; i < disjoints.size(); i++) {
            System.out.println(disjoints.get(i).one.fullName);
            System.out.println(disjoints.get(i).two.fullName);
            System.out.println(disjoints.get(i).three.fullName);
            System.out.println();
        }
    }

    /**
     * Main
     * @param args
     */
    public static void main (String[] args) {
        getInput();
        findSets();
        findMaxDisjoint();
        System.out.println();
        printDisjointSets();
    }

    /**
     * Simplifies how Symbols are represented in the card.
     * @param i Character for symbol of the card
     * @return simplified character of the card's symbol.
     */
    private static Character getSymbol(Character i) {
        if (i == 'A' || i == 'a' || i == '@') {
            return 'a';
        } else if (i == 'S' || i == 's' || i == '$') {
            return 's';
        } else {
            return 'h';
        }
    }

    /**
     * Simplifies how Shading is represented in the card.
     * @param i Character for shading of the card
     * @return simplified character of the card's shading.
     */
    private static String checkShading (Character i) {
        if (i == 'A' || i == 'S' || i == 'H') {
            return "upper";
        } else if (i == 'a' || i == 's' || i == 'h') {
            return "lower";
        } else {
            return "symbol";
        }
    }
}
