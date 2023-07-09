package HackerRank;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem:
 * Given string str of lower case English alphabets. One can choose any two characters in the string and replace all the occurrences of the first character with the second character and replace all the occurrences of the second character with the first character. Find the lexicographically smallest string that can be obtained by doing this operation at most once. Examples:
 * <p>
 * Input: str = “ccad”
 * Output: aacd
 * Swap all the occurrences of ‘c’ with ‘a’ and all the occurrences of ‘a’ with ‘c’ to get “aacd” which is the lexicographically smallest string that we can get.
 * <p>
 * Input: str = “abba”
 * Output: abba
 *
 * */

public class LexicographicallySmallestString {

    public static void main(String[] args) {
        LexicographicallySmallestString lexSmallestString = new LexicographicallySmallestString();
        String s = "bbcacad";

        String output = lexSmallestString.findLexSmallestString(s);
        System.out.println("Lexicographically Smallest String is: " + output);
    }

    private String findLexSmallestString(String str) {

        List<Character> lst = new ArrayList<>();

        char smallestChar;
        char prvSmallestChar = 0;

        for (int i = 0; i < str.length(); i++) {
            smallestChar = getSmallestChar(str, lst);
            if (smallestChar == prvSmallestChar)
                break;
            else
                prvSmallestChar = smallestChar;
            str = swapWithLargerCharacter(str, smallestChar);
        }
        return str;
    }

    private String swapWithLargerCharacter(String str, Character smallestChar) {
        char replacementChar;

        for (int i = 0; i < str.length(); i++) {
            char currChr = str.charAt(i);

            //check where a bigger character comes, select it as replacement character
            if (currChr > smallestChar) {
                //select current as replacementChar
                replacementChar = currChr;
            } else continue;

            //if smallest character comes first, skip this replacement
            if (str.indexOf(smallestChar) < str.indexOf(replacementChar))
                return str;

            //if larger of the two selected character comes first, replace with smaller character to make replacement
            str = str.replace(smallestChar, '*');
            str = str.replace(replacementChar, smallestChar);
            str = str.replace('*', replacementChar);
            return str;
        }
        return str;
    }

    private char getSmallestChar(String str, List<Character> prvslyProcessedChars) {

        char smallestChar = 0;

        for (char currChr : str.toCharArray()) {
            if (!prvslyProcessedChars.contains(currChr) && smallestChar == 0 || !prvslyProcessedChars.contains(currChr) && currChr < smallestChar)
                smallestChar = currChr;
        }

        prvslyProcessedChars.add(smallestChar);
        return smallestChar;
    }
}
