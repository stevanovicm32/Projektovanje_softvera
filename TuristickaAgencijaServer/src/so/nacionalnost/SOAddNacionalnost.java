/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.nacionalnost;

import database.DBBroker;
import domain.AbstractDomainObject;
import domain.Nacionalnost;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author Lenovo
 */
public class SOAddNacionalnost extends AbstractSO{

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Nacionalnost)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Nacionalnost!");
        }

        Nacionalnost novaNacionalnost = (Nacionalnost) ado;

        ArrayList<Nacionalnost> nacionalnosti = (ArrayList<Nacionalnost>) (ArrayList<?>) DBBroker.getInstance().select(ado);
        
        for (Nacionalnost nacionalnost : nacionalnosti) {
            if(nacionalnost.getNaziv().equalsIgnoreCase(novaNacionalnost.getNaziv())){
                throw new Exception("Vec postoji nacionalnost s tim nazivom!");
            }
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        DBBroker.getInstance().insert(ado);
    }
    
}
