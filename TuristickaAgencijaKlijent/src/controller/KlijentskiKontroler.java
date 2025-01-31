/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import domain.Destinacija;
import domain.Klijent;
import domain.Nacionalnost;
import domain.Rezervacija;
import domain.StavkaRezervacije;
import domain.TAVU;
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

    //Klijent
    public ArrayList<Klijent> getAllKlijent() throws Exception {
        return (ArrayList<Klijent>) sendRequest(Operacije.GET_ALL_KLIJENT, null);
    }
    
    public void addKlijent(Klijent klijent) throws Exception {
        sendRequest(Operacije.ADD_KLIJENT, klijent);
    }

    public void updateKlijent(Klijent klijent) throws Exception {
        sendRequest(Operacije.UPDATE_KLIJENT, klijent);
    }
    
    public void deleteKlijent(Klijent klijent) throws Exception {
        sendRequest(Operacije.DELETE_KLIJENT, klijent);
    }
    
    //Rezervacija
    public ArrayList<Rezervacija> getAllRezervacija() throws Exception {
        return (ArrayList<Rezervacija>) sendRequest(Operacije.GET_ALL_REZERVACIJA, null);
    }
    
    public void addRezervacija(Rezervacija rezervacija) throws Exception {
        sendRequest(Operacije.ADD_REZERVACIJA, rezervacija);
    }
    
    public void updateRezervacija(Rezervacija rezervacija) throws Exception {
        sendRequest(Operacije.UPDATE_REZERVACIJA, rezervacija);
    }
    
    public void deleteRezervacija(Rezervacija rezervacija) throws Exception {
        sendRequest(Operacije.DELETE_REZERVACIJA, rezervacija);
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
    
    public void deleteNacionalnost(Nacionalnost n) throws Exception {
        sendRequest(Operacije.DELETE_NACIONALNOST, n);
    }
    
    //VrstaUsluge
    public ArrayList<VrstaUsluge> getAllVrstaUsluge() throws Exception {
        return (ArrayList<VrstaUsluge>) sendRequest(Operacije.GET_ALL_VRSTA_USLUGE, null);
    }
    
    public ArrayList<VrstaUsluge> getAllVrstaUsluge(TuristickaAgencija ta) throws Exception {
        return (ArrayList<VrstaUsluge>) sendRequest(Operacije.GET_ALL_VRSTA_USLUGE, ta);
    }
    
    public void addVrstaUsluge(VrstaUsluge vu) throws Exception {
        sendRequest(Operacije.ADD_VRSTA_USLUGE, vu);
    }
    
    public void updateVrstaUsluge(VrstaUsluge vu) throws Exception {
        sendRequest(Operacije.UPDATE_VRSTA_USLUGE, vu);
    }
    
    public void deleteVrstaUsluge(VrstaUsluge vu) throws Exception {
        sendRequest(Operacije.DELETE_VRSTA_USLUGE, vu);
    }
    
    //Turisticka agencija
    public ArrayList<TuristickaAgencija> getAllTuristickaAgencija() throws Exception {
        return (ArrayList<TuristickaAgencija>) sendRequest(Operacije.GET_ALL_TURISTICKA_AGENCIJA, null);
    }
    
    public void addTuristickaAgencija(TuristickaAgencija ta) throws Exception {
        sendRequest(Operacije.ADD_TURISTICKA_AGENCIJA, ta);
    }
    
    public void updateTuristickaAgencija(TuristickaAgencija ta) throws Exception {
        sendRequest(Operacije.UPDATE_TURISTICKA_AGENCIJA, ta);
    }
    
    public void deleteTuristickaAgencija(TuristickaAgencija ta) throws Exception {
        sendRequest(Operacije.DELETE_TURISTICKA_AGENCIJA, ta);
    }
    
    public TuristickaAgencija login(TuristickaAgencija agencija) throws Exception {
        return (TuristickaAgencija) sendRequest(Operacije.LOGIN, agencija);
    }
    
    public void logout(TuristickaAgencija ulogovana) throws Exception {
        sendRequest(Operacije.LOGOUT, ulogovana);
    }
    
    //StavkaRezervacije
    public ArrayList<StavkaRezervacije> getAllStavkaRezervacije() throws Exception {
        return (ArrayList<StavkaRezervacije>) sendRequest(Operacije.GET_ALL_STAVKE_REZERVACIJE, null);
    }
    
    public void addStavkaRezervacije(StavkaRezervacije s) throws Exception {
        sendRequest(Operacije.ADD_STAVKA_REZERVACIJE, s);
    }
    
    public void deleteStavkaRezervacije(StavkaRezervacije sr) throws Exception {
        sendRequest(Operacije.DELETE_STAVKA_REZERVACIJE, sr);
    }
    
    //TAVU
    public ArrayList<TAVU> getAllTAVU() throws Exception {
        return (ArrayList<TAVU>) sendRequest(Operacije.GET_ALL_TAVU, null);
    }
    
    public void addTAVU(TAVU t) throws Exception {
        sendRequest(Operacije.ADD_TAVU, t);
    }
    
    public void deleteTAVU(TAVU t) throws Exception {
        sendRequest(Operacije.DELETE_TAVU, t);
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
