package com.javarush.test.level14.lesson08.bonus01;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

/* Нашествие эксепшенов
Заполни массив exceptions 10 различными эксепшенами.
Первое исключение уже реализовано в методе initExceptions.
*/

public class Solution
{
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args)
    {
        initExceptions();

        for (Exception exception : exceptions)
        {
            System.out.println(exception);
        }
    }

    private static void initExceptions()
    {   //it's first exception
        try //1
        {
            float i = 1 / 0;

        } catch (Exception e)
        {
            exceptions.add(e);
        }

        //Add your code here
        try //2
        {
            String i = "22g1";
            int a = Integer.parseInt(i);

        } catch (Exception e)
        {
            exceptions.add(e);
        }
        try { //3
            FileInputStream file = new FileInputStream("test.exe");
        } catch (Exception e) {
            exceptions.add(e);
        }
        try { //4
            int a[] = {1, 2, 3};
            int b = a[3];
        } catch (Exception e) {
            exceptions.add(e);
        }
        try { //5
            String s = null;
            System.out.println(s.length());
        } catch (Exception e) {
            exceptions.add(e);
        }

                try //6
        {
            String str = "ea";
            char c = str.charAt(0);
            c = str.charAt(40);
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }
        try //7
        {
            int i = -1;
            int[] array = new int[i];
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }
        try //8
        {
            Object i = Integer.valueOf(42);
            String s = (String) i;
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }
        try //9
        {
            Thread d1 = new Thread();
            d1.start();
            d1.start();
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }
        try //10
        {
            Object x[] = new String[3];
            x[0] = new Integer(10);
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }




    }
}
