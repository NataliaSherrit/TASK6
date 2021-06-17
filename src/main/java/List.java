import java.io.*;
import java.util.*;
import java.util.HashMap;


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
            return;
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
        }
        HashMap<String,Integer> keyValue = new HashMap<>();

        for (int i=0; i<= array.length-1; i++) {
            int counter = 0;
            if (keyValue.containsKey(array[i])) {
                counter = keyValue.get(array[i]);
                keyValue.put(array[i], counter + 1);
            } else {
                keyValue.put(array[i], 1);
            }
            quant = 0;

            for (int value : keyValue.values()) {
                if (value > quant) {
                    quant = value;
                }
            }
        }
        System.out.println("Слова в файле встречаются с такой частотой: " + keyValue);
        System.out.println("Самое часто встречающееся слово " + maxL + " встретилось " + max + " раз(а)");

    }

}

