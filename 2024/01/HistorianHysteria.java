// https://adventofcode.com/2024/day/1

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class HistorianHysteria {
    public static void main(String[] args) {
        
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>(); 

        readInput("example.txt", left, right);
        Collections.sort(left);
        Collections.sort(right);
        System.out.println("Example distance: " + computeDistance(left, right));

        left.clear();
        right.clear();
        
        readInput("partOne.txt", left, right);
        Collections.sort(left);
        Collections.sort(right);
        System.out.println("Part one distance: " + computeDistance(left, right));
    }



     /* 
        Input is two lists of numbers
            3   4
            4   3
            2   5
            1   3
            3   9
            3   3
    
        When need to sort them prior to processing.            
    */
    private static void readInput(String fileName, ArrayList<Integer> left, ArrayList<Integer> right) {
        try(BufferedReader reader = new BufferedReader(new FileReader((fileName)))) {
            String line; 
            while((line = reader.readLine()) != null) {
                String[] numbers = line.strip().split("\\s+");
                left.add(Integer.valueOf(numbers[0]));
                right.add(Integer.valueOf(numbers[1]));    
            }
        } catch(IOException ex) {
            System.err.println(ex);
        }
    }

    private static int computeDistance(ArrayList<Integer> left, ArrayList<Integer> right) {
        int distance = 0; 
        for(int i = 0; i < left.size(); i++) {
            distance += Math.abs(left.get(i) - right.get(i));
        }
        return distance;
    }

}
