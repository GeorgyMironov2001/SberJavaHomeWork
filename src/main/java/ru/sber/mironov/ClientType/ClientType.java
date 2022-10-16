package ru.sber.mironov.ClientType;


import ru.sber.mironov.Clients.Client;
import ru.sber.mironov.Clients.HoldingClient;
import ru.sber.mironov.Clients.IndividualClient;
import ru.sber.mironov.Clients.LegalEntityClient;
import ru.sber.mironov.MyJsonLibrary.MyJsonObject;


import java.util.HashMap;
import java.util.List;

public enum ClientType {
    INDIVIDUAL {
        public Client createClient(MyJsonObject client) {
            return new IndividualClient(client);
        }
    },
    LEGAL_ENTITY {
        public Client createClient(MyJsonObject client) {
            return new LegalEntityClient(client);
        }
    },
    HOLDING {
        public Client createClient(MyJsonObject client) {
            return new HoldingClient(client);
        }
    };

    public abstract Client createClient(MyJsonObject client);
}

