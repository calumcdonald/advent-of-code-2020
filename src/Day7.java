import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Day7{
    private static HashMap<String, ArrayList<String>> bagsMap = new HashMap<>();
    private static ArrayList<String> outers = new ArrayList<>();

    public int containsShinyGold(ArrayList<String> types){
        System.out.println("~~~");
        System.out.println("types: " + types);
        int count = 0;

        if(types.contains("shiny gold")){
            System.out.println("returning 1");
            return 1;
        }
        else if(types.size() == 0){
            return 0;
        }
        else{
            for(String type : types){
                count += containsShinyGold(bagsMap.get(type));
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
                        types.add(line.substring(i + 2, line.indexOf(" bag", i)));
                    }
                }

                bagsMap.put(container, types);
            }

            for(String outer : outers) {
                int golds = 0;
                ArrayList<String> types = bagsMap.get(outer);
                golds += new Day7().containsShinyGold(types);

                if(golds > 1){
                    result++;
                }
            }
        }
        catch(FileNotFoundException e) {
            System.out.println("File not found.");
        }

        System.out.println("Result: " + result);
    }
}