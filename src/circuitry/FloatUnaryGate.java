/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package circuitry;

/**
 *
 * @author 20215199
 */
public class FloatUnaryGate extends Gate
{
    //attributes
    protected Gate inputGate;   // perhaps we can make these into objects -- this will be a FloatInput
    
    //constructors
    public FloatUnaryGate()
    { 
    }
    
    //public UnaryGate(Gate left)
    //{
        //this.leftInput = left;
    //}
    
    
    // methods /////////////////////////
    public void connectInput(Gate gate)
    {
        this.inputGate = gate;
    }
    

    @Override
    public boolean getValue()
    {
        return false;
    }
    
    @Override
    public FloatArg getFloatValue()
    {
        return new FloatArg(false, 0.00);
    }
    
}
