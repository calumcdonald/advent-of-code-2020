package days;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day10_2 {

    private static List<Integer> adapters = new ArrayList<>();
    private static List<Integer> paths = new ArrayList<>();

    public static void main(String[] args) {
        int outlet = 0;
        int device;
        int result = 0;

        try {
            File dataInp = new File("data/day10input.txt");
            Scanner sc = new Scanner(dataInp);
            while(sc.hasNextLine()){
                adapters.add(Integer.parseInt(sc.nextLine()));
            }

            for(int i = 0; i < adapters.size(); i++){
                paths.add(0);
            }

            Collections.sort(adapters);
            device = adapters.get(adapters.size()-1) + 3;

            int diff = adapters.get(0) - outlet;

            for(int i = 0; i < adapters.size(); i++){
                for(int j = 0; j < 3; j++) {
                    if((i + j) + 1 < adapters.size()) {
                        int adapter = adapters.get(i);
                        int nextAdapter = adapters.get(i + j);

                        if(nextAdapter - adapter >= 0 && nextAdapter - adapter <= 3){
                            paths.set(i, paths.get(i) + 1);
                        }
                    }
                }
            }

            diff = device - adapters.get(adapters.size() - 1);
        }
        catch(FileNotFoundException e) {
            System.out.println("File not found.");
        }

        System.out.println("Result: " + paths.get(paths.size() - 1));
    }
}