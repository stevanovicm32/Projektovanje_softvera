/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.stavkarezervacije;

import database.DBBroker;
import domain.AbstractDomainObject;
import domain.StavkaRezervacije;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author Lenovo
 */
public class SOGetAllStavkaRezervacije extends AbstractSO{
    ArrayList<StavkaRezervacije> lista;
    
    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if(!(ado instanceof StavkaRezervacije))
        {
            throw new Exception("Prosledjeni objekat nije instanca klase Stavka rezervacije");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
    ArrayList<AbstractDomainObject> stavke = DBBroker.getInstance().select(ado);
    lista = new ArrayList<>();

    for (AbstractDomainObject obj : stavke) {
        if (obj instanceof StavkaRezervacije) {
            lista.add((StavkaRezervacije) obj);
        }
    }
    }
    
    public ArrayList<StavkaRezervacije> getLista(){
        return lista;
    }
}
