package HackerRank;

import java.util.Arrays;
import java.util.List;

/**
 * Given an array of integers, calculate the ratios of its elements that are positive, negative, and zero. Print the decimal value of each fraction on a new line with  places after the decimal.
 *
 * Note: This challenge introduces precision problems. The test cases are scaled to six decimal places, though answers with absolute error of up to  are acceptable.
 *
 * Example
 *
 * arr [1,1,0,-1,-1]
 * There are  elements, two positive, two negative and one zero. Their ratios are ,  and . Results are printed as:
 *
 * 0.400000
 * 0.400000
 * 0.200000
 */
public class PlusMinus {

    //problem link: https://www.hackerrank.com/challenges/plus-minus/problem

    public static void main(String [] args)
    {
        Integer [] array = {-4, 3, -9, 0, 4, 1};
        PlusMinus.plusMinus(Arrays.asList(array));
    }

    static void plusMinus(List<Integer> arr) {

        double arrSize = arr.size();

        // Write your code here
        double totalPosVals = 0;
        double totalNegVals = 0;
        double totalZeroVals = 0;

        for(Integer val : arr)
        {
            if(val>0)
                totalPosVals++;
            else if(val<0)
                totalNegVals++;
            else
                totalZeroVals++;
        }

        //divide to decimal places
        System.out.println(String.format( "%.6f", totalPosVals>0 ? totalPosVals/arrSize: 0));
        System.out.println(String.format( "%.6f", totalNegVals>0 ? totalNegVals/arrSize: 0));
        System.out.println(String.format( "%.6f", totalZeroVals>0 ?  totalZeroVals/arrSize: 0));
    }
}