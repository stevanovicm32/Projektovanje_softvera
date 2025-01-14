/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.vrstausluge;

import database.DBBroker;
import domain.AbstractDomainObject;
import domain.VrstaUsluge;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author Lenovo
 */
public class SOUpdateVrstaUsluga extends AbstractSO{

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof VrstaUsluge)) {
            throw new Exception("Prosledjeni objekat nije instanca klase VrstaUsluge!");
        }

        VrstaUsluge novaVrsta = (VrstaUsluge) ado;

        ArrayList<VrstaUsluge> usluge = (ArrayList<VrstaUsluge>) (ArrayList<?>) DBBroker.getInstance().select(ado);
        
        for (VrstaUsluge vrstaUsluge : usluge) {
            if(vrstaUsluge.getNazivUsluge().equalsIgnoreCase(novaVrsta.getNazivUsluge())){
                throw new Exception("Vec postoji vrsta usluge s tim nazivom!");
            }
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        DBBroker.getInstance().update(ado);
    }
    
}
