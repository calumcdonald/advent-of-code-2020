package days;

import jdk.swing.interop.SwingInterOpUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

public class Day12_2 {

    private static Vector<Integer> ship = new Vector<>();
    private static Vector<Integer> waypoint = new Vector<>();
    private static char[] compass = {'N', 'E', 'S', 'W'};
    private static int cIndex = 1;

    public void printPositions(){
        int sx, sy;
        int wx, wy;

        sx = ship.get(0);
        sy = ship.get(1);

        String sxPos;
        if(sx > 0){
            sxPos = "east";
        }
        else{
            sxPos = "west";
        }

        String syPos;
        if(sy > 0){
            syPos = "north";
        }
        else{
            syPos = "south";
        }

        wx = waypoint.get(0);
        wy = waypoint.get(1);

        String wxPos;
        if(wx > 0){
            wxPos = "east";
        }
        else{
            wxPos = "west";
        }

        String wyPos;
        if(wy > 0){
            wyPos = "north";
        }
        else{
            wyPos = "south";
        }

        System.out.println("ship: " + Math.abs(sx) + " " + sxPos + ", " + Math.abs(sy) + " " + syPos);
        System.out.println("waypoint: " + Math.abs(wx) + " " + wxPos + ", " + Math.abs(wy) + " " + wyPos);
    }

    public void updateWaypoint(int angle){
        waypoint.set(0, (int)Math.round((Math.cos(Math.toRadians(angle)) * waypoint.get(0)) - (Math.sin(Math.toRadians(angle)) * waypoint.get(1))));
        waypoint.set(1, (int)Math.round((Math.sin(Math.toRadians(angle)) * waypoint.get(0)) + (Math.cos(Math.toRadians(angle)) * waypoint.get(1))));
    }

    public static void main(String[] args) {
        ship.addElement(0);
        ship.addElement(0);
        waypoint.addElement(10);
        waypoint.addElement(1);

        new Day12_2().printPositions();

        try {
            File dataInp = new File("data/day12input.txt");
            Scanner sc = new Scanner(dataInp);
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                char action = line.charAt(0);
                int value = Integer.parseInt(line.substring(1));

                switch(action){
                    case('N'):
                        waypoint.set(1, waypoint.get(1) + value);
                        break;
                    case('E'):
                        waypoint.set(0, waypoint.get(0) + value);
                        break;
                    case('S'):
                        waypoint.set(1, waypoint.get(1) - value);
                        break;
                    case('W'):
                        waypoint.set(0, waypoint.get(0) - value);
                        break;
                    case('L'):
                    case('R'):
                        new Day12_2().updateWaypoint(value);
                        break;
                    case('F'):
                        for(int i = 0; i < value; i++){
                            ship.set(0, ship.get(0) + waypoint.get(0));
                            ship.set(1, ship.get(1) + waypoint.get(1));
                        }
                        break;
                }

                System.out.println(action + "" + value);
                new Day12_2().printPositions();
            }
        }
        catch(FileNotFoundException e) {
            System.out.println("File not found.");
        }

        System.out.println("Result: " + (Math.abs(ship.get(0)) + Math.abs(ship.get(1))));
    }
}