package HackerRank;

import java.util.ArrayList;
import java.util.List;

/**
 * The method will receive a 2d array of products with three properties [name,price,year] and
 * query [TYPE, condition].
 * The type has three values
 * TYPE1 : match condition with year of product
 * TYPE2:  price of product should be less than condition
 * TYPE3:  price of product should be greater than condition
 *
 * Return a 2D array.
 *asxas
 */

public class ProductAndQuery {


    public static void main(String[] args) {
        ProductAndQuery pnq = new ProductAndQuery();

        String[][] prods = new String[4][3];

        prods[0][0] = "P1";
        prods[0][1] = "50";
        prods[0][2] = "2013";

        prods[1][0] = "P2";
        prods[1][1] = "100";
        prods[1][2] = "1980";

        prods[2][0] = "P3";
        prods[2][1] = "1000";
        prods[2][2] = "1990";

        prods[3][0] = "P4";
        prods[3][1] = "50";
        prods[3][2] = "1980";


        String[][] queries = new String[3][2];


        queries[0][0] = "TYPE1";
        queries[0][1] = "1980";

        queries[1][0] = "TYPE2";
        queries[1][1] = "100";

        queries[2][0] = "TYPE3";
        queries[2][1] = "100";

        pnq.discover(prods, queries);
    }

    private String[][] discover(String[][] prods, String[][] queries) {

        List<String[]> queryResultsList = new ArrayList<String[]>();

        for (int queryIndex = 0; queryIndex < queries.length; queryIndex++) {
            String queryType = queries[queryIndex][0];
            String queryCriteria = queries[queryIndex][1];

            switch (queryType) {
                case "TYPE1": {
                    List<String> matchingYearProdNames = new ArrayList<>();
                    //check for matching year

                    for (int prodIndex = 0; prodIndex < prods.length; prodIndex++) {
                        String prodYear = prods[prodIndex][2];
                        if (prodYear.equals(queryCriteria)) {
                            matchingYearProdNames.add(prods[prodIndex][0]);
                        }
                    }

                    //all products iterated.

                    String[] result = new String[matchingYearProdNames.size()];
                    result = matchingYearProdNames.toArray(result);
                    queryResultsList.add(result);
                    break;
                }

                case "TYPE2": {
                    List<String> matchingYearProdNames = new ArrayList<>();
                    //check for matching year

                    for (int prodIndex = 0; prodIndex < prods.length; prodIndex++) {
                        int price = Integer.parseInt(prods[prodIndex][1]);

                        if (price < (Integer.parseInt(queryCriteria))) {
                            matchingYearProdNames.add(prods[prodIndex][0]);
                        }
                    }

                    //all products iterated.

                    String[] result = new String[matchingYearProdNames.size()];
                    result = matchingYearProdNames.toArray(result);
                    queryResultsList.add(result);
                    break;

                }

                case "TYPE3": {
                    List<String> matchingYearProdNames = new ArrayList<>();
                    //check for matching year

                    for (int prodIndex = 0; prodIndex < prods.length; prodIndex++) {
                        int prodPrice = Integer.parseInt(prods[prodIndex][1]);

                        if (prodPrice > (Integer.parseInt(queryCriteria))) {
                            matchingYearProdNames.add(prods[prodIndex][0]);
                        }
                    }

                    //all products iterated.

                    String[] result = new String[matchingYearProdNames.size()];
                    result = matchingYearProdNames.toArray(result);
                    queryResultsList.add(result);
                    break;

                }

            }

        }

        String[][] queryResultsArray = new String[queryResultsList.size()][];
        queryResultsArray = queryResultsList.toArray(queryResultsArray);

        //print results
        for (int i = 0; i < queryResultsArray.length; i++) {
            for (int j = 0; j < queryResultsArray[i].length; j++) {
                System.out.print(queryResultsArray[i][j] + " ");
            }
            System.out.println("");
        }

        return queryResultsArray;
    }

}
