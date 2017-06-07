package com.javarush.test.level22.lesson13.task02;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;

/* Смена кодировки
В метод main первым параметром приходит имя файла, тело которого в кодировке Windows-1251.
В метод main вторым параметром приходит имя файла, в который необходимо записать содержимое первого файла в кодировке UTF-8.
*/
public class Solution {
    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing

    public static void main(String[] args) throws IOException {
        Charset utf8 = Charset.forName("UTF-8");
        Charset windows1251 = Charset.forName("Windows-1251");
        FileInputStream inputStream = new FileInputStream(args[0]);
        FileOutputStream outputStream = new FileOutputStream(args[1]);
        byte[]buffer = new byte[inputStream.available()];
        inputStream.read(buffer);
        String s = new String(buffer, utf8);
        buffer = s.getBytes(windows1251);
        outputStream.write(buffer);
    }
}

/*
Charset koi8 = Charset.forName("KOI8-R");
Charset windows1251 = Charset.forName("Windows-1251");
byte[] buffer = new byte[1000];
inputStream.read(buffer);
String s = new String(buffer, koi8);
buffer = s.getBytes(windows1251);
outputStream.write(buffer);


        FileInputStream inputStream=new FileInputStream(args[0]);
        FileOutputStream outputStream=new FileOutputStream(args[1]);
        byte[] buff=new byte[inputStream.available()];
        inputStream.read(buff);
        String s= new String(buff, "UTF-8");
        outputStream.write(s.getBytes("Windows-1251"));
        inputStream.close();
        outputStream.close();




        FileInputStream in = new FileInputStream(args[0]);
        FileOutputStream out = new FileOutputStream(args[1]);
        byte[] buf = new byte[in.available()];
        Charset windows = Charset.forName("Windows-1251");
        Charset utf = Charset.forName("UTF-8");
        in.read(buf);
        String s = new String(buf, "UTF-8");
        out.write(s.getBytes("Windows-1251"));
        in.close();
        out.close();
 */