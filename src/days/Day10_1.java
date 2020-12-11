package days;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day10_1 {

    private static List<Integer> adapters = new ArrayList<>();
    private static HashMap<Integer, Integer> differences = new HashMap<>();

    public void addToMap(int value){
        if(!differences.containsKey(value)) {
            differences.put(value, 1);
        }
        else{
            differences.put(value, differences.get(value) + 1);
        }
    }
    public static void main(String[] args) {
        int outlet = 0;
        int device;

        try {
            File dataInp = new File("data/day10input.txt");
            Scanner sc = new Scanner(dataInp);
            while(sc.hasNextLine()){
                adapters.add(Integer.parseInt(sc.nextLine()));
            }

            Collections.sort(adapters);
            device = adapters.get(adapters.size()-1) + 3;

            int diff = adapters.get(0) - outlet;
            new Day10_1().addToMap(diff);

            for(int i = 0; i < adapters.size(); i++){
                if(i + 1 < adapters.size()){
                    diff = adapters.get(i + 1) - adapters.get(i);
                    new Day10_1().addToMap(diff);
                }
            }

            diff = device - adapters.get(adapters.size() - 1);
            new Day10_1().addToMap(diff);
        }
        catch(FileNotFoundException e) {
            System.out.println("File not found.");
        }

        System.out.println("Result: " + (differences.get(1) * differences.get(3)));
    }
}