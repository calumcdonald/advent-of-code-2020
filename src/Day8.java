import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day8{

    private static ArrayList<String> instructions = new ArrayList<>();

    public static void main(String[] args) {
        int acc = 0;

        try {
            File dataInp = new File("data/day8input.txt");
            Scanner sc = new Scanner(dataInp);
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                instructions.add(line);
            }

            for(int i = 0; i < instructions.size(); i++){
                String inst = instructions.get(i);
                String op = inst.substring(0, inst.indexOf(' '));
                String arg = inst.substring(inst.indexOf(' ') + 1);
                char mod = arg.charAt(0);

                if(op.equals("acc")){
                    if(mod == '+'){
                        acc += Integer.parseInt(arg.substring(1));
                    }
                    else if(mod == '-'){
                        acc -= Integer.parseInt(arg.substring(1));
                    }
                    System.out.println("acc: " + acc);
                }
                else if(op.equals("jmp")){
                    if(mod == '+'){
                        i += Integer.parseInt(arg.substring(1));
                    }
                    else if(mod == '-'){
                        i -= Integer.parseInt(arg.substring(1));
                    }
                    System.out.println("i: " + i);
                }
            }
        }
        catch(FileNotFoundException e) {
            System.out.println("File not found.");
        }

        System.out.println("Result: " + 0);
    }
}