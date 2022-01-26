package irina;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = null;
        try {
            File file = new File("array.txt");

            if (!file.exists()) {
                file.createNewFile();
            }

            PrintWriter pw = new PrintWriter(file);
            int[] nums = new int[]{1, 10, 2, 9};
            pw.close();

            br = new BufferedReader(new FileReader("array.txt"));
            String line;
            while ((line = br.readLine()) != null){
                System.out.println(line);
            }

            //нахождение максимума в массиве
            int maxValue = nums[0];
            for(int i = 1; i < nums.length; i++) {
                if(nums[i] > maxValue) {
                    maxValue = nums[i];
                }
            }

            //нахождение минимума в массиве
            int minValue = nums[0];
            for(int i = 1; i < nums.length; i++) {
                if(nums[i] < minValue) {
                    minValue = nums[i];
                }
            }

            int[] b = new int[nums.length];
            int a = Math.abs((maxValue + minValue) / 2);
            for (int i = 0; i < nums.length; i++) {
                b[i] = Math.abs(a - nums[i]);
            }

            int bmin = b[0];
            int k = 0;
            for (int i = 0; i < nums.length; i++) {
                if (b[i] < bmin) {
                    bmin = b[i];
                    k = nums[i];
                }
            }

            int[] c = new int[nums.length];
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                c[i] = Math.abs(k - nums[i]);
                sum += c[i];
            }

            //минимальное количество ходов
            System.out.println(sum);

        } catch (IOException e) {
            System.err.println("Error " + e);
        } finally {
            br.close();
        }
    }
}
