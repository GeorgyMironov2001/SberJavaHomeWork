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
        Pattern pattern = Pattern.compile("\".+?\":\".+?\"");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            String[] s = str.substring(matcher.start(), matcher.end()).split(":");
            for(int i = 0; i < 2; ++i) {
                s[i] = s[i].substring(1, s[i].length()-1);
            }

            newMap.put(s[0], s[1]);
        }
        map = newMap;
    }

    public String getString(String key) {
        return map.get(key);
    }
}
