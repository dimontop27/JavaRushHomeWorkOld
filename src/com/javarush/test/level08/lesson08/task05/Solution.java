package com.javarush.test.level08.lesson08.task05;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        //напишите тут ваш код
        HashMap<String,String>m= new HashMap<String, String>();
        m.put("Гулаева", "Анна");
        m.put("Смердяков", "Алексей");
        m.put("Попова", "Анна");
        m.put("Попович", "Иван");
        m.put("Пенькова", "Мария");
        m.put("Пеньков", "Алёна");
        m.put("Вострецова", "Анна");
        m.put("Попов", "Алексей");
        m.put("Звягин", "Алексей");
        m.put("Долгушина", "Юлия");

        return m;

    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
    {
        //напишите тут ваш код
        HashMap<String, String> map1 = new HashMap<String, String>(map);
        HashSet<String> map2 = new HashSet<String>();
        for(String f: map1.values()) {
            if (map2.contains(f)) {
                removeItemFromMapByValue(map, f);
            } else
                map2.add(f);
        }

    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair: copy.entrySet())
        {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }
}
