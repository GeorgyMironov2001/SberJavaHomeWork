package ru.sber.mironov.MyJsonLibrary;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyJsonArray implements Iterable<MyJsonObject> {
    ArrayList<MyJsonObject> jsonObjects;

    public MyJsonArray(String content) {
        ArrayList<MyJsonObject> clients = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\{.+?}");
        Matcher matcher = pattern.matcher(content);

        while (matcher.find()) {
            clients.add(new MyJsonObject(content.substring(matcher.start(), matcher.end())));
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
}
