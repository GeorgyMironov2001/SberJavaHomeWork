package ru.sber.mironov.Clients;


import ru.sber.mironov.ClientType.ClientType;


import java.util.List;

public class IndividualClient extends Client {

    public IndividualClient(String name, String inn, ClientType type) {
        super(name, inn, type);
    }

    public IndividualClient(String description) {
        super("Gera", "1688", ClientType.INDIVIDUAL);
    }

    public IndividualClient(List<Object> client) {
        super((String)client.get(0), (String)client.get(1), ClientType.INDIVIDUAL);
    }

}
