package ru.sber.mironov.ClientsJsonParser;


import ru.sber.mironov.ClientType.ClientType;
import ru.sber.mironov.Clients.Client;
import ru.sber.mironov.MyJsonLibrary.MyJsonArray;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ClientsJsonParser {
    public static ArrayList<Client> parseClientsJson(String filePath) throws IOException {
        StringBuilder fileData = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            char[] buf = new char[1024];
            int numRead;
            while ((numRead = reader.read(buf)) != -1) {
                String readData = String.valueOf(buf, 0, numRead);
                fileData.append(readData);
            }
        }
        String content = fileData.toString();
        MyJsonArray clients = new MyJsonArray(content);

        ArrayList<Client> people = new ArrayList<>();
        for (var o : clients) {
            ClientType ct = ClientType.valueOf(o.getString("ClientType"));
            people.add(ct.createClient(o));
        }
        return people;
    }
}
