package ru.sber.mironov.ClientsJsonParser;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.Assert;
import ru.sber.mironov.ClientType.ClientType;
import ru.sber.mironov.Clients.Client;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class ClientsJsonParserTest {
    private ArrayList<Client> people;

    @Before
    public void setUpPeople() throws IOException {
        String fileName = "./src/test/resources/Clients.json";
        File file = new File(fileName);
        people = ClientsJsonParser.parseClientsJson(file);
    }

    @After
    public void tearDown() {
        people.clear();
    }

    @Test
    public void parseClientsJson() {
        Assert.assertEquals(this.people.get(0).name, "Alex");
        Assert.assertEquals(this.people.get(0).inn, "1688");
        Assert.assertEquals(this.people.get(0).type, ClientType.INDIVIDUAL);
    }
}