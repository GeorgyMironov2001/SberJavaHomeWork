package ru.sber.mironov.MyJsonLibrary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyJsonArray implements Iterable<MyJsonObject> {
    ArrayList<MyJsonObject> jsonObjects;

    public MyJsonArray(String content) {
        ArrayList<MyJsonObject> clients = new ArrayList<>();
        for (var x : getSubstrings(content)) {
            clients.add(new MyJsonObject(content.substring(x.get(0), x.get(1))));
        }
        jsonObjects = clients;
    }

    @Override
    public Iterator<MyJsonObject> iterator() {
        return jsonObjects.iterator();
    }

    @Override
    public void forEach(Consumer<? super MyJsonObject> action) {
        jsonObjects.forEach(action);
    }

    private ArrayList<ArrayList<Integer>> getSubstrings(String content) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int prev = 0;
        int now = 0;
        for (int i = 0; i < content.length(); i++) {
            if (content.charAt(i) == '{') {
                prev = i;
            } else if (content.charAt(i) == '}') {
                now = i + 1;
                res.add(new ArrayList<>(List.of(prev, now)));
            }
        }
        return res;
    }
}
