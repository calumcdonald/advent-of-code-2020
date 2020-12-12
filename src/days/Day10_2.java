package days;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day10_2 {

    private static List<Integer> adapters = new ArrayList<>();
    private static List<Integer> diffs = new ArrayList<>();

    public long findPermutations(List<Integer> block){
        if(block.size() == 3) return 2;
        if(block.size() == 4) return 4;
        if(block.size() == 5) return 7;
        if(block.size() == 6) return 13;

        return 1;
    }

    public List<Integer> diff(List<Integer> block){
        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < block.size(); i++){
            if(i + 1 < block.size()){
                int diff = block.get(i + 1) - block.get(i);
                result.add(diff);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        long result = 1;

        try {
            File dataInp = new File("data/day10input.txt");
            Scanner sc = new Scanner(dataInp);
            adapters.add(0);
            while(sc.hasNextLine()){
                adapters.add(Integer.parseInt(sc.nextLine()));
            }
            adapters.add(adapters.get(adapters.size()-1) + 3);
            Collections.sort(adapters);
            System.out.println(adapters);

            diffs = new Day10_2().diff(adapters);
            System.out.println(diffs);

            List<Integer> block = new ArrayList<>();
            Map<Integer, Integer> sizes = new HashMap<>();
            for(int i = 0; i < adapters.size(); i++){
                if(i + 1 < adapters.size()) {
                    int thisAdapter = adapters.get(i);
                    int nextAdapter = adapters.get(i + 1);
                    int diff = nextAdapter - thisAdapter;

                    if(diff == 1){
                        block.add(thisAdapter);
                    }
                    else if(diff == 3 || diff == 2){
                        block.add(thisAdapter);
                        System.out.println(block);
                        sizes.put(block.size(), 1);
                        result *= new Day10_2().findPermutations(block);
                        block = new ArrayList<>();
                    }
                }
            }

            System.out.println(sizes);
        }
        catch(FileNotFoundException e) {
            System.out.println("File not found.");
        }

        System.out.println("Result: " + result);
    }
}