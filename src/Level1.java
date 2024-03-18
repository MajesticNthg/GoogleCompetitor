import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Level1 {
    public static int StringCount (int len, String s) {
        int flag = 0;
        int string_count = 0;
        int word_start = 0;

        for (int x = 0; x < s.length(); x++, flag++) {
            if (x == 0 && s.length() > 0 && s.charAt(x) != ' ') {
                word_start = x;
            }
            if (x != 0 && s.charAt(x - 1) == ' ' && s.charAt(x) != ' ') {
                word_start = x;
            }
            if (x != 0 && s.charAt(x - 1) != ' ' && s.charAt(x) != ' ' && (x - word_start >= (len - 1)))
                word_start = x - 1;
            if (flag > len) {
                string_count++;
                flag = 0;
                if (x - word_start >= (len - 1) && s.charAt(x + 1) != ' ') {
                    word_start = x;
                } else
                    x = word_start;
            } else if (flag < len && x == s.length() - 1)
                string_count++;
        }
        return string_count;
    }

    public static String[] stringOfWords (int len, String s) {

        String[] words = s.split(" ");
        String[] more_words = new String[StringCount(len, s)];

        int sum = 0;
        int y = 0;


        for (int x = 0; x < words.length; x++) {
            if (sum == 0 && words[x].length() > len) {
                more_words[y] = words[x].substring(0, len);
                more_words[y+1] = words[x].substring(len, words[x].length());
                sum += words[x].length();
                x++;
            }
            if (sum == 0 && words[x].length() <= len) {
                if (more_words[y] != null) {
                    more_words[y] += " " + words[x];
                    sum += words[x].length();
                }
                else {
                    sum += words[x].length();
                    more_words[y] = words[x];
                }
            }
            else if (sum != 0 && (sum + words[x].length() + 1 <= len)) {
                more_words[y] += " " + words[x];
                sum += words[x].length();
            }
            else {
                y++;
                sum = 0;
                x--;
            }
        }

        return more_words;
    }

    public static int [] WordSearch(int len, String s, String subs) {
        int[] WordSearch = new int[StringCount(len, s)];

        int value = 0;

        for (int i = 0; i < WordSearch.length; i++) {
            value = stringOfWords(len, s)[i].indexOf(subs);

            if (value == 0 && (value + subs.length() == stringOfWords(len, s)[i].length()))
                WordSearch[i] = 1;
            else if (value == 0 && (stringOfWords(len, s)[i].charAt(subs.length()) == ' '))
                WordSearch[i] = 1;
            else if (value > 0 && (stringOfWords(len, s)[i].charAt(value - 1) == ' ') && ((stringOfWords(len, s)[i].charAt(subs.length() + value) == ' ')))
                WordSearch[i] = 1;
            else if (value > 0 && stringOfWords(len, s)[i].charAt(value - 1) == ' ' && (value + subs.length() == stringOfWords(len, s)[i].length()))
                WordSearch[i] = 1;
            else
                WordSearch[i] = 0;


        }
        return WordSearch;
    }


}



