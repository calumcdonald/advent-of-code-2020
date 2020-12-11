package days;

import utils.Board;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day11 {

    private static List<String> data = new ArrayList<>();

    public static void main(String[] args) {
        try {
            File dataInp = new File("data/day11input.txt");
            Scanner sc = new Scanner(dataInp);
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                data.add(line);
            }

            Board board = new Board(data);

            for(int i = 0; i < 50; i++){
                boolean result = board.updateBoard();
                System.out.println("~~~~~~~~~~~~~~~~~~~~");
                board.printBoard();

                if(result){
                    break;
                }
            }

            System.out.println("Result: " + board.getOccupiedSeats());
        }
        catch(FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }
}