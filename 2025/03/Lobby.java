import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class Lobby {

    public static void main() {
        List<String> example = readInput("example.txt");
        List<String> input = readInput("input.txt");

        // Part One
        // Correct Answer: 357
        System.out.println(sumOfLargest(example));
        // Correct Answer: 17346
        System.out.println(sumOfLargest(input));

    }

    public static int sumOfLargest(List<String> banks) {
        int sum = 0;
        for (String bank : banks) {
            sum += largestPair(bank);
        }
        return sum;
    }

    public static int largestPair(String s) {
        SortedSet<Integer> ss = new TreeSet<>();
        for(int i = 0; i < s.length(); i++) {
            char d = s.charAt(i);
            for(int j = i + 1; j < s.length(); j++) {
                char e = s.charAt(j);
                char[] digits = {d, e};
                ss.add(Integer.valueOf(new String(digits)));
            }
        }

        return ss.last();
    }

    public static List<String> readInput(String fileName) {
        List<String> banks = null;
        try {
            banks = Files.readAllLines(Path.of(fileName));
        } catch(Exception ex) {
            ex.printStackTrace();
            System.exit(-1);
        }

        return banks;
    }

}
