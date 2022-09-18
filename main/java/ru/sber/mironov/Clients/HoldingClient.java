package ru.sber.mironov.Clients;


import ru.sber.mironov.ClientType.ClientType;

import java.util.List;

public class HoldingClient extends Client {
    public HoldingClient(String name, String inn, ClientType type) {
        super(name, inn, type);
    }

    public HoldingClient(List<Object> client) {
        super((String) client.get(0), (String) client.get(1), ClientType.HOLDING);
    }

}
