package dikara.breakingTheRecords;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class BreakingTheRecords {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> scores = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.breakingRecords(scores);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}

class Result {

    /*
     * Complete the 'breakingRecords' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY scores as parameter.
     */

    public static List<Integer> breakingRecords(List<Integer> scores) {
        // Write your code here
        Integer countHighestScore =0 ;
        Integer countLowestScore = 0;

        int maxScore = scores.get(0);
        int minScore =scores.get(0);
        for (int i = 0; i < scores.size(); i++) {
            if (i+1 == scores.size()){
                break;
            }

            if (scores.get(i+1) > maxScore){
                countHighestScore++;
                maxScore =scores.get(i+1);

            }
            if(scores.get(i+1) < minScore){
                countLowestScore++;
                minScore = scores.get(i+1);

            }
        }
        List<Integer> result = new ArrayList<>();
        result.add(countHighestScore);
        result.add(countLowestScore);

        return result;

    }

}
