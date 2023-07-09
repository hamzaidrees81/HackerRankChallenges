package HackerRank;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 *
 *  Merging Palindromes
 * Given two strings, find all palindromes that can be formed with the letters of each string.
 * From those palindromes, select one from each set that, when combined and rearranged,
 * produces the longest palindrome possible. If there are multiple palindromes of that length,
 * choose the alphabetically smallest of them.
 *  Example
 *  s1 = 'aabbc'
 *  s2 = 'ddefefq'
 *
 *  All of the letters of the first string can make a palindrome.
 *  The 2 choices using all letters are (abcba, bacab].
 *
 *  All of the letters of the second string can make a palindrome.
 *  The choices using all letters are (defqfed, dfeqefd, edfqfde, efdqdfe, fdeqedf, fedqdea

 *  The two longest results in s1 have a length of 5.
 *  The six longest results in s2 have a length of 6.

 *  From the longest results for s1 and s2, merge the two that form the lowest merged palindrome, alphabetically.

 *  In this case, choose abcba and defqfed.
 *
 *  The two palindromes can be combined to form a single palindrome if either the c or the q is discarded.
 *  The alphabetically smallest combined palindrome is abdefcfedba.
 */
public class PalindromeMerge {

    public static void main(String [] args)
    {
        PalindromeMerge pm = new PalindromeMerge();

        String s1 = "aabb";
        String s2 = "ddefef";

        pm.findLongestMergedPalindrome(s1,s2);
    }

    /**
     * this gives you longest Merged Palindrome
     * @param s1
     * @param s2
     */
    private void findLongestMergedPalindrome(String s1, String s2) {

        //count characters and store
        Map<Character, Integer> map = new HashMap<>();

        countCharacters(s1, map);
        countCharacters(s2, map);

        makePalindrome(map);

    }

    private void makePalindrome(Map<Character, Integer> map) {

        SortedSet<Character> sortedCharacters = new TreeSet<>(map.keySet());

        StringBuilder palindromeFirstPart = new StringBuilder();

        Character middleCharacter = null;

        for(Character c : sortedCharacters)
        {
            int count  = map.get(c);

            while(count>1)
            {
                count = count-2;
                palindromeFirstPart.append(c);
            }

            if(count==0)
            {
                map.remove(c);
            }
            else if (count ==1 && middleCharacter==null)
                    middleCharacter = c;
        }

        System.out.println("Palindrome is : ");
        if(middleCharacter == null)
            System.out.println(palindromeFirstPart.toString() +palindromeFirstPart.reverse().toString());

        if(middleCharacter!=null)
            System.out.println(palindromeFirstPart.toString()+middleCharacter+ palindromeFirstPart.reverse());


    }

    private void countCharacters(String s1, Map<Character, Integer> map) {
        for(Character c: s1.toCharArray())
        {
            map.computeIfPresent(c, (key,val) -> val+1);
            map.putIfAbsent(c, 1);
        }

    }

}
