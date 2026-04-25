package dikara.practiceGpt;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

public class Day2 {
    public static void main(String[] args) {
        //String result = stringProcess("halo");

        //boolean result = palindromeCheck("nababan");

        //int result = 7/2;

        //HashMap<Character, Integer> result = counterCharacter("aabca");

        //boolean result = isAnagram("hello", "world");
        //int[] nums = {2, 11, 8, 15};
        //int[] result = twoSumGPT(nums, 9);

        //int[] nums = {1,1,1,2,2,3};

       // boolean result = hasPair(nums, 9);
        //int result = mostShowedUpNum(nums);
        //System.out.println(Arrays.toString(result) );


        int[] arr = {1,2,3,4,5,1};

        boolean result = duplicateCheckHashSet(arr);

        System.out.println(result );

    }


    private static boolean duplicateCheck (int[] arr){
        HashMap<Integer, Integer> counter = new HashMap<>();

        for (int num : arr){
            counter.put(num, counter.getOrDefault(num,0)+1);
        }

        for (HashMap.Entry<Integer, Integer> entry : counter.entrySet()) {
            if (entry.getValue().equals(2)){
                System.out.println(entry.getKey() + " : " + entry.getValue());
                return true;
            }


        }


        return false;
    }



    private static boolean duplicateCheckHashSet (int[] arr){
        HashSet<Integer> counterSet = new HashSet<>();

        for (int num : arr){
            if (counterSet.contains(num)){
                return true;
            }
            counterSet.add(num);
        }
        return false;
    }

    private static int mostShowedUpNum (int [] arr){
        int result = 0;
        int valueMax = 0;

        int resultKey = 0;

        HashMap<Integer, Integer> counter = new HashMap<>();

        for (int num : arr){
            counter.put(num, counter.getOrDefault(num,0)+1);
        }


        for (Integer key:counter.keySet()){

            valueMax = counter.get(key);

            if (valueMax> result){
                result = valueMax;
                resultKey = key;

            }


        }



        return resultKey;
    }

    private static boolean hasPair(int[] nums, int target){
        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i<nums.length;i++){
            int penambah = target -nums[i];

            if (map.containsKey(penambah)){
                return true;
            }

            map.put(nums[i],i);
        }

        return false;
    }

    private static int[] twoSumCOba(int[] nums, int target) {
        HashMap <Integer,Integer> map = new HashMap<>();

        for (int i = 0; i<nums.length; i++){
            int penambah = target - nums[i];

           if (map.containsKey(penambah)){
               return new int[] {map.get(penambah),i};
           }

           map.put(nums[i],i);
        }

        return new int[]{-7, -1};
    }












    private static int[] twoSumGPT(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i]; // pasangan yang dibutuhkan

            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            map.put(nums[i], i); // simpan angka sekarang
        }

        return new int[]{-1, -1};
    }

    private static int[] twoSum(int[] nums, int target){
        int[] hehe = {2,0};

        HashMap <String, Integer> pejumlah = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length; j++) {
                int count = nums[i] + nums[j];
                if (count == target) {
                    pejumlah.put("1", i);
                    pejumlah.put("2", j);

                }
            }
        }
        int bilangan1 = pejumlah.get("1");
        int bilangan2 = pejumlah.get("2");
        hehe = new int[]{bilangan1, bilangan2};


        return hehe;
    }


    private static String stringProcess(String before){
        char[] arrayChar = before.toCharArray();
        char[] afterChar = new char[arrayChar.length];
        int i = arrayChar.length-1;
        int j = 0;

      while (i>=0){
          afterChar[j] = arrayChar[i];
          j++ ;
          i--;
      }

        return new String(afterChar);
    }

    private static boolean isAnagram (String s1, String s2){
        boolean isAnagram = false;
        if (s1.length() != s2.length()){
            return false;
        }

        HashMap<Character, Integer> resultMapS1 = new HashMap<>();
        char[] string1 = s1.toCharArray();
        resultMapS1.put(string1[0],1);

        for (int i=1; i<string1.length;i++){
            Integer checkMap = resultMapS1.get(string1[i]);
            if (checkMap != null){

                resultMapS1.replace(string1[i], checkMap+1);
            }else {
                resultMapS1.put(string1[i], 1);
            }

        }

        HashMap<Character, Integer> resultMapS2 = new HashMap<>();
        char[] string2 = s2.toCharArray();
        resultMapS2.put(string2[0],1);
        for (int i=1; i<string2.length;i++){
            Integer checkMap = resultMapS2.get(string2[i]);
            if (checkMap != null){

                resultMapS2.replace(string2[i], checkMap+1);
            }else {
                resultMapS2.put(string2[i], 1);
            }

        }

        for (Character key : resultMapS1.keySet()) {
            Integer value2 = resultMapS2.get(key);
            if(value2 == null){
                return false;
            }
            else if (value2 == 0 ){
                return false;
            }else{
               Integer value1 = resultMapS1.get(key);
               if (!Objects.equals(value1, value2)){
                   return false;
               }

            }
        }

        isAnagram = true;


        return isAnagram;
    }

    private static boolean isAnagramGpt (String s1, String s2){
        if (s1.length() != s2.length()) {
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        // hitung string pertama
        for (char c : s1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // kurangi pakai string kedua
        for (char c : s2.toCharArray()) {
            if (!map.containsKey(c)) {
                return false;
            }
            map.put(c, map.get(c) - 1);

            if (map.get(c) < 0) {
                return false;
            }
        }

        return true;



    }



    private static HashMap<Character, Integer> counterCharacter (String count){
        HashMap<Character, Integer> result = new HashMap<>();

        char[] stringChar = count.toCharArray();
        result.put(stringChar[0],1);

        for (int i=1; i<stringChar.length;i++){
            Integer checkMap = result.get(stringChar[i]);
            if (checkMap != null){

                result.replace(stringChar[i], checkMap+1);
            }else {
                result.put(stringChar[i], 1);
            }

        }

        return result;
    }

    private static boolean palindromeCheck (String check){

        //abcd
        char[] stringChar = check.toCharArray();
        int i = 0;
        int j = stringChar.length-1;


        boolean result = true;

        while (i <  j){


          if  (stringChar[i] != stringChar[j]){
              result = false;

          }

           i++;
           j--;
        }
        return result;
    }

    private static void checkGenap(int totalData){


        for (int i = 1; i<=totalData; i++ ){
            if (i%2 == 0){
                System.out.println("genap: "+i);
            }
        }

    }
}
