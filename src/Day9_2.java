import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day9_2{

    public static void main(String[] args) {
        List<String> data = new ArrayList<>();

        try {
            File dataInp = new File("data/day9input.txt");
            Scanner sc = new Scanner(dataInp);
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                data.add(line);
            }
        }
        catch(FileNotFoundException e) {
            System.out.println("File not found.");
        }

        List<Long> contiguous;
        long total;
        for(int i = 0; i < data.size(); i++){
            total = 0;
            contiguous = new ArrayList<>();
            for(int j = 0; j < data.size(); j++){
                if((i + j) < data.size()){
                    long num = Long.parseLong(data.get(i + j));
                    total += num;

                    if(total == 1398413738){
                        long min = new Day9_2().findMin(contiguous);
                        long max = new Day9_2().findMax(contiguous);
                        System.out.println("Result: " + (min + max));
                        break;
                    }
                    else if(total < 1398413738){
                        contiguous.add(num);
                    }
                }
            }
        }
    }

    public long findMax(List<Long> list){
        long max = 0;
        for(int i = 0; i < list.size(); i++){
            if(list.get(i) > max){
                max = list.get(i);
            }
        }

        return max;
    }

    public long findMin(List<Long> list){
        long min = Long.MAX_VALUE;
        for(int i = 0; i < list.size(); i++){
            if(list.get(i) < min){
                min = list.get(i);
            }
        }

        return min;
    }
}