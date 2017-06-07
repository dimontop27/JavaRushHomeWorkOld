package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        List<Long> result = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();

        Scanner scanner = new Scanner(new File(fileName1));
        while (scanner.hasNextDouble()){
            result.add(Math.round(scanner.nextDouble()));
        }
        BufferedWriter os = new BufferedWriter(new FileWriter(fileName2));
        String tmp = "";
        for (Long s : result)
            tmp = tmp + s + " ";
        os.write(tmp);

        reader.close();
        scanner.close();
        os.flush();
        os.close();
    }
}
