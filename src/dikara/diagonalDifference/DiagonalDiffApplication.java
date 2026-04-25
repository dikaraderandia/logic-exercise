package dikara.diagonalDifference;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DiagonalDiffApplication {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] arrRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> arrRowItems = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                int arrItem = Integer.parseInt(arrRowTempItems[j]);
                arrRowItems.add(arrItem);
            }

            arr.add(arrRowItems);
        }

        int result = Result.diagonalDifference(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

class Result {

    /*
     * Complete the 'diagonalDifference' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static int diagonalDifference(List<List<Integer>> arr) {
        // Write your code here
        int sumOne = 0;
        int diff ;
        for (int i = 0; i < arr.size(); i++) {
            sumOne += arr.get(i).get(i);

        }
        int i = 0;
        int sumTwo = 0;
        for (int j = arr.size()-1; j >= 0; j--) {
            sumTwo += arr.get(i).get(j);
            i++;
        }

         diff = sumOne - sumTwo;
        diff = Math.abs(diff);


        return diff;

    }

}
