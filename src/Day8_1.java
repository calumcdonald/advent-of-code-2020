import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Day8_1 {

    private static ArrayList<String> instructions = new ArrayList<>();
    private static HashMap<Integer, Integer> visits = new HashMap<>();

    public static void main(String[] args) {
        int acc = 0;

        try {
            File dataInp = new File("data/day8input.txt");
            Scanner sc = new Scanner(dataInp);
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                instructions.add(line);
            }

            int step;
            for(int i = 1; i < instructions.size(); i+=step){
                step = 1;
                String inst = instructions.get(i - 1);
                String op = inst.substring(0, inst.indexOf(' '));
                String arg = inst.substring(inst.indexOf(' ') + 1);

                if(!visits.containsKey(i)){
                    visits.put(i, 1);
                }
                else{
                    visits.put(i, visits.get(i) + 1);
                }

                if(visits.get(i) == 2){
                    System.out.println("Result: " + acc);
                    break;
                }

                if(op.equals("acc")){
                    acc += Integer.parseInt(arg);
                }
                else if(op.equals("jmp")){
                    step = Integer.parseInt(arg);
                }
            }
        }
        catch(FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }
}