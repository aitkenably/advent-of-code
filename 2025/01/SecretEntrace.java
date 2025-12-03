import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class SecretEntrace {

    public static void main() {
        // Part One
        // Correct answer: 3                                                                                                                               
        System.out.println(countZeroes("example.txt"));
        // Correct answer: 1040
        System.out.println(countZeroes("input.txt"));
    }

    // Limits math in the range [1, upperLimit]
    // If the answer is zero, then that's upperLimit
    public static int moduloMath(int upperLimit, int current, int adjustment) {
        var result = (((current + adjustment) % upperLimit) + upperLimit) % upperLimit; 
        if(result == 0) 
            return upperLimit;
        else 
            return result;
    }

    public static int countZeroes(String fileName) {
        List<String> lines = readAllLines(fileName);
        
        int cnt = 0;
        int dial = 50;

        for(String line : lines) {
            int clicks = Integer.valueOf(line.strip().substring(1, line.length())); 
            if(line.startsWith("L")) clicks = clicks * -1; 
            dial = moduloMath(100, dial + 1, clicks) - 1;

            if(dial == 0) cnt += 1;
        }

        return cnt; 
    }

    private static List<String> readAllLines(String fileName) {
        List<String> lines = null; 
        try {
            lines = Files.readAllLines(Paths.get(fileName));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        return lines;  
    }

}
