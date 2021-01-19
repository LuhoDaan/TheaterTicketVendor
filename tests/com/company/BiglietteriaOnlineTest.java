package com.company;

import org.junit.Test;


import static org.junit.Assert.*;



public class BiglietteriaOnlineTest {

    @Test
    public void triyngToBuyAReservedSeat() {


    }

    @Test //come fare per testare del codice che riceve input dall'utente?
    public void testApplicaSconto() {
        Platea platea = new Platea();
        RegularTicket regularTicket = new RegularTicket(platea.returnPriceOfTheSeat());
        Ticket ticket = BiglietteriaOnline.applicaSconto(regularTicket);
        assertEquals("14.0",ticket.getPrezzoBiglietto());


    }
}