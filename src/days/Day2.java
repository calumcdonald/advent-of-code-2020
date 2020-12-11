package days;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day2{

    public static void main(String[] args) {
        try {
            File dataInp = new File("data/day2input.txt");
            Scanner sc = new Scanner(dataInp);
            int counter = 0;
            while(sc.hasNextLine()){
                if(new Day2().evalLinePart2(sc.nextLine())) {
                    counter++;
                }
            }

            System.out.println("Result: " + counter);
        }
        catch(FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }

    public boolean evalLinePart1(String line){
        int min = 0;
        int max = 0;
        char letter = ' ';
        String password = "";
        int lCounter = 0;

        int hIndex = 0;
        int spaces = 0;

        for(int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);

            if(c == '-') {
                min = Integer.parseInt(line.substring(0, i));
                hIndex = i;
            }
            else if(c == ' ' && spaces == 0){
                spaces++;
                max = Integer.parseInt(line.substring(hIndex + 1, i));
                letter = line.charAt(i + 1);
            }
            else if(c == ' ' && spaces == 1){
                password = line.substring(i + 1);
            }
        }

        for(int i = 0; i < password.length(); i++){
            char c = password.charAt(i);
            if(c == letter){
                lCounter++;
            }
        }

        return !((lCounter > max) || (lCounter < min));
    }

    public boolean evalLinePart2(String line){
        int i1 = 0;
        int i2 = 0;
        char letter = ' ';
        String password = "";

        int hIndex = 0;
        int spaces = 0;

        for(int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);

            if(c == '-') {
                i1 = Integer.parseInt(line.substring(0, i));
                hIndex = i;
            }
            else if(c == ' ' && spaces == 0){
                spaces++;
                i2 = Integer.parseInt(line.substring(hIndex + 1, i));
                letter = line.charAt(i + 1);
            }
            else if(c == ' ' && spaces == 1){
                password = line.substring(i + 1);
            }
        }

        int count = 0;
        if(password.charAt(i1 - 1) == letter){
            count++;
        }

        if(password.charAt(i2 - 1) == letter){
            count++;
        }

        return count == 1;
    }
}