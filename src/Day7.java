import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day7 {

    private static ArrayList<Integer> data = new ArrayList<Integer>();

    public static void main(String[] args) {
        try {
            File dataInp = new File("data/day7input.txt");
            Scanner sc = new Scanner(dataInp);
            while(sc.hasNextLine()){
                data.add(sc.nextInt());
            }
        }
        catch(FileNotFoundException e) {
            System.out.println("File not found.");
        }

        System.out.println("Result: " + new Day7().calcResult());
    }
}