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
public class Input extends Gate 
{
    //attributes
    private boolean value;   // perhaps we can make these into objects
    
    //constructors
    public Input()
    { 
        this.value = false;
    }
    
    //public Input(boolean value)
    //{
        //this.value = value;
    //}
    
    
    @Override
    public boolean getValue()
    {
        return this.value;
    }
    
    @Override
    public FloatArg getFloatValue()
    {
        double boolValue = 0.00;
        
        if(this.value == true)
            boolValue = 1.00;
        
        return new FloatArg(true,boolValue);
    }
    
    public void setValue(boolean newValue)
    {
        this.value = newValue;
    }


}
