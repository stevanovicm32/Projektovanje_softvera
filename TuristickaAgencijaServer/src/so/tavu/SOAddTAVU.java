/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.tavu;

import database.DBBroker;
import domain.AbstractDomainObject;
import domain.TAVU;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author Lenovo
 */
public class SOAddTAVU extends AbstractSO{

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if(!(ado instanceof TAVU))
        {
            throw new Exception("Prosledjeni objekat nije instanca klase TAVU");
        }
        
        TAVU noviTAVU= (TAVU) ado;
        
        ArrayList<TAVU> tavui = (ArrayList<TAVU>) (ArrayList<?>) DBBroker.getInstance().select(ado);
        
        for (TAVU tavu : tavui) {
        if (tavu.getAgencija().getIdAgencije().equals(noviTAVU.getAgencija().getIdAgencije()) &&
            tavu.getUsluga().getIdVrstaUsluge().equals(noviTAVU.getUsluga().getIdVrstaUsluge())) {
            throw new Exception("Usluga već uneta za ovu agenciju.");
        }
}

    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        DBBroker.getInstance().insert(ado);
    }
}
