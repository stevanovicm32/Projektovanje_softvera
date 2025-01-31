/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.stavkarezervacije;

import database.DBBroker;
import domain.AbstractDomainObject;
import domain.StavkaRezervacije;
import so.AbstractSO;

/**
 *
 * @author Lenovo
 */
public class SOAddStavkaRezervacije extends AbstractSO{

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if(!(ado instanceof StavkaRezervacije)){
            throw new Exception("Prosledjeni objekat nije instanca klase Stavka rezervacije");
        }
        
        StavkaRezervacije sr = (StavkaRezervacije) ado;
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        DBBroker.getInstance().insert(ado);
    }
    
}
