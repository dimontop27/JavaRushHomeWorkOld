package com.javarush.test.level15.lesson09.task01;

import java.util.HashMap;
import java.util.Map;

/* Статики 1
В статическом блоке инициализировать labels 5 различными парами.
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();
    static{
        labels.put(228.00, "label1");
        labels.put(282.00, "label1");
        labels.put(422.00, "label1");
        labels.put(222.00, "label1");
        labels.put(212.00, "label1");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
