package com.company;
public class RegularTicket extends Ticket{
    public RegularTicket(Double prezzo){
        this.ticketName = "SimpleTicket";
        setPrezzoBiglietto(prezzo);

    }

    @Override
    public Double getPrezzoBiglietto() {
       return this.prezzoBiglietto;

    }
}
