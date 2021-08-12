import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
//v1.1
public class Task1 {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) args = new String[]{"5", "4"};
        int n = Integer.parseInt(args[0]);//Первый аргумент должен иметь вид: "4"
        int m = Integer.parseInt(args[1]);//Второй аргумент должен иметь вид: "3"

        int[] circA = new int[n];//Создание кругового массива
        for (int i = 0; i < n; i++) {
            circA[i] = i + 1;
        }

        int count = -1, countFirst;
        boolean flag = false;
        while (true) {
            countFirst = 0;
            for (int i = 0; i < m; i++) {
                if (count < n-1) count++;
                else count = 0;
                if (countFirst == 0) countFirst = circA[count];
            }
            System.out.print(countFirst);
            if (circA[count] == 1 && flag){
                break;
            }
            else {
                flag = true;
                if (count == 0) count = n - 1;
                else count--;
            }
        }
    }
}
