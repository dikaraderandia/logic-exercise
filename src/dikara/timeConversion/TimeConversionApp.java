package dikara.timeConversion;

import java.io.*;



public class TimeConversionApp {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = bufferedReader.readLine();

        String result = Result.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

class Result {

    /*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String timeConversion(String s) {
        // Write your code here
        String[] splitS = s.split(":");
        Integer hour = Integer.parseInt(splitS[0]);
        if (splitS[2].contains("PM")){
            if (hour != 12){
                hour = hour +12;
            }
            splitS[0] = String.valueOf(hour);
        }else if (splitS[2].contains("AM")){
            if (hour == 12){
                splitS[0] = "00";
            }
        }
         String typeTime =splitS[2].replaceAll("AM|PM", "");

        splitS[2] = typeTime;

        return  String.join(":", splitS);


    }

}
