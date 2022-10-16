package ru.sber.mironov.MyJsonLibrary;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyJsonObject {
    private final Map<String, String> map;

    public MyJsonObject(Map<String, String> map) {
        this.map = map;
    }

    public MyJsonObject(String str) {
        Map<String, String> newMap = new HashMap<>();
        String[] strings = str.split(",");
        for (var s : strings) {
            String[] splitString = s.replace("\s", "")
                    .replace("{", "")
                    .replace("}", "")
                    .replace("\"", "")
                    .replace(",", "")
                    .replaceAll("[ \\f\\n\\r\\t\\v]", "")
                    .split(":");
            newMap.put(splitString[0], splitString[1]);
        }
        map = newMap;
    }

    public String getString(String key) {
        return map.get(key);
    }
}
