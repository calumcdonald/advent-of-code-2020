import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day5{

    public int evalRow(String row){
        int upper = 127;
        int lower = 0;

        for(int i = 0;i < row.length(); i++){
            char c = row.charAt(i);

            if(c == 'F'){
                upper = upper/2;
            }
            else if(c == 'B'){
                lower = lower/2;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int count = 0;
        int max = 0;

        try {
            File dataInp = new File("data/day5input.txt");
            Scanner sc = new Scanner(dataInp);
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                String row = line.substring(0, 7);
                String column = line.substring(7);
                count++;

                int result = (new Day5().evalRow(row) * 8) /*+ new Day5().evalColumn(column)*/;
                if(result > max){
                    max = result;
                }

                System.out.println("~~~");
                System.out.println(count);
                System.out.println("line: " + line);
                System.out.println("row:" + row);
                System.out.println("column: " + column);
            }
        }
        catch(FileNotFoundException e) {
            System.out.println("File not found.");
        }

        System.out.println("Result: " + max);
    }
}