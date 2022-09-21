package ru.sber.mironov;

import ru.sber.mironov.ClientsJsonParser.ClientsJsonParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        String[] a = {"1", "2", "3"};
        ArrayList<String> q = new ArrayList<>(List.of(a));


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

        /*String filePath = args[0];
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
        System.out.println(content);

        Pattern pattern = Pattern.compile("\\{.+?}");
        Matcher matcher = pattern.matcher(content);
        ArrayList<String> c = new ArrayList<>();
        while (matcher.find()) {
            c.add(content.substring(matcher.start(), matcher.end()));
            System.out.println(content.substring(matcher.start(), matcher.end()));
        }

        Pattern pattern1 = Pattern.compile("\".+?\":\".+?\"");
        for (var s : c) {
            Matcher matcher1 = pattern1.matcher(s);
            while (matcher1.find()) {
                System.out.println(s.substring(matcher1.start(), matcher1.end()));
                String[] str = s.substring(matcher1.start(), matcher1.end()).split(":");
                for (int i = 0; i < 2; ++i) {
                    str[i] = str[i].substring(1, str[i].length() - 1);
                }
                System.out.println(Arrays.toString(str));
            }
        }*/

        var people = ClientsJsonParser.parseClientsJson((args[0]));
        System.out.println(people);
    }
}


