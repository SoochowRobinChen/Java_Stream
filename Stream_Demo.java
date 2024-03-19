import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Stream_Demo {

    public static void main(String[] args) {

        List<Integer> integerList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));

        // before Stream API, if we increment each element by 1
        List<Integer> newIntegerList = new ArrayList<>();
        for (Integer i : integerList) {
            newIntegerList.add(i + 1);
        }

        // after Stream API, if we increment each element by 1
        List<Integer> newIntegerListByStream = integerList.stream()
                .map(i -> i + 1)
                .toList();


        // demo for intermediate operation
        // Chaining intermediate stream operations
        integerList.stream()
                .filter(n -> n % 2 == 0) // Filter even numbers
                .map(n -> n * 2)         // Double each even number
                .distinct()              // Remove duplicates
                .flatMap(n -> Arrays.stream(new Integer[]{n, n * 10})) // Duplicate each number and add a multiple of 10
                .forEach(System.out::println); // Print each element


        // demo for parallel computing
        // Sequential processing
        System.out.println("Sequential processing:");
        integerList.stream()
                .forEach(System.out::println);

        // Parallel processing
        System.out.println("Parallel processing:");
        integerList.stream()
                .parallel()
                .forEach(System.out::println);
    }
}
