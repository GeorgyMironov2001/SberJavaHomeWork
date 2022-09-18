package ru.sber.mironov.Clients;

import ru.sber.mironov.ClientType.ClientType;

public class Client {
    public final String name;
    public final String inn;
    public final ClientType type;

    public Client(String name, String inn, ClientType type) {
        this.name = name;
        this.inn = inn;
        this.type = type;
    }
    public String toString() {
        return name.toString() + " " + inn.toString() + " " + type.type;
    }
}
