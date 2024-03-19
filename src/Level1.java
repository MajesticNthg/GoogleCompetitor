import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Level1 {
    public static int[] WordSearch(int len, String s, String subs) {
        String[] words = s.split(" ");
        ArrayList<String> massive_words = new ArrayList<>();

        StringBuilder string = new StringBuilder();
        StringBuilder empty1 = new StringBuilder();
        StringBuilder empty2 = new StringBuilder();


        for (int x = 0; x < words.length; x++) {
            string = new StringBuilder();
            string.insert(0, words[x]);
            if (string.length() == len && empty2.length() == 0)
                massive_words.add(words[x]);
            else if (string.length() == len && empty2.length() > 0) {
                massive_words.add(empty2.toString());
                empty2 = new StringBuilder();
                x--;
            } else if (string.length() > len && empty2.length() > 0) {
                if (empty2.length() > len) {
                    empty1 = new StringBuilder();
                    empty1.insert(0, empty2.substring(0, len));
                    massive_words.add(empty1.toString());
                    empty2.delete(0, len);
                    x--;
                } else if (empty2.length() <= len) {
                    massive_words.add(empty2.toString());
                    empty2 = new StringBuilder();
                    x--;
                }
            } else if (string.length() > len && empty2.length() == 0) {
                massive_words.add(words[x].substring(0, len));
                empty2.insert(0, words[x].substring(len, words[x].length()));
            } else if (string.length() < len && empty2.length() > 0) {
                if (empty2.length() > len) {
                    empty1 = new StringBuilder();
                    empty1.insert(0, empty2.substring(0, len));
                    massive_words.add(empty1.toString());
                    empty2.delete(0, len);
                    x--;
                } else if (empty2.length() < len && string.length() + empty2.length() + 1 <= len) {
                    empty2.append(" " + string);
                } else if (empty2.length() <= len && string.length() + empty2.length() + 1 > len) {
                    massive_words.add(empty2.toString());
                    empty2 = new StringBuilder();
                    x--;
                }
            } else if (string.length() < len && empty2.length() == 0) {
                empty2.insert(0, string);
            }
            if (x == words.length - 1 && empty2.length() > 0) {
                massive_words.add(empty2.toString());
            }
        }

        int[] WordSearch = new int[massive_words.size()];
        int value = 0;
        StringBuilder test = new StringBuilder();
        String[] result = massive_words.toArray(new String[0]);
        int vvv = subs.length();
        for (int i = 0; i < result.length; i++) {
            test = new StringBuilder();
            test.insert(0, result[i]);
            value = result[i].indexOf(subs);

            if (value == 0 && value + subs.length() == test.length())
                WordSearch[i] = 1;
            else if (value == 0 && test.charAt(value + subs.length()) == ' ')
                WordSearch[i] = 1;
            else if (value > 0 && value + subs.length() < test.length() && test.charAt(value + subs.length()) == ' ')
                WordSearch[i] = 1;
            else if (value > 0 && value + subs.length() >= test.length() && test.charAt(value + subs.length() - 1) == ' ')
                WordSearch[i] = 1;
            else if (value > 0 && value + subs.length() == test.length())
                WordSearch[i] = 1;
            else
                WordSearch[i] = 0;

        }

            return WordSearch;



    }

}









