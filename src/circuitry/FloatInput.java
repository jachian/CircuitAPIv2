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
public class FloatInput extends Gate 
{
    //attributes
    protected FloatArg value;   // perhaps we can make these into objects
    
    //constructors
    public FloatInput()
    { 
        this.value = new FloatArg();
    }
    
    public FloatInput(boolean bValue, double dValue)
    {
        this.value = new FloatArg(bValue, dValue);
    }
    
    @Override
    public boolean getValue()
    {
        return (value.getDouble() == 1.00);
        
    }
    
    @Override
    public FloatArg getFloatValue()
    {
        return this.value;
    }
    
    public void setValue(boolean bValue, double dValue)
    {
        this.value = new FloatArg(bValue, dValue);
    }
    
    public void setValue(FloatArg newArg)
    {
        this.value = newArg;
    }
}

