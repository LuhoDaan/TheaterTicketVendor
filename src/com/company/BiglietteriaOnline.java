package com.company;
import java.util.Scanner;

public class BiglietteriaOnline implements Biglietteria {


    public Ticket buy() throws TeatroNotInitialized {
        //Acquisisco prima i dati dell utente
        Scanner scanRow = new Scanner(System.in);
        System.out.println("In che fila vorresti sederti ?");
        int row = scanRow.nextInt();
        Scanner scanColumn = new Scanner(System.in);
        System.out.println("A che distanza dal Palcoscenico vuoi stare ?");
        int column = scanColumn.nextInt();

        //procedo all'acquisto vero e proprio
        BiglietteriaOnline biglietteriax = new BiglietteriaOnline();//questo passaggio dove creo un'altra biglietteria non mi torna molto
        Double spesa = Teatro.getSeat(row, column).accept(biglietteriax);
        if (Teatro.getSeat(row, column).isSeatAvailable()) {
            Teatro.getSeat(row, column).reserveSeat();
        } else {
            System.out.println("Ci dispiace, ma il posto richiesto è già prenotato");
            buy();
        }

        RegularTicket bigliettoProvvisorio = new RegularTicket(spesa);
        Ticket bigliettoEmesso = applicaSconto(bigliettoProvvisorio);

        BigliettoGrafica graph = new BigliettoGrafica();
        graph.setBasics(bigliettoEmesso);
        graph.setId(Teatro.getSeat(row, column));
        graph.setPosto(row,column);
        graph.setOrario(Teatro.getInstanceOf().getOrarioSpettacoli());
        graph.setProgrammazione(Teatro.getInstanceOf().getProgrammazioneDellaSettimana());
        graph.showGui();

        return bigliettoEmesso;
    }

    public Ticket applicaSconto(Ticket ticket) {
        Ticket newticket = ticket;
        Scanner scanSconto = new Scanner(System.in);
        System.out.println("Puoi applicare Sconto studenti?");
        String risposta = scanSconto.nextLine();
        if (risposta.equals("si")) {
            newticket = new StudenteTicket(ticket);
        }
        Scanner scanSconto1 = new Scanner(System.in);
        System.out.println("Puoi applicare Sconto Coop?");
        String risposta1 = scanSconto.nextLine();
        if (risposta1.equals("si")) {
            newticket = new CoopTicket(newticket);
        }
        Scanner scanSconto2 = new Scanner(System.in);
        System.out.println("Puoi applicare Sconto musei fiorentini?");
        String risposta2 = scanSconto.nextLine();
        if (risposta2.equals("si")) {
            newticket = new MuseiFiorentiniTicket(newticket);
        }
        return newticket;

    }

    @Override
    public Double visit(Palco postoPalco) {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Inserire il numero di mesi per i quali si vuole prenotare il palco: ");
        int mesi = myObj.nextInt();
        return postoPalco.returnPriceOfTheSeat() * mesi;
    }

    @Override
    public Double visit(Platea postoPlatea) {
        return postoPlatea.returnPriceOfTheSeat();
    }
}
