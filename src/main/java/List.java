
import java.io.*;
import java.util.*;


public class List {
    public static int quant;
    public static int max;
    public static String maxL;

    public static void main(String[] args) {
        String path = "words.txt";
        StringBuilder string = new StringBuilder();
        try (Scanner scan = new Scanner(new File(path))) {
            while (scan.hasNextLine()) {
                string.append(scan.nextLine()).append(" ");
            }
        } catch (FileNotFoundException e) {
            System.out.printf("Файл не существует");
        }

        String[] array = string.toString().split("\\s");

        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        for (String s : array) {
            int count = 0;
            for (var j = 0; j < array.length; j++) {
                if (s.equals(array[j])) {
                    count++;
                    quant = 0;
                    if (quant <= count) {
                        quant = count;
                    }
                }
            }
            if (max < quant) {
                max = quant;
                maxL = s;


        }
            System.out.println(s + " - " + quant + " шт.");
    }
        System.out.println("Самое часто встречающееся слово " + maxL + " встретилось " + max + " раз(а)");
}}

