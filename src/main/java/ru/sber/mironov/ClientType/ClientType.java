package ru.sber.mironov.ClientType;


import ru.sber.mironov.Clients.Client;
import ru.sber.mironov.Clients.HoldingClient;
import ru.sber.mironov.Clients.IndividualClient;
import ru.sber.mironov.Clients.LegalEntityClient;
import ru.sber.mironov.MyJsonLibrary.MyJsonObject;


import java.util.List;

public enum ClientType {
    INDIVIDUAL("INDIVIDUAL") {
        private List<Object> parseClient(MyJsonObject client) {
            String name = client.getString("name");
            String inn = client.getString("inn");
            return List.of(name, inn);
        }

        public Client createClient(MyJsonObject client) {
            return new IndividualClient(this.parseClient(client));
        }
    },
    LEGAL_ENTITY("LEGAL_ENTITY") {
        private List<Object> parseClient(MyJsonObject client) {
            String name = client.getString("name");
            String inn = client.getString("inn");
            return List.of(name, inn);
        }

        public Client createClient(MyJsonObject client) {
            return new LegalEntityClient(this.parseClient(client));
        }
    },
    HOLDING("HOLDING") {
        List<Object> parseClient(MyJsonObject client) {
            String name = client.getString("name");
            String inn = client.getString("inn");
            return List.of(name, inn);
        }

        public Client createClient(MyJsonObject client) {
            return new HoldingClient(parseClient(client));
        }
    };
    public final String type;

    /*List<Object> parseClient(JSONObject client) {
        String name = client.getString("name");
        String inn = client.getString("inn");
        return List.of(name, inn);
    }*/
    ClientType(String description) {
        this.type = description;
    }

    public abstract Client createClient(MyJsonObject client);
}

