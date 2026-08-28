import java.util.*;

public class NumbersArray {
    public static void main(String[] args) {
        Integer[] input = {1,2,3,4,1,5};

        System.out.println("Input : " + Arrays.toString(input));
        System.out.println("Max number : " + findMax(input));
        System.out.println("Duplicate numbers : " + Arrays.toString(findDuplicates(input)));
        System.out.println("Unique numbers : " + Arrays.toString(findUnique(input)));       
        
        System.out.println();

        input = new Integer[] {1,2,3,4,1,2,5,3};

        System.out.println("Input : " + Arrays.toString(input));
        System.out.println("Max number : " + findMax(input));
        System.out.println("Duplicate numbers : " + Arrays.toString(findDuplicates(input)));
        System.out.println("Unique numbers : " + Arrays.toString(findUnique(input))); 
    }

    // Write your methods here
    public static int findMax(Integer[] input) {
        int[] arr = Arrays.stream(input)
                          .mapToInt(Integer::intValue)
                          .toArray();
    
        if (arr.length == 0) return -1;

        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            max = Math.max(current, max);
        }
        return max;
    }

    public static int[] findDuplicates(Integer[] input) {
        int[] arr = Arrays.stream(input)
                          .mapToInt(Integer::intValue)
                          .toArray();

        if (arr.length <= 1) return new int[0];

        // List<Integer> numList = Arrays.asList(input);
        List<Integer> answer = new ArrayList<>();
        List<Integer> repeats = new ArrayList<>();
        for (int num : arr) {
            if (!repeats.contains(num)) {
                repeats.add(num);
            } else {
                if (!answer.contains(num)) {
                    answer.add(num);
                }
            }
        }

        return answer.stream()
                     .mapToInt(Integer::intValue)
                     .toArray();
    }

    public static int[] findUnique(Integer[] input) {
        int[] arr = Arrays.stream(input)
                          .mapToInt(Integer::intValue)
                          .toArray();

        if (arr.length == 0) return new int[0];

        Map<Integer, Integer> mappings = new HashMap<>();
        for (int num : arr) {
            mappings.put(num, mappings.getOrDefault(num, 0) + 1);
        }

        List<Integer> answer = new ArrayList<>();
        for (int key : mappings.keySet()) {
            if (mappings.get(key) == 1) {
                answer.add(key);
            }
        }
        return answer.stream()
                     .mapToInt(Integer::intValue)
                     .toArray();
    }
}

