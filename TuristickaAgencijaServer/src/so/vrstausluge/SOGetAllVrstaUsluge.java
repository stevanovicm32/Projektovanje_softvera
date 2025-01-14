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
public class SOGetAllVrstaUsluge extends AbstractSO{

    private ArrayList<VrstaUsluge> lista;
    
    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if(!(ado instanceof VrstaUsluge))
        {
            throw new Exception("Prosledjeni objekat nije instanca klase VrstaUsluge");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        ArrayList<AbstractDomainObject> vrsteUsluga = DBBroker.getInstance().select(ado);
        lista= (ArrayList<VrstaUsluge>) (ArrayList<?>) vrsteUsluga;
    }
    
    public ArrayList<VrstaUsluge> getLista(){
        return lista;
    }
    
}
