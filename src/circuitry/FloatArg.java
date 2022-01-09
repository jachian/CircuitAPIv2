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
public class FloatArg 
{
    // variabels 
    protected boolean isBoolean;   // the boolean component
    protected double doubleValue;  // the double/floating point
    
    // constructors   ///////////////////
    public FloatArg()
    {
        this.isBoolean = false;
        this.doubleValue = 0.00;
    }
    

    public FloatArg(boolean bValue, double dValue)
    {
        this.isBoolean = bValue;
        this.doubleValue = dValue;
    }
    
    /////////////////////// methods   ///////////////////////////////
    // retuns whether the instance is a boolean or not.
    public boolean getBoolean()
    {
         return  (doubleValue == 1.00);
    }
    
    // returns the actual double value  /////
    public double getDouble()
    {
        return doubleValue;
    }
    
    public void setValue(boolean bValue, double dValue)
    {
        this.isBoolean = bValue;
        this.doubleValue = dValue;
    }
    
    
    
}


