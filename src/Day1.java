import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day1 {

    private static ArrayList<Integer> data = new ArrayList<Integer>();

    public static void main(String[] args) {
        try {
            File dataInp = new File("data/day1input.txt");
            Scanner sc = new Scanner(dataInp);
            while(sc.hasNextLine()){
                data.add(sc.nextInt());
            }
        }
        catch(FileNotFoundException e) {
            System.out.println("File not found.");
        }

        System.out.println("Result: " + new Day1().calcResult());
    }

    public int calcResult() {
        for(int i = 0; i < data.size(); i++) {
            for(int j = 0; j < data.size(); j++) {
                for(int k = 0; k < data.size(); k++) {
                    int add = data.get(i) + data.get(j) + data.get(k);
                    if (add == 2020) {
                        return data.get(i) * data.get(j) * data.get(k);
                    }
                }
            }
        }
        return 0;
    }
}