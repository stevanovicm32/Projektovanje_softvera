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
import java.util.ArrayList;
import so.destinacija.SOAddDestinacija;
import so.destinacija.SODeleteDestinacija;
import so.destinacija.SOGetAllDestinacija;
import so.destinacija.SOUpdateDestinacija;
import so.klijent.SOAddKlijent;
import so.klijent.SODeleteKlijent;
import so.klijent.SOGetAllKlijent;
import so.klijent.SOUpdateKlijent;
import so.login.SOLogin;
import so.nacionalnost.SOAddNacionalnost;
import so.nacionalnost.SODeleteNacionalnost;
import so.nacionalnost.SOGetAllNacionalnost;
import so.nacionalnost.SOUpdateNacionalnost;
import so.rezervacija.SOAddRezervacija;
import so.rezervacija.SODeleteRezervacija;
import so.rezervacija.SOGetAllRezervacija;
import so.rezervacija.SOUpdateRezervacija;
import so.turistickaagencija.SOAddTuristickaAgencija;
import so.turistickaagencija.SODeleteTuristickaAgencija;
import so.turistickaagencija.SOGetAllTuristickaAgencija;
import so.turistickaagencija.SOUpdateTuristickaAgencija;
import so.vrstausluge.SOAddVrstaUsluge;
import so.vrstausluge.SODeleteVrstaUsluge;
import so.vrstausluge.SOGetAllVrstaUsluge;
import so.vrstausluge.SOUpdateVrstaUsluga;

/**
 *
 * @author Lenovo
 */
public class ServerskiKontroler {
    private static ServerskiKontroler instance;
    private ArrayList<TuristickaAgencija> ulogovaneAgencije = new ArrayList<>();

    private ServerskiKontroler() {
    }

    public static ServerskiKontroler getInstance() {
        if (instance == null) {
            instance = new ServerskiKontroler();
        }
        return instance;
    }

    public TuristickaAgencija login(TuristickaAgencija turistickaAgencija) throws Exception {
        SOLogin so = new SOLogin();
        so.templateExecute(turistickaAgencija);
        return so.getUlogovana();
    }

    public void addKlijent(Klijent klijent) throws Exception {
        (new SOAddKlijent()).templateExecute(klijent);
    }

    public void addRezervacija(Rezervacija rezervacija) throws Exception {
        (new SOAddRezervacija()).templateExecute(rezervacija);
    }

    public void deleteKlijent(Klijent klijent) throws Exception {
        (new SODeleteKlijent()).templateExecute(klijent);
    }

    public void deleteRezervacija(Rezervacija rezervacija) throws Exception {
        (new SODeleteRezervacija()).templateExecute(rezervacija);
    }

    public void updateKlijent(Klijent klijent) throws Exception {
        (new SOUpdateKlijent()).templateExecute(klijent);
    }

    public void updateRezervacija(Rezervacija rezervacija) throws Exception {
        (new SOUpdateRezervacija()).templateExecute(rezervacija);
    }

    public ArrayList<Klijent> getAllKlijent() throws Exception {
        SOGetAllKlijent so = new SOGetAllKlijent();
        so.templateExecute(new Klijent());
        return so.getLista();
    }

    public ArrayList<Rezervacija> getAllRezervacija() throws Exception {
        SOGetAllRezervacija so = new SOGetAllRezervacija();
        so.templateExecute(new Rezervacija());
        return so.getLista();
    }

    public ArrayList<Destinacija> getAllTipNekretnine() throws Exception {
        SOGetAllDestinacija so = new SOGetAllDestinacija();
        so.templateExecute(new Destinacija());
        return so.getLista();
    }

    public ArrayList<Nacionalnost> getAllNekretnina() throws Exception {
        SOGetAllNacionalnost so = new SOGetAllNacionalnost();
        so.templateExecute(new Nacionalnost());
        return so.getLista();
    }
    
    public ArrayList<Destinacija> getAllDestinacija() throws Exception {
        SOGetAllDestinacija so = new SOGetAllDestinacija();
        so.templateExecute(new Destinacija());
        return so.getLista();
    }
    
    public void logout(TuristickaAgencija ulogovana) {
        ulogovaneAgencije.remove(ulogovana);
    }

    public ArrayList<TuristickaAgencija> getUlogovaneAgencije() {
        return ulogovaneAgencije;
    }

    public void setUlogovanaAgencija(ArrayList<TuristickaAgencija> ulogovaneAgencije) {
        this.ulogovaneAgencije = ulogovaneAgencije;
    }

    public void addTuristickaAgencija(TuristickaAgencija turistickaAgencija) throws Exception {
        (new SOAddTuristickaAgencija()).templateExecute(turistickaAgencija);
    }

    public void updateTuristickaAgencija(TuristickaAgencija turistickaAgencija) throws Exception {
        (new SOUpdateTuristickaAgencija()).templateExecute(turistickaAgencija);
    }

    public void deleteTuristickaAgencija(TuristickaAgencija turistickaAgencija) throws Exception {
        (new SODeleteTuristickaAgencija()).templateExecute(turistickaAgencija);
    }

    public ArrayList<TuristickaAgencija> getAllTuristickaAgencija() throws Exception {
        SOGetAllTuristickaAgencija so = new SOGetAllTuristickaAgencija();
        so.templateExecute(new TuristickaAgencija());
        return so.getLista();
    }

    public void addDestinacija(Destinacija destinacija) throws Exception {
        (new SOAddDestinacija()).templateExecute(destinacija);
    }

    public void updateDestinacija(Destinacija destinacija) throws Exception {
        (new SOUpdateDestinacija()).templateExecute(destinacija);
    }

    public void deleteDestinacija(Destinacija destinacija) throws Exception {
        (new SODeleteDestinacija()).templateExecute(destinacija);
    }

    public void addNacionalnost(Nacionalnost nacionalnost) throws Exception {
        (new SOAddNacionalnost()).templateExecute(nacionalnost);
    }

    public void updateNacionalnost(Nacionalnost nacionalnost) throws Exception {
        (new SOUpdateNacionalnost()).templateExecute(nacionalnost);
    }

    public void deleteNacionalnost(Nacionalnost nacionalnost) throws Exception {
        (new SODeleteNacionalnost()).templateExecute(nacionalnost);
    }

    public void addVrstaUsluge(VrstaUsluge vrstaUsluge) throws Exception {
        (new SOAddVrstaUsluge()).templateExecute(vrstaUsluge);
    }

    public void updateVrstaUsluge(VrstaUsluge vrstaUsluge) throws Exception {
        (new SOUpdateVrstaUsluga()).templateExecute(vrstaUsluge);
    }

    public void deleteVrstaUsluge(VrstaUsluge vrstaUsluge) throws Exception {
        (new SODeleteVrstaUsluge()).templateExecute(vrstaUsluge);
    }

    public Object getAllVrstaUsluga() throws Exception {
        SOGetAllVrstaUsluge so = new SOGetAllVrstaUsluge();
        so.templateExecute(new VrstaUsluge());
        return so.getLista();
    }
    
    
}
