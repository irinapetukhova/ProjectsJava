package irina;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br1 = null;
        BufferedReader br2 = null;
        try {
            File file1 = new File("file1.txt");
            File file2 = new File("file2.txt");

            if (!file1.exists() && !file2.exists()) {
                file1.createNewFile();
                file2.createNewFile();
            }

            float a = 1;
            float b = 1;
            float r = 5;

            float x = 0;
            float y = 0;

            PrintWriter pw1 = new PrintWriter(file1);
            pw1.print(a + " ");    //координата центра
            pw1.println(b);    //координата центра
            pw1.print(r);  //радиус
            pw1.close(); //закрытие файла

            PrintWriter pw2 = new PrintWriter(file2);
            pw2.print(x + " ");    //координата точки
            pw2.print(y);    //координата точки
            pw2.close(); //закрытие файла

            br1 = new BufferedReader(new FileReader("file1.txt"));
            br2 = new BufferedReader(new FileReader("file2.txt"));
            String line1;
            String line2;
            while ((line1 = br1.readLine()) != null){
                System.out.println(line1);
            }
            while ((line2 = br2.readLine()) != null){
                System.out.println(line2);
            }

            double k = (Math.pow((x - a), 2) + Math.pow((y - b), 2));
            double s = Math.pow(r, 2);
            if (k == s) {
                System.out.println("0"); //точка лежит на окружности
            } else if (k < s) {
                System.out.println("1"); //точка внутри
            } else {
                System.out.println("2"); //точка снаружи
            }

        } catch (IOException e) {
            System.err.println("Error " + e);
        } finally {
            br1.close();
            br2.close();
        }
    }
}
