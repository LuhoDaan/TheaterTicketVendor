/*
public class Main {
    public static void main(String[] args) {
        GUI mynewgui = new GUI();
        TeatroDellaPergola.getInstanceOf();
        TeatroDellaPergola.getInstanceOf().setProgrammazioneDellaSettimana("Le donne di Sandro");
        TeatroDellaPergola.getInstanceOf().setOrarioSpettacoli("9:30");
        BiglietteriaOnline.buy();

    }
}
*/
//////////////////////////////////////////////////
package com.company;

public class Main {
    public static void main(String[] args) throws TeatroNotInitialized {

        try {
            Teatro.setName("TeatroDellaPergola");
            Teatro.setLayoutTeatro(11, 30, new int[]{3, 27}); // inline array declaration
            Teatro teatro = Teatro.getInstanceOf();


            teatro.setProgrammazioneDellaSettimana("Le donne di Sandro");
            teatro.setOrarioSpettacoli("9:30");
            BiglietteriaOnline ticketOne = new BiglietteriaOnline();
            ticketOne.buy();

        } catch (TeatroNotInitialized e) {
            System.err.println("You have not initialized useful information for Teatro");
            e.printStackTrace();
            System.exit(1);
        }


    }
}
