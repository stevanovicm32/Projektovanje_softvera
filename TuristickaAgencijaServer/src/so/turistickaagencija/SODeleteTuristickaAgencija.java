/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.turistickaagencija;

import database.DBBroker;
import domain.AbstractDomainObject;
import domain.TuristickaAgencija;
import so.AbstractSO;

/**
 *
 * @author Lenovo
 */
public class SODeleteTuristickaAgencija extends AbstractSO{

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof TuristickaAgencija)) {
            throw new Exception("Prosledjeni objekat nije instanca klase TuristickaAgencija!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        DBBroker.getInstance().delete(ado);
    }
    
}
