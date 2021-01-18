package com.company;

import java.util.Scanner;

public class BiglietteriaInLoco implements Biglietteria{
    Double costiExtraOperatore ;

    public BiglietteriaInLoco(Double costiOperatore){
        setCostiExtraOperatore(costiOperatore);
    }


    public void setCostiExtraOperatore(Double costiExtraOperatore) {
        this.costiExtraOperatore = costiExtraOperatore;
    }

    public static void buy() throws TeatroNotInitialized {
        //Acquisisco prima i dati dell utente
        Scanner scanRow = new Scanner(System.in);
        System.out.println("Selezionare la fila (0-10) :");
        int row = scanRow.nextInt();
        Scanner scanColumn = new Scanner(System.in);
        System.out.println("Selezionare il posto (0-29) :");
        int column = scanColumn.nextInt();

        //procedo all'acquisto vero e proprio
        BiglietteriaInLoco biglietteriax = new BiglietteriaInLoco(1.25);
        //questo passaggio dove
        // creo un'altra biglietteria non mi torna molto
        //NON SONO TANTO CONVINTO DEL SETTARE QUA DENTRO AL METODO I COSTIOPERATORE;

        try {


            if (Teatro.getSeat(row, column).isSeatAvailable()) {

                Teatro.getSeat(row, column).reserveSeat();

                Double spesa = Teatro.getSeat(row, column).accept(biglietteriax);

                RegularTicket bigliettoProvvisorio = new RegularTicket(spesa);
                Ticket bigliettoEmesso = applicaSconto(bigliettoProvvisorio);

                BigliettoGrafica graph = new BigliettoGrafica();
                graph.setBasics(bigliettoEmesso);
                graph.setId(Teatro.getSeat(row, column));
                graph.setPosto(row, column);
                graph.setOrario(Teatro.getInstanceOf().getOrarioSpettacoli());
                graph.setProgrammazione(Teatro.getInstanceOf().getProgrammazioneDellaSettimana());
                graph.showGui();


            }
            else {
                System.out.println("Ci dispiace, ma il posto richiesto è già prenotato");
                buy();
            }
        }
        catch (ArrayIndexOutOfBoundsException ex){
            System.out.println("IL POSTO SELEZIONATO NON ESISTE, FARE ATTENZIONE" +
                    "A SCEGLIERE UN POSTO COMPRESO TRA FILA 0-11 E SEDIA 0-30");
            buy();
        }
    }


    public static Ticket applicaSconto(Ticket ticket) {
        Ticket newticket = ticket;
        Scanner scanSconto = new Scanner(System.in);
        System.out.println("Puoi applicare Sconto studenti?");
        String risposta = scanSconto.nextLine();
        if (risposta.equals("si")) {
            newticket = new StudenteTicket(ticket);
        }
        scanSconto = new Scanner(System.in);
        System.out.println("Puoi applicare Sconto Coop?");
        String risposta1 = scanSconto.nextLine();
        if (risposta1.equals("si")) {
            newticket = new CoopTicket(newticket);
        }
        scanSconto = new Scanner(System.in);
        System.out.println("Puoi applicare Sconto musei fiorentini?");
        String risposta2 = scanSconto.nextLine();
        if (risposta2.equals("si")) {
            newticket = new MuseiFiorentiniTicket(newticket);
        }
        return newticket;

    }

    @Override
    public Double visit(Palco postoPalco) {
        Double price;

        Scanner myObj = new Scanner(System.in);
        System.out.println("Inserire il numero di mesi per i quali si vuole prenotare il palco: ");
        int mesi = myObj.nextInt();
        if (mesi < 1) {
            System.out.println("ATTENZIONE PRENOTAZIONE MINIMA 1 MESE");
            price = visit(postoPalco);
        } else {
            price = postoPalco.returnPriceOfTheSeat() * mesi*costiExtraOperatore;
        }
        return price;
    }

    @Override
    public Double visit(Platea postoPlatea) {

        return postoPlatea.returnPriceOfTheSeat()*costiExtraOperatore;
    }
}
