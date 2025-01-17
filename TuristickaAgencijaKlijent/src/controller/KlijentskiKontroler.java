/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import domain.Destinacija;
import domain.Klijent;
import domain.Nacionalnost;
import domain.Rezervacija;
import domain.TuristickaAgencija;
import domain.VrstaUsluge;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import session.Session;
import transfer.Odgovor;
import transfer.Zahtev;
import transfer.util.Operacije;
import transfer.util.Status;

/**
 *
 * @author Lenovo
 */
public class KlijentskiKontroler {
    
    private static KlijentskiKontroler instance;

    private KlijentskiKontroler() {
    }

    public static KlijentskiKontroler getInstance() {
        if (instance == null) {
            instance = new KlijentskiKontroler();
        }
        return instance;
    }

    public TuristickaAgencija login(TuristickaAgencija agencija) throws Exception {
        return (TuristickaAgencija) sendRequest(Operacije.LOGIN, agencija);
    }
    
    public void logout(TuristickaAgencija ulogovana) throws Exception {
        sendRequest(Operacije.LOGOUT, ulogovana);
    }

    public void addKlijent(Klijent klijent) throws Exception {
        sendRequest(Operacije.ADD_KLIJENT, klijent);
    }

    public void addRezervacija(Rezervacija rezervacija) throws Exception {
        sendRequest(Operacije.ADD_REZERVACIJA, rezervacija);
    }

    public void deleteKlijent(Klijent klijent) throws Exception {
        sendRequest(Operacije.DELETE_KLIJENT, klijent);
    }

    public void deleteRezervacija(Rezervacija rezervacija) throws Exception {
        sendRequest(Operacije.DELETE_REZERVACIJA, rezervacija);
    }

    public void updateKlijent(Klijent klijent) throws Exception {
        sendRequest(Operacije.UPDATE_KLIJENT, klijent);
    }

    public void updateRezervacija(Rezervacija rezervacija) throws Exception {
        sendRequest(Operacije.UPDATE_REZERVACIJA, rezervacija);
    }

    public ArrayList<Klijent> getAllKlijent() throws Exception {
        return (ArrayList<Klijent>) sendRequest(Operacije.GET_ALL_KLIJENT, null);
    }

    public ArrayList<Rezervacija> getAllRezervacija() throws Exception {
        return (ArrayList<Rezervacija>) sendRequest(Operacije.GET_ALL_REZERVACIJA, null);
    }

    public ArrayList<VrstaUsluge> getAllVrstaUsluge() throws Exception {
        return (ArrayList<VrstaUsluge>) sendRequest(Operacije.GET_ALL_VRSTA_USLUGE, null);
    }
    
    public void addTuristickaAgencija(TuristickaAgencija ta) throws Exception {
        sendRequest(Operacije.ADD_TURISTICKA_AGENCIJA, ta);
    }
    
    //Destinacija
    public ArrayList<Destinacija> getAllDestinacija() throws Exception {
        return (ArrayList<Destinacija>) sendRequest(Operacije.GET_ALL_DESTINACIJA, null);
    }
    
    public void addDestinacija(Destinacija d) throws Exception {
        sendRequest(Operacije.ADD_DESTINACIJA, d);
    }
    
    public void deleteDestinacija(Destinacija d) throws Exception {
        sendRequest(Operacije.DELETE_DESTINACIJA, d);
    }
    
    public void updateDestinacija(Destinacija d) throws Exception {
        sendRequest(Operacije.UPDATE_DESTINACIJA, d);
    }
    
    //Nacionalnost
    public ArrayList<Nacionalnost> getAllNacionalnost() throws Exception {
        return (ArrayList<Nacionalnost>) sendRequest(Operacije.GET_ALL_NACIONALNOST, null);
    }
    
    public void addNacionalnost(Nacionalnost n) throws Exception {
        sendRequest(Operacije.ADD_NACIONALNOST, n);
    }

    public void updateNacionalnost(Nacionalnost n) throws Exception {
        sendRequest(Operacije.UPDATE_NACIONALNOST, n);
    }

    private Object sendRequest(int operation, Object data) throws Exception {
        Zahtev request = new Zahtev(operation, data);

        ObjectOutputStream out = new ObjectOutputStream(Session.getInstance().getSocket().getOutputStream());
        out.writeObject(request);

        ObjectInputStream in = new ObjectInputStream(Session.getInstance().getSocket().getInputStream());
        Odgovor response = (Odgovor) in.readObject();

        if (response.getResponseStatus()!=null && response.getResponseStatus().equals(Status.Error)) {
            throw response.getException();
        } else {
            return response.getData();
        }

    }
}
