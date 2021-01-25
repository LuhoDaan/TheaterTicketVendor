package com.company;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.*;


public class BiglietteriaOnlineTest {

    //Testa prendendo il posto [0,29] come campione se effettivamente
    // la variabile boolean IsNotReserved diventa false
    @Test
    public void ReserveASeatTeast() {
        BiglietteriaInLoco biglietteriaInLoco = new BiglietteriaInLoco(1.0);
        Teatro.setLayoutTeatro(11, 30, new int[]{3, 27});
        Teatro.setName("prova");
        try {
            biglietteriaInLoco.buy();
            assertFalse(Teatro.getInstanceOf().getSeat(0, 29).isSeatAvailable());


        } catch (TeatroNotInitialized td) {
            System.out.println("ERROR, TEATRO NOT INITIALIZED");

        }

    }

    // Testa che effettivamente lo sconto venga applicato
    // utilizzando un posto platea a campione
    @Test
    public void testApplicaSconto() {
        Platea platea = new Platea();
        BiglietteriaOnline biglietteriaOnline = new BiglietteriaOnline();
        RegularTicket regularTicket = new RegularTicket(platea.returnPriceOfTheSeat());
        Double price = biglietteriaOnline.applicaSconto(regularTicket).getPrezzoBiglietto();
        assertEquals((Double) 14.0, price);
    }


    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void TeatroNotInitializedIsThrown() {
        exception.expect(TeatroNotInitialized.class);


    }
}
