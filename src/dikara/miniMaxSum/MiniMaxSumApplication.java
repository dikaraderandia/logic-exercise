package dikara.miniMaxSum;

import java.io.*;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class MiniMaxSumApplication {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result.miniMaxSum(arr);

        bufferedReader.close();
    }
}

class Result {

    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void miniMaxSum(List<Integer> arr) {
        // Write your code here

        List<Long> sums = new java.util.ArrayList<>(List.of());
        long sum = 0;

        for (int i = 0; i< arr.size(); i++){
            sum = 0;
            for (int j=0; j< arr.size(); j++){
                int val = arr.get(j);
                if (i != j){
                    sum = sum + val;
                }

            }
            sums.add(sum);
        }

        long minValue = sums.get(0);
        long maxValue = sums.get(0);

        for (int k = 0; k< sums.size(); k++){
            if (sums.get(k)< minValue){
                minValue = sums.get(k);
            }

            if (sums.get(k)> maxValue){
                maxValue = sums.get(k);
            }
        }

        System.out.println(minValue+" "+maxValue);


    }

}


