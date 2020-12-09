import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Day8_2{

    private static ArrayList<String> instructions = new ArrayList<>();


    public HashMap<Boolean, Integer> checkChange(ArrayList<String> instructions){
        int acc = 0;
        int step;
        HashMap<Integer, Integer> visits = new HashMap<>();
        HashMap<Boolean, Integer> result = new HashMap<>();

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
                result.put(false, acc);
                return result;
            }

            if(op.equals("acc")){
                acc += Integer.parseInt(arg);
            }
            else if(op.equals("jmp")){
                step = Integer.parseInt(arg);
            }
        }

        result.put(true, acc);
        return result;
    }

    public static void main(String[] args) {
        try {
            File dataInp = new File("data/day8input.txt");
            Scanner sc = new Scanner(dataInp);
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                instructions.add(line);
            }

            for(int i = 1; i < instructions.size(); i++){
                ArrayList<String> tempInstructions = new ArrayList<>(instructions);

                String inst = instructions.get(i - 1);
                String op = inst.substring(0, inst.indexOf(' '));
                String arg = inst.substring(inst.indexOf(' ') + 1);

                boolean change = false;
                if(op.equals("jmp")){
                    tempInstructions.set(i - 1, "nop " + arg);
                    change = true;
                }
                else if(op.equals("nop")){
                    tempInstructions.set(i - 1, "jmp " + arg);
                    change = true;
                }

                if(change) {
                    HashMap<Boolean, Integer> result;
                    result = new Day8_2().checkChange(tempInstructions);
                    if(result.containsKey(true)) {
                        System.out.println("Result: " + result.get(true));
                    }
                }
            }
        }
        catch(FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }
}