package ru.sber.mironov;

import ru.sber.mironov.ClientsJsonParser.ClientsJsonParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        /*String[] a = {"1", "2", "3"};
        ArrayList<String> q = new ArrayList<>(List.of(a));*/
        String fileName = "src/main/resources/Clients.json";
        System.out.println(ClientsJsonParser.parseClientsJson(fileName));

        /*String s = "[\n" +
                "  {\n" +
                "    \"ClientType\": \"INDIVIDUAL\",\n" +
                "    \"inn\": \"1688\",\n" +
                "    \"name\": \"Alex\",\n" +
                "    \"salary\": \"100\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"ClientType\": \"LEGAL_ENTITY\",\n" +
                "    \"name\": \"Vadim\",\n" +
                "    \"inn\": \"1432\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"ClientType\": \"HOLDING\",\n" +
                "    \"name\": \"Gera\",\n" +
                "    \"inn\": \"2001\"\n" +
                "  }\n" +
                "]";
        String str = "{ { { {";
        Pattern p = Pattern.compile("\\{(\\s.+)+?}");
        Matcher m = p.matcher(s);
        while (m.find()) {
            System.out.println(s.substring(m.start(), m.end()));
        }*/
        /*var people = ClientsJsonParser.parseClientsJson((args[0]));
        System.out.println(people);*/




    }
}


