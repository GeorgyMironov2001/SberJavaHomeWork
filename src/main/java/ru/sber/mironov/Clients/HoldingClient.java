package ru.sber.mironov.Clients;


import ru.sber.mironov.MyJsonLibrary.MyJsonObject;

public class HoldingClient extends Client {
    private final double level;

    public HoldingClient(MyJsonObject client) {
        super(client);
        level = Double.parseDouble(client.getString("level"));
    }

    public double getLevel() {
        return level;
    }
}
