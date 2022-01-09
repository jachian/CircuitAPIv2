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
public class notFloat extends FloatUnaryGate
{
     
    public notFloat()
    {
        
    }

      
    @Override
    public boolean getValue()
    {
          return booleanNot(inputGate.getFloatValue().getDouble());
    }
    
    
    @Override
    public FloatArg getFloatValue() 
    {
        if((inputGate.getFloatValue().isBoolean()))  // if both inputs are boolean
        {
            return new FloatArg(true, binaryNot(inputGate.getFloatValue().getDouble()));
        }
        // if one of the inputs is not a boolean the do the caluclation - i.e return (false, result)
        return new FloatArg(false, 1.00 - inputGate.getFloatValue().getDouble());
    }
    

    protected static boolean booleanNot(double value)
    {
        if(value >= 1.00)
           return false;
        return true;
    }
    
    protected static double binaryNot(double value)
    {
        if(value >= 1.00)
           return 0.00;
        return 1.00;
    }
    
}
    