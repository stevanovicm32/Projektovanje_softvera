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
public class SOGetAllTAVU extends AbstractSO{
    private ArrayList<TAVU> lista;
    
    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if(!(ado instanceof TAVU))
        {
            throw new Exception("Prosledjeni objekat nije instanca klase TAVU");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        ArrayList<AbstractDomainObject> tavui=DBBroker.getInstance().select(ado);
        lista= (ArrayList<TAVU>) (ArrayList<?>) tavui;
    }
    
    public ArrayList<TAVU> getLista(){
        return lista;
    }
}
