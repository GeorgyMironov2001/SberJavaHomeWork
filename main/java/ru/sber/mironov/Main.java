package ru.sber.mironov;

import netscape.javascript.JSObject;
import org.json.JSONArray;
import org.json.JSONObject;
import ru.sber.mironov.ClientType.ClientType;
import ru.sber.mironov.Clients.Client;
import ru.sber.mironov.Clients.HoldingClient;
import ru.sber.mironov.Clients.IndividualClient;
import ru.sber.mironov.Clients.LegalEntityClient;
import ru.sber.mironov.ClientsJsonParser.ClientsJsonParser;

import org.apache.commons.io.FileUtils;
import org.json.JSONObject;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        //ArrayList<Client> clients = (ArrayList<Client>) List.of(new IndividualClient("Alex", "1688", ClientType.INDIVIDUAL),
        //        new LegalEntityClient("Vadim", "1432", ClientType.LEGAL_ENTITY),
        //        new HoldingClient("Gera", "2001", ClientType.HOLDING));
        /*JSONObject first = new JSONObject();
        JSONObject second = new JSONObject();
        JSONObject third = new JSONObject();

        first.put("name", "Alex");
        first.put("inn", "1688");
        first.put("ClientType", ClientType.INDIVIDUAL);

        second.put("name", "Vadim");
        second.put("inn", "1432");
        second.put("ClientType", ClientType.LEGAL_ENTITY);

        third.put("name", "Gera");
        third.put("inn", "2001");
        third.put("ClientType", ClientType.HOLDING);

        JSONArray arr = new JSONArray();
        arr.put(first);
        arr.put(second);
        arr.put(third);*/
        //Files.writeString(Paths.get("src/main/resources/Clients.json"), arr.toString());

        File file = new File(args[0]);
        var people = ClientsJsonParser.parseClientsJson(file);
        for (Client x : people) {
            System.out.println(x);
        }

    }
}


