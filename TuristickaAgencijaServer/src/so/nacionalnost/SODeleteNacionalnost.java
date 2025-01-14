/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.nacionalnost;

import database.DBBroker;
import domain.AbstractDomainObject;
import domain.Nacionalnost;
import so.AbstractSO;

/**
 *
 * @author Lenovo
 */
public class SODeleteNacionalnost extends AbstractSO{

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Nacionalnost)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Nacionalnost!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        DBBroker.getInstance().delete(ado);
    }
    
}
