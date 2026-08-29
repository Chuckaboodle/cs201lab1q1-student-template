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

    public static Integer[] findDuplicates(Integer[] input) {

        if (input.length <= 1) return new Integer[0];

        Set<Integer> present = new HashSet<>();
        Set<Integer> repeats = new HashSet<>();
        for (Integer num : input) {
            if (!present.contains(num)) {
                present.add(num);
            } else {
                repeats.add(num);
            }
        }

        return repeats.toArray(new Integer[0]);
    }

    public static Integer[] findUnique(Integer[] input) {

        if (input.length == 0) return new Integer[0];

        Map<Integer, Integer> mappings = new HashMap<>();
        for (Integer num : input) {
            mappings.put(num, mappings.getOrDefault(num, 0) + 1);
        }

        List<Integer> answer = new ArrayList<>();
        for (Integer key : mappings.keySet()) {
            if (mappings.get(key) == 1) {
                answer.add(key);
            }
        }
        return answer.toArray(new Integer[0]);
    }
}
