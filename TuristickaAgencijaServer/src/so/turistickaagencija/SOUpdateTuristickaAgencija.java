/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.turistickaagencija;

import database.DBBroker;
import domain.AbstractDomainObject;
import domain.TuristickaAgencija;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author Lenovo
 */
public class SOUpdateTuristickaAgencija extends AbstractSO{

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof TuristickaAgencija)) {
            throw new Exception("Prosledjeni objekat nije instanca klase TuristickaAgencija!");
        }

        TuristickaAgencija novaAgencija = (TuristickaAgencija) ado;

        ArrayList<TuristickaAgencija> agencije = (ArrayList<TuristickaAgencija>) (ArrayList<?>) DBBroker.getInstance().select(ado);
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        DBBroker.getInstance().update(ado);
    }
    
}
