package ru.sber.mironov.ClientsJsonParser;

import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import ru.sber.mironov.ClientType.ClientType;
import ru.sber.mironov.Clients.Client;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ClientsJsonParser {
    public static ArrayList<Client> parseClientsJson(File file) throws IOException {
        String content = FileUtils.readFileToString(file, "utf-8");
        JSONArray clients = new JSONArray(content);
        //System.out.println(clients);
        ArrayList<Client> people = new ArrayList<>();
        for (var o : clients) {
            //System.out.println(o);
            //System.out.println(o.toString());
            //JSONObject x = new JSONObject(o);
            //System.out.println(((JSONObject) o).getString("ClientType"));
            ClientType ct = ClientType.valueOf(((JSONObject) o).getString("ClientType"));
            //System.out.println(ct.type);
            people.add(ct.createClient((JSONObject) o));
        }
        return people;
    }
}
