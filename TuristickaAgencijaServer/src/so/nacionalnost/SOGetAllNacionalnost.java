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
public class SOGetAllNacionalnost extends AbstractSO{

    private ArrayList<Nacionalnost> lista;
    
    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if(!(ado instanceof Nacionalnost)){
            throw new Exception("Prosledjeni objekat nije instanca klase Nacionalnost");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        ArrayList<AbstractDomainObject> nekretnine = DBBroker.getInstance().select(ado);
        lista=(ArrayList<Nacionalnost>)(ArrayList<?>) nekretnine;
    }
    
    public ArrayList<Nacionalnost> getLista(){
        return lista;
    }
}
