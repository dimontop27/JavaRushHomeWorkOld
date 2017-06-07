package com.javarush.test.level18.lesson10.home08;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {
    private static Object lock = new Object();
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        while (!"exit".equals((fileName = console.readLine()))) {
            new ReadThread(fileName).start();
        }
    }

    public static class ReadThread extends Thread {
        private String fileName;

        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут

        @Override
        public void run() {
            try {
                FileInputStream stream = new FileInputStream(fileName);
                List<Integer> byteList = new ArrayList<>();
                while (stream.available() > 0) {
                    byteList.add(stream.read());
                }
                stream.close();

                int curByte;
                Map<Integer, Integer> byteMap = new HashMap<>();
                for (int i = 0; i < byteList.size(); i++) {
                    curByte = byteList.get(i);
                    if (byteMap.containsKey(curByte)) {
                        byteMap.put(curByte, byteMap.get(curByte) + 1);
                    } else {
                        byteMap.put(curByte, 1);
                    }
                }
                int maxByte = 0;
                int maxCount = 0;
                for (Map.Entry<Integer, Integer> pairs : byteMap.entrySet()) {
                    if (pairs.getValue() > maxCount) {
                        maxCount = pairs.getValue();
                        maxByte = pairs.getKey();
                    }
                }
                synchronized (lock) {
                    resultMap.put(fileName, maxByte);
                }
            } catch (IOException e) {

            }
        }
    }
}
