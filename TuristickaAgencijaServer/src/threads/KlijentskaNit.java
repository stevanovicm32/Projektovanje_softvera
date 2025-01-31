/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threads;

import controller.ServerskiKontroler;
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
import java.net.Socket;
import transfer.Odgovor;
import transfer.Zahtev;
import transfer.util.Operacije;
import transfer.util.Status;

/**
 *
 * @author Lenovo
 */
public class KlijentskaNit extends Thread{
    private Socket socket;

    public KlijentskaNit(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try{
            while(!socket.isClosed()){
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                Zahtev request = (Zahtev) in.readObject();
                Odgovor response = handleRequest(request);
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                out.writeObject(response);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    private Odgovor handleRequest(Zahtev request) {
        Odgovor response = new Odgovor(null, null, Status.Success);
        try {
            switch (request.getOperation()) {
                case Operacije.ADD_KLIJENT:
                    ServerskiKontroler.getInstance().addKlijent((Klijent) request.getData());
                    break;
                case Operacije.ADD_REZERVACIJA:
                    ServerskiKontroler.getInstance().addRezervacija((Rezervacija) request.getData());
                    break;
                case Operacije.DELETE_REZERVACIJA:
                    ServerskiKontroler.getInstance().deleteRezervacija((Rezervacija) request.getData());
                    break;
                case Operacije.DELETE_KLIJENT:
                    ServerskiKontroler.getInstance().deleteKlijent((Klijent) request.getData());
                    break;
                case Operacije.UPDATE_REZERVACIJA:
                    ServerskiKontroler.getInstance().updateRezervacija((Rezervacija) request.getData());
                    break;
                case Operacije.UPDATE_KLIJENT:
                    ServerskiKontroler.getInstance().updateKlijent((Klijent) request.getData());
                    break;
                case Operacije.GET_ALL_REZERVACIJA:
                    response.setData(ServerskiKontroler.getInstance().getAllRezervacija());
                    break;
                case Operacije.GET_ALL_KLIJENT:
                    response.setData(ServerskiKontroler.getInstance().getAllKlijent());
                    break;
                case Operacije.GET_ALL_NACIONALNOST:
                    response.setData(ServerskiKontroler.getInstance().getAllNekretnina());
                    break;
                case Operacije.GET_ALL_DESTINACIJA:
                    response.setData(ServerskiKontroler.getInstance().getAllDestinacija());
                    break;
                case Operacije.GET_ALL_VRSTA_USLUGE:
                    response.setData(ServerskiKontroler.getInstance().getAllVrstaUsluga());
                    break;
                case Operacije.LOGIN:
                    TuristickaAgencija turistickaAgencija = (TuristickaAgencija) request.getData();
                    TuristickaAgencija ulogovana = ServerskiKontroler.getInstance().login(turistickaAgencija);
                    response.setData(ulogovana);
                    break;
                case Operacije.LOGOUT:
                    TuristickaAgencija agencijaZaOdjavu = (TuristickaAgencija) request.getData();
                    ServerskiKontroler.getInstance().logout(agencijaZaOdjavu);
                    break;
                case Operacije.ADD_TURISTICKA_AGENCIJA:
                    ServerskiKontroler.getInstance().addTuristickaAgencija((TuristickaAgencija) request.getData());
                    break;
                case Operacije.UPDATE_TURISTICKA_AGENCIJA:
                    ServerskiKontroler.getInstance().updateTuristickaAgencija((TuristickaAgencija) request.getData());
                    break;
                case Operacije.DELETE_TURISTICKA_AGENCIJA:
                    ServerskiKontroler.getInstance().deleteTuristickaAgencija((TuristickaAgencija) request.getData());
                    break;
                case Operacije.GET_ALL_TURISTICKA_AGENCIJA:
                    response.setData(ServerskiKontroler.getInstance().getAllTuristickaAgencija());
                    break;
                case Operacije.ADD_DESTINACIJA:
                    ServerskiKontroler.getInstance().addDestinacija((Destinacija) request.getData());
                    break;
                case Operacije.UPDATE_DESTINACIJA:
                    ServerskiKontroler.getInstance().updateDestinacija((Destinacija) request.getData());
                    break;
                case Operacije.DELETE_DESTINACIJA:
                    ServerskiKontroler.getInstance().deleteDestinacija((Destinacija) request.getData());
                    break;
                case Operacije.ADD_NACIONALNOST:
                    ServerskiKontroler.getInstance().addNacionalnost((Nacionalnost) request.getData());
                    break;
                case Operacije.UPDATE_NACIONALNOST:
                    ServerskiKontroler.getInstance().updateNacionalnost((Nacionalnost) request.getData());
                    break;
                case Operacije.DELETE_NACIONALNOST:
                    ServerskiKontroler.getInstance().deleteNacionalnost((Nacionalnost) request.getData());
                    break;
                case Operacije.ADD_VRSTA_USLUGE:
                    ServerskiKontroler.getInstance().addVrstaUsluge((VrstaUsluge) request.getData());
                    break;
                case Operacije.UPDATE_VRSTA_USLUGE:
                    ServerskiKontroler.getInstance().updateVrstaUsluge((VrstaUsluge) request.getData());
                    break;
                case Operacije.DELETE_VRSTA_USLUGE:
                    ServerskiKontroler.getInstance().deleteVrstaUsluge((VrstaUsluge) request.getData());
                    break;
                case Operacije.GET_ALL_STAVKE_REZERVACIJE:
                    response.setData(ServerskiKontroler.getInstance().getAllStavkaRezervacije());
                    break;
                case Operacije.ADD_STAVKA_REZERVACIJE:
                    ServerskiKontroler.getInstance().addStavkaRezervacije((StavkaRezervacije) request.getData());
                    break;
                case Operacije.DELETE_STAVKA_REZERVACIJE:
                    ServerskiKontroler.getInstance().deleteStavkaRezervacije((StavkaRezervacije) request.getData());
                    break;
                case Operacije.GET_ALL_TAVU:
                    response.setData(ServerskiKontroler.getInstance().getAllTAVU());
                    break;
                case Operacije.ADD_TAVU:
                    ServerskiKontroler.getInstance().addTAVU((TAVU) request.getData());
                    break;
                case Operacije.DELETE_TAVU:
                    ServerskiKontroler.getInstance().deleteTAVU((TAVU) request.getData());
                    break;
                default:
                    return null;
            }
        } catch (Exception e) {
            response.setResponseStatus(Status.Error);
            response.setException(e);
        }
        return response;
    }
}
