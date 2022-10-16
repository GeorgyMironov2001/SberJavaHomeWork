package ru.sber.mironov.Clients;

import ru.sber.mironov.ClientType.ClientType;
import ru.sber.mironov.MyJsonLibrary.MyJsonObject;

import java.util.HashMap;

public class Client {
    private final String name;
    private final String inn;
    private final ClientType type;

    public Client(String name, String inn, ClientType type) {
        this.name = name;
        this.inn = inn;
        this.type = type;
    }

    public Client(MyJsonObject client) {
        this.name = (String) client.getString("name");
        this.inn = (String) client.getString("inn");
        this.type = ClientType.valueOf(client.getString("ClientType"));
    }

    public String toString() {
        return name.toString() + " " + inn.toString() + " " + type;
    }

    public String getName() {
        return name;
    }

    public String getInn() {
        return inn;
    }

    public ClientType getType() {
        return type;
    }
}
