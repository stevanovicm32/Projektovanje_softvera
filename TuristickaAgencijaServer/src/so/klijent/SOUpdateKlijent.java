/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.klijent;

import database.DBBroker;
import domain.AbstractDomainObject;
import domain.Klijent;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author Lenovo
 */
public class SOUpdateKlijent extends AbstractSO{

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if(!(ado instanceof Klijent)){
            throw new Exception("Prosledjeni objekat nije instanca klase Klijent");
        }
        
        Klijent izmeniKlijent = (Klijent) ado;
        
        ArrayList<Klijent> klijenti = (ArrayList<Klijent>) (ArrayList<?>) DBBroker.getInstance().select(ado);
        
        for (Klijent klijent : klijenti) {
            if(klijent.getIdKlijent()!=izmeniKlijent.getIdKlijent()){
                if(klijent.getEmail().equalsIgnoreCase(izmeniKlijent.getEmail())){
                    throw new Exception("Vec postoji klijent sa tim email-om");
                }
                if(klijent.getTelefon().equalsIgnoreCase(izmeniKlijent.getTelefon())){
                    throw new Exception("Vec postoji klijent sa tim brojem telefona");
                }
            }
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        DBBroker.getInstance().update(ado);
    }
    
}
