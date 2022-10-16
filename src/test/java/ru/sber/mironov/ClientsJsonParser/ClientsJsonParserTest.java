package ru.sber.mironov.ClientsJsonParser;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.sber.mironov.ClientType.ClientType;
import ru.sber.mironov.Clients.Client;
import ru.sber.mironov.Clients.HoldingClient;
import ru.sber.mironov.Clients.IndividualClient;
import ru.sber.mironov.Clients.LegalEntityClient;

import java.io.IOException;
import java.util.ArrayList;


public class ClientsJsonParserTest {
    private ArrayList<Client> people;

    @Before
    public void setUpPeople() throws IOException {
        String fileName = "src/test/resources/Clients.json";

        people = ClientsJsonParser.parseClientsJson(fileName);
    }

    @After
    public void tearDown() {
        people.clear();
    }

    @Test
    public void parseClientsJson() {
        Assert.assertEquals(this.people.get(0).getName(), "Alex");
        Assert.assertEquals(this.people.get(0).getInn(), "1688");
        Assert.assertEquals(this.people.get(0).getType(), ClientType.INDIVIDUAL);
        Assert.assertEquals(((IndividualClient) people.get(0)).getSalary(), 100);
        Assert.assertEquals(((LegalEntityClient) people.get(1)).getRealLegal(), false);
        assert (((HoldingClient) people.get(2)).getLevel() == 34.5);
    }
}