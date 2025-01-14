/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.klijent;

import domain.AbstractDomainObject;
import domain.Klijent;
import database.DBBroker;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author Lenovo
 */
public class SOAddKlijent extends AbstractSO{

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if(!(ado instanceof Klijent))
        {
            throw new Exception("Prosledjeni objekat nije instanca klase Klijent");
        }
        
        Klijent noviKlijent= (Klijent) ado;
        
        ArrayList<Klijent> klijenti = (ArrayList<Klijent>) (ArrayList<?>) DBBroker.getInstance().select(ado);
        
        for (Klijent klijent : klijenti) {
            if(klijent.getEmail().equalsIgnoreCase(noviKlijent.getEmail())){
                throw new Exception("Vec postoji klijent sa tim email-om");
            }
            if(klijent.getTelefon().equalsIgnoreCase(noviKlijent.getTelefon())){
                throw new Exception("Vec postoji klijent sa tim brojem telefona");
            }
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        DBBroker.getInstance().insert(ado);
    }
    
}
