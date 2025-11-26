import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

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
                String[] strNs = line.strip().split("\\s+");
                ArrayList<Integer> levels = new ArrayList<>();
                for(int i = 0; i < strNs.length; i++) {
                    levels.add(Integer.parseInt(strNs[i]));
                }

                if(increasingOrDecreasing(levels) && gradualChange(levels))
                    safe += 1;     
            }
         
            return safe; 
        }
    }


    public static boolean gradualChange(ArrayList<Integer> levels) {
        for(int i = 0; i < levels.size() - 1; i++) {
            int abs = Math.abs(levels.get(i).intValue() - levels.get(i + 1).intValue()); 
            if(abs < 1 || abs > 3) return false;
        }

        return true; 
    }

    public static boolean increasingOrDecreasing(ArrayList<Integer> levels) {
        if(levels.get(0) < levels.get(1)) {
            for(int i = 0; i < levels.size() - 1; i++) {
                if(levels.get(i) >= levels.get(i + 1)) return false;
            }
        } else {
            for(int i = 0; i < levels.size() - 1; i++) {
                if(levels.get(i) <= levels.get(i + 1)) return false;
            }
        }

        return true;
    }

}
