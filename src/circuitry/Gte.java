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
public class Gte extends FloatBinaryGate
{
    public Gte()
    {
                
    }

    
    public FloatArg getFloatValue() 
    {
        // placeholders for booleand double conversions.
        double dLeft = 0.00;
        double dRight = 0.00;
        
        //first check to see if the inputs are both float functions or not...
        if ((inputGate1 instanceof FloatFunctions) && (inputGate2 instanceof FloatFunctions))  // if we are dealing with float functions
        {
            FloatFunctions left = (FloatFunctions)inputGate1;
            FloatFunctions right = (FloatFunctions)inputGate2;
            
            // check if left and right ar both booleans
            if(left.isBoolean() && (right.isBoolean()))  // if both are booleans then return (true, result)
            {
                return new FloatArg(true, binaryGte(left.getDouble(), right.getDouble()));
            }
            // if one of the inputs is not a boolean the do the caluclation - i.e return (false, result)
            return new FloatArg(false, 1.00 - (1.00 - left.getDouble()) * (1.00 - right.getDouble()));
        }
        
        if(inputGate2 instanceof FloatFunctions)  // ie if only the right is a flaot function.
        {
            FloatFunctions right = (FloatFunctions)inputGate2;  //cast the float function
            
            if(inputGate1.getValue() == true) // convert boolean lhs to double
                dLeft = 1.00;
            else
                dLeft = 0.00;
            
            return new FloatArg(false, 1.00 - (1.00 - dLeft) * (1.00 - right.getDouble()));
            
        }
        
        // if only the left is a float
        FloatFunctions left = (FloatFunctions)inputGate1;  //cast the float function
            
        if(inputGate2.getValue() == true) // convert boolean lhs to double
           dRight = 1.00;
        else
           dRight = 0.00;
            
        return new FloatArg(false, 1.00 - (1.00 - left.getDouble()) * (1.00 - dRight));
                    
    }
        
    
    private static boolean binaryGte(double lhs, double rhs)
    {
        if(lhs >= rhs)
            return 1.00;
            
        return 0.00;
    }
}
