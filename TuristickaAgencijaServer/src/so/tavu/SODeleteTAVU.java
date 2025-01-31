/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.tavu;

import database.DBBroker;
import domain.AbstractDomainObject;
import domain.TAVU;
import so.AbstractSO;

/**
 *
 * @author Lenovo
 */
public class SODeleteTAVU extends AbstractSO{

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if(!(ado instanceof TAVU))
        {
            throw new Exception("Prosledjeni objekat nije instanca klase TAVU");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        DBBroker.getInstance().delete(ado);
    }
}
