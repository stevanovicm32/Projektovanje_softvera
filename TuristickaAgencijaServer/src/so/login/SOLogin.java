/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.login;

import controller.ServerskiKontroler;
import database.DBBroker;
import domain.AbstractDomainObject;
import domain.TuristickaAgencija;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author Lenovo
 */
public class SOLogin extends AbstractSO{
    TuristickaAgencija ulogovana;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof TuristickaAgencija)) {
            throw new Exception("Prosledjeni objekat nije instanca klase TuristickaAgencija!");
        }

        TuristickaAgencija ta = (TuristickaAgencija) ado;
        
        for (TuristickaAgencija turistickaagencija : ServerskiKontroler.getInstance().getUlogovaneAgencije()) {
            if(turistickaagencija.getUsername().equalsIgnoreCase(ta.getUsername())){
                throw new Exception("Agencija je vec ulogovana na sistem");
            }
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        TuristickaAgencija ta=(TuristickaAgencija) ado;
        
        ArrayList<TuristickaAgencija> agencije = 
                (ArrayList<TuristickaAgencija>) (ArrayList<?>) DBBroker.getInstance().select(ado);
        
        for (TuristickaAgencija turistickaAgencija : agencije) {
            if(turistickaAgencija.getUsername().equalsIgnoreCase(ta.getUsername())&&
                    turistickaAgencija.getPassword().equals(ta.getPassword())){              
                ulogovana=turistickaAgencija;
                ServerskiKontroler.getInstance().getUlogovaneAgencije().add(turistickaAgencija);
                return;
            }
        }
        
        throw new Exception("Ne postoji turisticka agencija sa tim kredencijalima");
    }
    
    public TuristickaAgencija getUlogovana(){
        return ulogovana;
    }
}
