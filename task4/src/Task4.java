import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Task4 {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) args = new String[]{"c://1.txt"};
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        ArrayList<Integer> num = new ArrayList<Integer>();
        while (reader.ready()){
            num.add(Integer.parseInt(reader.readLine()));//Строки файла должны иметь вид: "4"
        }
        ArrayList<Integer> count = new ArrayList<Integer>();
        for (int i = 0; i < num.size(); i++) {
            int tempc = 0;
            for (int j = 0; j < num.size(); j++) {
                if (i != j) tempc += Math.abs(num.get(i) - num.get(j));
            }
            count.add(tempc);
        }
        Collections.sort(count);
        System.out.println(count.get(0));
    }
}