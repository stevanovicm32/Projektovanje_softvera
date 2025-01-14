/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.rezervacija;

import domain.AbstractDomainObject;
import domain.Rezervacija;
import so.AbstractSO;

/**
 *
 * @author Lenovo
 */
public class SOAddRezervacija extends AbstractSO{

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if(!(ado instanceof Rezervacija)){
            throw new Exception("Prosledjeni objekat nije instanca klase Rezervacija");
        }
        
        Rezervacija r= (Rezervacija) ado;
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
