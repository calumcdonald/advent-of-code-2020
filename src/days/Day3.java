package days;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day3 {

    private static ArrayList<String> rows = new ArrayList<>();

    public int evalLine(String line, int col){
        if(line.charAt(col) == '#'){
            return 1;
        }
        else{
            return 0;
        }
    }

    public int evalSlope(int colOffset, int rowOffset){
        int col = 0;
        int treeCount = 0;
        String line;

        for(int i = rowOffset; i < rows.size(); i+=rowOffset){
            line = rows.get(i);

            col += colOffset;

            if(col > line.length() - 1) {
                col -= line.length();
            }

            treeCount += evalLine(line, col);
        }

        return treeCount;
    }

    public static void main(String[] args){
        try {
            File dataInp = new File("data/day3input.txt");
            Scanner sc = new Scanner(dataInp);
            while(sc.hasNextLine()){
                rows.add(sc.nextLine());
            }
        }
        catch(FileNotFoundException e) {
            System.out.println("File not found.");
        }

        Day3 day3 = new Day3();
        System.out.println("Result: " + (day3.evalSlope(1, 1) *
                day3.evalSlope(3, 1) *
                day3.evalSlope(5, 1) *
                day3.evalSlope(7, 1) *
                day3.evalSlope(1, 2)));
    }
}