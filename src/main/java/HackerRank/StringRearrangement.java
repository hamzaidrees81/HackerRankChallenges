package HackerRank;

/**
 * Given a string input, receive an array which tells an order in which characters of the input string are to be rearranged
 * to form an output
 * input: talentcloudturing
 * array: {6,7,8,9,10,11,12,13,14,15,16,0,1,2,3,4,5};
 * output: turingcloudtalent
 */

public class StringRearrangement {
    public static void main(String[] args) {
        StringRearrangement s = new StringRearrangement();
        String inputString = "talentcloudturing";
        int[] arrangementArray = {6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 0, 1, 2, 3, 4, 5};

        String output = s.solution(inputString, arrangementArray);
        System.out.println("Rearranged String is : " + output);

    }

    private String solution(String input, int[] k) {

        char[] myIntArray = new char[input.length()];

        for (int index : k) {
            myIntArray[k[index]] = input.charAt(index);
        }

        return new String(myIntArray);

    }


}
