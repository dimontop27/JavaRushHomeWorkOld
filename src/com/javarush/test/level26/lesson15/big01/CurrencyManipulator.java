package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.*;

public class CurrencyManipulator {

    private String currencyCode;
    private Map<Integer, Integer> denominations = new HashMap<Integer, Integer>() {

    };

    public CurrencyManipulator(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void addAmount(int denomination, int count) {
        int wholeAmount = denominations.get(denomination) != null ? denominations.get(denomination) + count : count;
        denominations.put(denomination, wholeAmount);
    }

    public int getTotalAmount() {
        int totalAmount = 0;
        for (Integer key : denominations.keySet()) {
            totalAmount += key * denominations.get(key);
        }
        return totalAmount;
    }

    public boolean hasMoney() {
        int tmp = 0;
        for (Integer value : denominations.values()) {
            tmp += value; //Only for !0 check
        }
        return tmp != 0;
    }

    public boolean isAmountAvailable(int expectedAmount) {
        return getTotalAmount() >= expectedAmount;
    }

    public Map<Integer, Integer> withdrawAmount(int expectedAmount) throws NotEnoughMoneyException {
        int sum = expectedAmount;
        HashMap<Integer, Integer> tempMap = new HashMap<>();
        tempMap.putAll(denominations);
        ArrayList<Integer> nominals = new ArrayList<>();
        for (Map.Entry<Integer, Integer> pair : tempMap.entrySet()) {
            nominals.add(pair.getKey());
        }
        Collections.sort(nominals);
        Collections.reverse(nominals);

        TreeMap<Integer, Integer> result = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for (Integer aList : nominals) {
            int key = aList;
            int value = tempMap.get(key);
            while (true) {
                if (sum < key || value <= 0) {
                    tempMap.put(key, value);
                    break;
                }
                sum -= key;
                value--;

                if (result.containsKey(key))
                    result.put(key, result.get(key) + 1);
                else result.put(key, 1);
            }
        }
        if (sum > 0)
            throw new NotEnoughMoneyException();
        else {
            for (Map.Entry<Integer, Integer> pair : result.entrySet())
                ConsoleHelper.writeMessage(pair.getKey() + " - " + pair.getValue());

            denominations.clear();
            denominations.putAll(tempMap);
            ConsoleHelper.writeMessage("Transaction done!");
        }
        return result;
    }
}
