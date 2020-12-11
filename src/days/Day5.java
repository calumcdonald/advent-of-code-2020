package days;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Day5{

    public int evalCode(String str, int lowerLimit, int upperLimit){
        double upper = upperLimit;
        double lower = lowerLimit;

        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);

            if(c == 'F' || c == 'L'){
                upper = Math.floor((upper+lower)/2);

                if(upper == lower){
                    return (int)upper;
                }
            }
            else if(c == 'B' || c == 'R'){
                lower = Math.ceil((upper+lower)/2);

                if(upper == lower){
                    return (int)lower;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int count = 0;
        int max = 0;

        ArrayList<Integer> seats = new ArrayList<>();

        try {
            File dataInp = new File("data/day5input.txt");
            Scanner sc = new Scanner(dataInp);
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                String row = line.substring(0, 7);
                String column = line.substring(7);
                count++;

                int result = (new Day5().evalCode(row, 0, 127) * 8) + new Day5().evalCode(column, 0, 7);
                seats.add(result);
                if(result > max){
                    max = result;
                }
            }
        }
        catch(FileNotFoundException e) {
            System.out.println("File not found.");
        }

        System.out.println("Max seat ID: " + max);

        Collections.sort(seats);
        for(int i = 0; i < max; i++){
            if(seats.get(i + 1) - seats.get(i) != 1){
                System.out.println("Your seat: " + (seats.get(i) + 1));
            }
        }
    }
}