package ru.sber.mironov.Clients;


import ru.sber.mironov.ClientType.ClientType;
import ru.sber.mironov.MyJsonLibrary.MyJsonObject;

public class LegalEntityClient extends Client {

    private final Boolean realLegal;

    public LegalEntityClient(String name, String inn, ClientType type, Boolean realLegal) {
        super(name, inn, type);
        this.realLegal = realLegal;
    }

    public LegalEntityClient(MyJsonObject client) {
        super(client);
        realLegal = Boolean.parseBoolean(client.getString("realLegsl"));
    }

    public Boolean getRealLegal() {
        return realLegal;
    }
}
