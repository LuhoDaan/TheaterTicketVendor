package com.company;
public class StudenteTicket extends ExtraScontoTicket {

    public StudenteTicket(Ticket ticket){
        this.ticket = ticket;
        this.ticketName = " Studente /";
        this.prezzoBiglietto =  - 4.0;
    }
    @Override
    public Double getPrezzoBiglietto() {
        return ticket.getPrezzoBiglietto() + this.prezzoBiglietto;
    }

    @Override
    public String getTicketName() {

        return ticket.getTicketName() + this.ticketName;
    }
}
