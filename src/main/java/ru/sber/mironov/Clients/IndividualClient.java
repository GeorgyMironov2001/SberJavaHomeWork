package ru.sber.mironov.Clients;


import ru.sber.mironov.ClientType.ClientType;
import ru.sber.mironov.MyJsonLibrary.MyJsonObject;


import java.util.HashMap;

public class IndividualClient extends Client {
    private final int salary;

    public IndividualClient(String name, String inn, ClientType type, int salary) {
        super(name, inn, type);
        this.salary = salary;
    }

    public IndividualClient(MyJsonObject client) {
        super(client);
        this.salary = Integer.parseInt(client.getString("salary"));
    }

    public int getSalary() {
        return salary;
    }
}
