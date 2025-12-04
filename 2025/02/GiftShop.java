import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class GiftShop {
    
    int low = 11; 
    int high = 22;

    public static void main() {
       // Part One 
       // Correct answer: 1227775554
        System.out.println(sumInvalidIds("example.txt"));
       // Correct answer: 31839939622
       System.out.println(sumInvalidIds("input.txt"));

        // Part Two
        // Correct answer: 4174379265
        System.out.println(sumInvalidIds2("example.txt"));
        // Correct answer: 
        System.out.println(sumInvalidIds2("input.txt"));

    }

    public static long sumInvalidIds(String fileName) {
        long sum = 0;
        List<String> ranges = readAllRanges(fileName);
        for(int i = 0; i < ranges.size(); i++) {
            String[] values = ranges.get(i).split("-");
            long low = Long.valueOf(values[0]);
            long high = Long.valueOf(values[1]);
            //System.out.println(ranges.get(i));
            for(long j = low; j <= high; j++) {
                if(hasRepeatingDigits(String.valueOf(j))) {
                    //System.out.println("Repeating digits: " + j);
                    sum += j;
                }
            }
            //System.out.println("");
        }

        return sum;
    }

    public static long sumInvalidIds2(String fileName) {
        long sum = 0;
        List<String> ranges = readAllRanges(fileName);
        for(int i = 0; i < ranges.size(); i++) {
            String[] values = ranges.get(i).split("-");
            long low = Long.valueOf(values[0]);
            long high = Long.valueOf(values[1]);
            //System.out.println(ranges.get(i));
            for(long j = low; j <= high; j++) {
                if(hasTwoRepeatingSequences(String.valueOf(j))) {
                    //System.out.println("Repeating digits: " + j);
                    sum += j;
                }
            }
            //System.out.println("");
        }

        return sum;
    }

    private static boolean hasRepeatingDigits(String s) {
        int len = s.length();
        if(len % 2 != 0) return false;
        String sub1 = s.substring(0, len / 2);
        String sub2 = s.substring(len / 2, len);
        return sub1.equals(sub2);
    }

    private static boolean hasTwoRepeatingSequences(String s) {
        for(int i = 0; i < s.length() - 1; i++) {
            String sub = s.substring(0, i + 1);
            //String rest = s.substring(i + 1, s.length());
            
            String repeat = sub.repeat(s.length() / sub.length());
            
            // String.repeat
            //System.out.println(s);
            //System.out.println(repeat);
            //System.out.println("\n");

            if(s.equals(repeat)) 
                return true; 
        }

        return false; 
    }

    private static List<String> readAllRanges(String fileName) {
        List<String> ranges = null;
        try {
            List<String> lines = Files.readAllLines(Path.of(fileName));
            ranges = List.of(lines.get(0).split(","));
        } catch(Exception ex) {
            ex.printStackTrace();
            System.exit(-1);
        }

        return ranges; 
    }

   

}
