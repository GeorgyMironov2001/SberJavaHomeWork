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
        BufferedReader reader = new BufferedReader(
                new FileReader(filePath));
        char[] buf = new char[1024];
        int numRead = 0;
        while ((numRead = reader.read(buf)) != -1) {
            String readData = String.valueOf(buf, 0, numRead);
            fileData.append(readData);
        }
        reader.close();
        String content = fileData.toString();
        MyJsonArray clients = new MyJsonArray(content);
        //System.out.println(clients);
        ArrayList<Client> people = new ArrayList<>();
        for (var o : clients) {
            //System.out.println(o);
            //System.out.println(o.toString());
            //JSONObject x = new JSONObject(o);
            //System.out.println(((JSONObject) o).getString("ClientType"));
            ClientType ct = ClientType.valueOf(o.getString("ClientType"));
            //System.out.println(ct.type);
            people.add(ct.createClient(o));
        }
        return people;
    }
}
