package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputPath = br.readLine();
        br.close();
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputPath)));
        int newId = 0;
        String line;

        while (true) {
            line = reader.readLine();
            if (line == null) break;
            if (newId < Integer.parseInt(line.substring(0, 8).trim()))
                newId =Integer.parseInt(line.substring(0,8).trim());
        }
        newId++;
        String quantity = args[args.length-1];
        String price = args[args.length-2];
        String productName = args[1]+" ";
        for (int i = 2; i <args.length-2; i++){
            productName = productName +args[i]+" ";
        }
        reader.close();
        String f = String.format("%-8.8s%-30.30s%-8.8s%-4.4s", newId, productName, price, quantity);
        BufferedWriter bufferedWriter =new BufferedWriter(new FileWriter(inputPath,true));
        if (args[0].equals("-c")){
            bufferedWriter.write(f);
        }else return;
        bufferedWriter.close();
    }
}

