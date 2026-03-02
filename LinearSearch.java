import java.util.ArrayList;

public class LinearSearch {
    public static int linearSearch(ArrayList<Integer> arr, int target) {
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) == target) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = FileOperator.getIntList("numbers.txt");

        System.out.print("Array: ");
        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println();

        int target = 11;
        System.out.println("Searching for: " + target);

        long startTime = System.nanoTime();
        int result = linearSearch(arr, target);
        long endTime = System.nanoTime();

        if (result == -1) {
            System.out.println("Element not found in the array.");
        } else {
            System.out.println("Element found at index: " + result);
        }

        long duration = endTime - startTime;
        System.out.println("Time taken: " + duration + " nanoseconds");
        System.out.println("Time taken: " + (duration / 1000000.0) + " milliseconds");
    }
}
