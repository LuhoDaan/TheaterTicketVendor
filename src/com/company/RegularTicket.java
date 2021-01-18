package com.company;
public class RegularTicket extends Ticket{
    public RegularTicket(Double prezzo){
        this.ticketName = "SimpleTicket";
        this.ticketNumber = generateTicketNumber();
        setPrezzoBiglietto(prezzo);

    }

    @Override
    public Double getPrezzoBiglietto() {
       return this.prezzoBiglietto;

    }
}
