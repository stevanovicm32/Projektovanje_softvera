/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.turistickaagencija;

import database.DBBroker;
import domain.AbstractDomainObject;
import domain.TuristickaAgencija;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author Lenovo
 */
public class SOUpdateTuristickaAgencija extends AbstractSO{

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof TuristickaAgencija)) {
            throw new Exception("Prosledjeni objekat nije instanca klase TuristickaAgencija!");
        }

        TuristickaAgencija novaAgencija = (TuristickaAgencija) ado;

        ArrayList<TuristickaAgencija> agencije = (ArrayList<TuristickaAgencija>) (ArrayList<?>) DBBroker.getInstance().select(ado);
        
        for (TuristickaAgencija turistickaAgencija : agencije) {
            if(turistickaAgencija.getNaziv().equalsIgnoreCase(novaAgencija.getNaziv()))
            {
                throw new Exception("Vec postoji turisticka agencija s tim nazivom!");
            }
            if(turistickaAgencija.getAdresa().equalsIgnoreCase(novaAgencija.getAdresa()))
            {
                throw new Exception("Vec postoji turisticka agencija s tom adresom!");
            }
            if(turistickaAgencija.getUsername().equalsIgnoreCase(novaAgencija.getUsername()))
            {
                throw new Exception("Korisnicko ime vec postoji!");
            }
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        DBBroker.getInstance().update(ado);
    }
    
}
