import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day9 {

    public static void main(String[] args) {
        List<String> data = new ArrayList<>();
        List<String> preamble = new ArrayList<>();
        String sum = " ";

        try {
            File dataInp = new File("data/day9input.txt");
            Scanner sc = new Scanner(dataInp);
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                data.add(line);
            }
        }
        catch(FileNotFoundException e) {
            System.out.println("File not found.");
        }

        for(int i = 0; i < data.size(); i++){
            if(i + 25 <= data.size() - 1) {
                preamble = data.subList(i, i + 25);
                sum = data.get(i + 25);

                System.out.println("preamble " + i + ": " + preamble);
                System.out.println("sum: " + sum);
            }
        }

        boolean set = false;
        for(int i = 0; i < preamble.size(); i++) {
            for(int j = 0; j < preamble.size(); j++) {
                long a = Long.parseLong(preamble.get(i));
                long b = Long.parseLong(preamble.get(j));
                long c = Long.parseLong(sum);
                long add = a + b;

                if(add == c) {
                    System.out.println("added " + a + " + " + b + " to make: " + c);
                    set = true;
                    break;
                }
            }
        }

        if(!set){
            System.out.println("Result: " + sum);
        }
    }
}