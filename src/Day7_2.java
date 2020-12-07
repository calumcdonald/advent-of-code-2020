import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Day7_2 {
    private static HashMap<String, ArrayList<String>> bagsMap = new HashMap<>();
    private static ArrayList<String> outers = new ArrayList<>();

    public int countBags(ArrayList<String> types){
        System.out.println("~~~");
        System.out.println("types: " + types);
        int count = 0;

        if(types.size() == 0){
            return 0;
        }
        else{
            for(String type : types){
                int num = Integer.parseInt(type.substring(0, 1));
                count = countBags(bagsMap.get(type.substring(2)));
                count *= num;
            }
        }

        System.out.println("count: " + count);
        return count;
    }

    public static void main(String[] args){
        int result = 0;

        try {
            File dataInp = new File("data/day7input.txt");
            Scanner sc = new Scanner(dataInp);
            while(sc.hasNextLine()){
                ArrayList<String> types = new ArrayList<>();
                String line = sc.nextLine();
                String container = line.substring(0, line.indexOf(" bags"));
                outers.add(container);

                for(int i = 0; i < line.length(); i++){
                    if(Character.isDigit(line.charAt(i))){
                        types.add(line.substring(i, line.indexOf(" bag", i)));
                    }
                }

                bagsMap.put(container, types);
            }

            result = new Day7_2().countBags(bagsMap.get("shiny gold"));
        }
        catch(FileNotFoundException e) {
            System.out.println("File not found.");
        }

        System.out.println("Result: " + result);
    }
}