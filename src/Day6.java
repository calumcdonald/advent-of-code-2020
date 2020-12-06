import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Day6{

    public int evalGroup(ArrayList<String> group){
        int result = 0;
        int numPeople = group.size();
        HashMap<Character, Integer> map = new HashMap<>();
        ArrayList<Character> uniqueAnswers = new ArrayList<>();

        for(String answers : group){
            for (int j = 0; j < answers.length(); j++) {
                char c = answers.charAt(j);

                if (!uniqueAnswers.contains(c)) {
                    uniqueAnswers.add(c);
                    map.put(c, 1);
                }
                else{
                    map.put(c, map.get(c) + 1);
                }
            }
        }

        for(Integer v : map.values()){
            if(v == numPeople){
                result++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int result = 0;

        ArrayList<String> group = new ArrayList<>();

        try {
            File dataInp = new File("data/day6input.txt");
            Scanner sc = new Scanner(dataInp);
            while(sc.hasNextLine()){
                String line = sc.nextLine();

                if(line.length() == 0){
                    result += new Day6().evalGroup(group);
                    group = new ArrayList<>();
                }
                else{
                    group.add(line);
                }
            }
        }
        catch(FileNotFoundException e) {
            System.out.println("File not found.");
        }

        System.out.println("Result: " + result);
    }
}