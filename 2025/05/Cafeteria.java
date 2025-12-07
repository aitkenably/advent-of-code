import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Cafeteria {

    public static void main() {
      // Part One
      // Correct answer: 3
      System.out.println(countFresh("example.txt"));
      // Correct answer: 
      System.out.println(countFresh("input.txt"));

    }

    public record Range(long start, long end) { 
        public static Range from(String s) {
            String[] p = s.split("-");
            return new Range(Long.valueOf(p[0]), Long.valueOf(p[1]));
        }

        public boolean contains(long n) {
            return n >= start && n <= end;
        }
    } 

    public static int countFresh(String fileName) {
        var ranges = new ArrayList<Range>();
        var ids = new ArrayList<Long>();
        
        var cnt = 0;
        readFile(fileName, ranges, ids);
        for(long id: ids) {
            for(Range r : ranges) {
                if(r.contains(id)) {
                    cnt++;
                    break;
                }
            }
        }

        return cnt;
    }

    public static void readFile(String fileName, List<Range> ranges, List<Long> ids) {
        try {
            List<String> lines = Files.readAllLines(Path.of(fileName));
            boolean readingRanges = true; 
            for(String line : lines) {
                if(line.trim().isBlank()) {
                    readingRanges = false;
                    continue; 
                }

                if(readingRanges) {
                    ranges.add(Range.from(line));
                } else {
                    ids.add(Long.valueOf(line));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }    
    }

}
