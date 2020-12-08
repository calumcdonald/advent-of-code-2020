import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Day8_2{

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
                char mod = arg.charAt(0);

                System.out.println("~~~");
                System.out.println("instruction: " + i);
                System.out.println("op: " + op);
                System.out.println("arg: " + arg);
                System.out.println("mod: " + mod);
                System.out.println("acc: " + acc);

                if(!visits.containsKey(i)){
                    visits.put(i, 1);
                }
                else{
                    visits.put(i, visits.get(i) + 1);
                }

                System.out.println("visits to instruction " + i + ": " + visits.get(i));

                if(visits.get(i) == 2){
                    System.out.println("Result: " + acc);
                    break;
                }

                if(op.equals("acc")){
                    if(mod == '+'){
                        acc += Integer.parseInt(arg.substring(1));
                    }
                    else if(mod == '-'){
                        acc -= Integer.parseInt(arg.substring(1));
                    }
                    System.out.println("accAfter: " + acc);
                }
                else if(op.equals("jmp")){
                    if(mod == '+'){
                        step = Integer.parseInt(arg.substring(1));
                    }
                    else if(mod == '-'){
                        step = -Integer.parseInt(arg.substring(1));
                    }
                }
            }
        }
        catch(FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }
}