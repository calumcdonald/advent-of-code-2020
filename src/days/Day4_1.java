package days;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Day4_1 {

    public int evalPassport(ArrayList<String> passport){
        int correctCount = 0;

        HashMap<String, Boolean> pData = new HashMap<>();
        pData.put("byr", false);
        pData.put("iyr", false);
        pData.put("eyr", false);
        pData.put("hgt", false);
        pData.put("hcl", false);
        pData.put("ecl", false);
        pData.put("pid", false);
        pData.put("cid", false);

        for(String s : passport) {
            int c = s.indexOf(':');
            while (c >= 0) {
                String data = s.substring(c - 3, c);

                pData.put(data, true);

                c = s.indexOf(':', c + 1);
            }
        }

        System.out.println("~~~");
        System.out.println("Passport: " + passport);
        System.out.println("Map: " + pData);

        for(Map.Entry<String, Boolean> e : pData.entrySet()){
            String key = e.getKey();
            Boolean value = e.getValue();
            System.out.println("Key: " + key);
            System.out.println("Value: " + value);

            if((key.equals("byr")
                    || key.equals("iyr")
                    || key.equals("eyr")
                    || key.equals("hgt")
                    || key.equals("hcl")
                    || key.equals("ecl")
                    || key.equals("pid"))
                    && value.equals(false)){
                System.out.println("0");
                return 0;
            }
            else{
                correctCount++;
            }
        }

        if(correctCount >= 7) {
            System.out.println("+");
            return 1;
        }
        else{
            return 0;
        }
    }

    public static void main(String[] args){
        int result = 0;
        ArrayList<String> passport = new ArrayList<>();

        try {
            File dataInp = new File("data/day4input.txt");
            Scanner sc = new Scanner(dataInp);
            while(sc.hasNextLine()){
                String line = sc.nextLine();

                if(line.length() == 0){
                    result += new Day4_1().evalPassport(passport);
                    System.out.println("Result: " + result);
                    passport = new ArrayList<>();
                }
                else{
                    passport.add(line);
                }
            }
        }
        catch(FileNotFoundException e) {
            System.out.println("File not found.");
        }

        System.out.println("Result: " + result);
    }
}