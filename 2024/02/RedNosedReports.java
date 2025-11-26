import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

// https://adventofcode.com/2024/day/2
public class RedNosedReports {
    
    public static void main() throws FileNotFoundException, IOException {

        var safe = countSafeLines("example.txt");
        System.out.println("Example safe lines: " + safe);

        // Part One: Safe lines should be 379
        safe = countSafeLines("input.txt");
        System.out.println("Input safe lines: " + safe);
    }

    public static int countSafeLines(String fileName) throws FileNotFoundException, IOException {
         try(BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            int safe = 0;
            while((line = reader.readLine()) != null) {
                ArrayList<Integer> levels = new ArrayList<>();
                Arrays.stream(line.strip().split("\\s+"))
                    .forEach(s -> levels.add(Integer.parseInt(s)));

                if(isSafe(levels))
                    safe += 1;
            }
         
            return safe; 
        }
    }

    public static boolean isGradual(Integer a, Integer b) {
        final int diff = Math.abs(a - b);
        return (diff >= 1 && diff <= 3);
    }

    public static boolean isSafe(ArrayList<Integer> levels) {
        if(levels.get(0) < levels.get(1)) {
            for(int i = 0; i < levels.size() - 1; i++) {
                if(levels.get(i) >= levels.get(i + 1)) return false;
                if(!isGradual(levels.get(i), levels.get(i + 1))) return false; 
            }
        } else {
            for(int i = 0; i < levels.size() - 1; i++) {
                if(levels.get(i) <= levels.get(i + 1)) return false;
                if(!isGradual(levels.get(i), levels.get(i + 1))) return false; 
            }
        }

        return true;
    }

}
