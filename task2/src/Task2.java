import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Task2 {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) args = new String[]{"c://1.txt", "c://2.txt"};
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        String s = reader.readLine();
        String[] words = s.split(" ");//Первая строка файла должена иметь вид: "1 1"
        float xc = Float.parseFloat(words[0]);
        float yc = Float.parseFloat(words[1]);
        float rc = Float.parseFloat(reader.readLine());//Вторая строка файла должена иметь вид: "5"
        reader.close();
        reader = new BufferedReader(new FileReader(args[1]));
        int i = 0;
        while (reader.ready()){
            s = reader.readLine();
            words = s.split(" ");//Строки файла должны иметь вид: "1 1"
            float xd = Float.parseFloat(words[0]);
            float yd = Float.parseFloat(words[1]);
            if (distanse(xc,yc,xd,yd) == rc) System.out.println("0");//точка лежит на окружности
            else if (distanse(xc,yc,xd,yd) > rc) System.out.println("2");//точка снаружи
            else if (distanse(xc,yc,xd,yd) < rc) System.out.println("1");//точка внутри
            i++;
        }
    }
    public static float distanse(float xc, float yc, float xd, float yd){
        float d = (float) Math.sqrt((xc - xd) * (xc - xd) + (yc - yd) * (yc - yd));
        return d;
    }
}
