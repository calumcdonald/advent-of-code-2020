package days;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day12{

    private static int x = 0;
    private static int y = 0;
    private static char facing = 'E';
    private static int cIndex = 1;

    public void move(char action, int value){
        char[] compass = {'N', 'E', 'S', 'W'};

        switch(action){
            case('N'):
                y += value;
                break;
            case('S'):
                y -= value;
                break;
            case('E'):
                x += value;
                break;
            case('W'):
                x -= value;
                break;
            case('L'):
                cIndex = (cIndex + 4 - (value/90)) % compass.length;
                facing = compass[cIndex];
                break;
            case('R'):
                cIndex = (cIndex + (value/90)) % compass.length;
                facing = compass[cIndex];
                break;
            case('F'):
                move(facing, value);
                break;
        }
    }

    public static void main(String[] args) {
        try {
            File dataInp = new File("data/day12input.txt");
            Scanner sc = new Scanner(dataInp);
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                char action = line.charAt(0);
                int value = Integer.parseInt(line.substring(1));

                new Day12().move(action, value);

                String xPos;
                if(x > 0){
                    xPos = "east";
                }
                else{
                    xPos = "west";
                }

                String yPos;
                if(y > 0){
                    yPos = "north";
                }
                else{
                    yPos = "south";
                }


                System.out.println(action + "" + value);
                System.out.println("facing: " + facing);
                System.out.println(Math.abs(x) + " " + xPos + ", " + Math.abs(y) + " " + yPos);
            }
        }
        catch(FileNotFoundException e) {
            System.out.println("File not found.");
        }

        System.out.println("Result: " + (Math.abs(x) + Math.abs(y)));
    }
}