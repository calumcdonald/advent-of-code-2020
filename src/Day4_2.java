import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day4_2{

    public int evalPassport(HashMap<String, String> passport){
        int correctCount = 0;

        for(Map.Entry<String, String> e : passport.entrySet()){
            String key = e.getKey();
            String value = e.getValue();

            switch(key){
                case("byr"):
                    if(value.length() == 4){
                        int num = Integer.parseInt(value);
                        if(num >= 1920 && num <= 2002){
                            correctCount++;
                        }
                    }
                    break;
                case("iyr"):
                    if(value.length() == 4){
                        int num = Integer.parseInt(value);
                        if(num >= 2010 && num <= 2020){
                            correctCount++;
                        }
                    }
                    break;
                case("eyr"):
                    if(value.length() == 4){
                        int num = Integer.parseInt(value);
                        if(num >= 2020 && num <= 2030){
                            correctCount++;
                        }
                    }
                    break;
                case("hgt"):
                    if(value.contains("cm")){
                        int i = value.indexOf("c");
                        int num = Integer.parseInt(value.substring(0, i));

                        if(num >= 150 && num <= 193){
                            correctCount++;
                        }
                    }
                    else if(value.contains("in")){
                        int i = value.indexOf("i");
                        int num = Integer.parseInt(value.substring(0, i));

                        if(num >= 59 && num <= 76){
                            correctCount++;
                        }
                    }
                    break;
                case("hcl"):
                    if(value.indexOf('#') == 0){
                        if(value.substring(1).length() == 6){
                            int num = 0;
                            for(int i = 0; i < 6; i++){
                                String aregex = ".*[a-f].*";
                                String nregex = ".*[0-9].*";
                                if(value.matches(aregex) || value.matches(nregex)){
                                    num++;
                                }
                            }

                            if(num == 6) {
                                correctCount++;
                            }
                        }
                    }
                    else{
                        break;
                    }
                case("ecl"):
                    ArrayList<String> colours = new ArrayList<>();
                    colours.add("amb");
                    colours.add("blu");
                    colours.add("brn");
                    colours.add("gry");
                    colours.add("grn");
                    colours.add("hzl");
                    colours.add("oth");

                    for(String s : colours){
                        if(value.contains(s)){
                            correctCount++;
                        }
                    }
                    break;
                case("pid"):
                    if(value.length() == 9){
                        correctCount++;
                    }
                    break;
            }
        }

        if(correctCount == 7){
            return 1;
        }
        else{
            return 0;
        }
    }

    public static void main(String[] args){
        int result = 0;
        HashMap<String, String> passport = new HashMap<>();

        try {
            File dataInp = new File("data/day4input.txt");
            Scanner sc = new Scanner(dataInp);
            while(sc.hasNextLine()){
                String line = sc.nextLine();

                if(line.length() == 0){
                    result += new Day4_2().evalPassport(passport);
                    passport = new HashMap<>();
                }
                else{
                    line = line + " ";
                    int c = line.indexOf(':');
                    while(c >= 0){
                        String type = line.substring(c - 3, c);
                        String data = line.substring(c + 1, line.indexOf(" ", c + 1));

                        passport.put(type, data);

                        c = line.indexOf(':', c + 1);
                    }
                }
            }
        }
        catch(FileNotFoundException e) {
            System.out.println("File not found.");
        }

        System.out.println("Result: " + result);
    }
}