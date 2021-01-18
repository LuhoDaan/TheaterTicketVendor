package com.company;
import javax.swing.*;
import java.awt.*;


public class BigliettoGrafica {
    JPanel panel;
    JFrame biglietto;
    JLabel basics, id, posto, orario, programmazione;
    JLabel immagine = new JLabel(new ImageIcon("teatroperg.png"));

    public BigliettoGrafica() {
        panel = new JPanel();
        biglietto = new JFrame("Biglietto Emesso");
        biglietto.setSize(500,550);
        biglietto.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        biglietto.add(panel);

        immagine.setBounds(10,300,300,300);
        panel.add(immagine);




        panel.setLayout(null);

    }
    public void showGui(){
        biglietto.setVisible(true);
    }



    public void setBasics(Ticket ticket) {
        this.basics = new JLabel(ticket.toString());
        basics.setFont(new Font("Arial", Font.ITALIC, 14));
        this.basics.setBounds(10,20,700,25);
        panel.add(this.basics);
    }

    public void setId(Seat seat) {
        this.id = new JLabel("Identificativo Biglietto: " + seat);
        this.id.setBounds(10,60,400,25);
        panel.add(this.id);
    }

    public void setPosto(int row, int column) {
        this.posto = new JLabel("Fila " + row + "  " + "Posto " + column);
        this.posto.setBounds(10,100,400,25);
        panel.add(this.posto);
    }

    public void setOrario(String string) {
        this.orario = new JLabel("Orario dello Spettacolo: " + string);
        this.orario.setBounds(10,140,400,25);
        panel.add(this.orario);
    }

    public void setProgrammazione(String string) {
        this.programmazione = new JLabel((" Programmazione di stasera: " + string));
        this.programmazione.setBounds(10,180,400,25);
        panel.add(this.programmazione);
    }
}
