package days;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Day13{

    private static HashMap<Integer, List<Integer>> buses = new HashMap<>();
    private static int timestamp = 0;

    public HashMap<Integer, Integer> findMin(HashMap<Integer, Integer> list){
        int lowest = Integer.MAX_VALUE;
        int bus = 0;
        for(Integer key : list.keySet()) {
            if(list.get(key) < lowest){
                lowest = list.get(key);
                bus = key;
            }
        }

        HashMap<Integer, Integer> result = new HashMap<>();
        result.put(bus, lowest);
        return result;
    }

    public static void main(String[] args) {
        try {
            File dataInp = new File("data/day13input.txt");
            Scanner sc = new Scanner(dataInp);
            while(sc.hasNextLine()){
                String line = sc.nextLine();

                if(line.length() < 15){
                    timestamp = Integer.parseInt(line);
                }

                buses.put(13, new ArrayList<>());
                buses.put(41, new ArrayList<>());
                buses.put(641, new ArrayList<>());
                buses.put(19, new ArrayList<>());
                buses.put(17, new ArrayList<>());
                buses.put(29, new ArrayList<>());
                buses.put(661, new ArrayList<>());
                buses.put(37, new ArrayList<>());
                buses.put(23, new ArrayList<>());

                /*
                else{
                    int lastComma = 0;
                    for(int i = 0; i < line.length(); i++) {
                        if(line.charAt(i) == ','){
                            String bus = line.substring(lastComma, i);
                            System.out.println(bus);

                            if(bus.equals("x")) continue;
                            else buses.add(Integer.parseInt(bus));

                            lastComma = i;
                        }
                    }
                }
                 */

                for(Integer key : buses.keySet()) {
                    List<Integer> table = buses.get(key);

                    if(table.size() == 0) table.add(0);

                    for(int j = 0; j < 100000; j++){
                        table.add(table.get(j) + key);
                    }
                }
            }

            HashMap<Integer, Integer> closestValues = new HashMap<>();
            for(Integer key : buses.keySet()) {
                List<Integer> table = buses.get(key);

                int val = table.get(0);
                int diff = Math.abs(val - timestamp);
                int idx = 0;
                for (int i = 0; i < table.size(); i++) {
                    int newDiff = Math.abs(table.get(i) - timestamp);
                    if (newDiff < diff) {
                        idx = i;
                        diff = newDiff;
                    }
                }

                if (table.get(idx) >= timestamp) {
                    closestValues.put(key, table.get(idx));
                }
            }

            HashMap<Integer, Integer> earliestBus = new Day13().findMin(closestValues);
            for(Integer key : earliestBus.keySet()){
                System.out.println("Result: " + (key * (earliestBus.get(key) - timestamp)));
            }
        }
        catch(FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }
}