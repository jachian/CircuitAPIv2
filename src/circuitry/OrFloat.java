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
class OrFloat extends BinaryGate implements FloatFunctions
{
     
    public OrFloat()
    {
        
    }
    //public FloatArg getDoubleValue()
    //{
          //return new FloatArg();
    //}
      
    @Override
    public boolean getValue()
    {
          return (inputGate1.getValue() || inputGate2.getValue());
    }
    
    
    @Override
    public FloatArg getFloatValue() 
    {
        FloatArg lhs = null;
        FloatArg rhs = null;
        boolean leftBool = false;
        boolean rightBool = false;
        
        if(inputGate1 instanceof FloatFunctions)
        {
            FloatFunctions l = (FloatFunctions)inputGate1;
            lhs = l.getFloatValue();
        }
        else  // boolean
        {
            lhs = new FloatArg(true, boolToBinary(inputGate1.getValue()));
            leftBool = true;
        }
        
        if(inputGate2 instanceof FloatFunctions)
        {
            FloatFunctions r = (FloatFunctions)inputGate2;
            rhs = r.getFloatValue();
        }
        else   // boolean
        {
            rhs = new FloatArg(true, boolToBinary(inputGate2.getValue()));
            rightBool = true;
        }
        
        // now do the computation
        return (new FloatArg(leftBool && rightBool, 1 - (1 - lhs.getDouble()) * (1 - rhs.getDouble())));
        
        
        
        
       
        
        //if((inputGate1.getFloatValue().isBoolean()) && (inputGate2.getFloatValue().isBoolean()))  // if both inputs are boolean
        //{
            //return new FloatArg(true, binaryOr(inputGate1.getFloatValue().getDouble(), inputGate2.getFloatValue().getDouble()));
        //}
        
        // if one of the inputs is not a boolean the do the caluclation - i.e return (false, result)
        //return new FloatArg(false, 1.00 - (1.00 - inputGate1.getFloatValue().getDouble()) * (1.00 - inputGate2.getFloatValue().getDouble()));
    }
    
    
       
    //private static double binaryOr(double lhs, double rhs)
    //{
        //if((lhs == 1.00) || (rhs == 1.00))
            //return 1.00;
            
        //return 0.00;
    //}
    
    //private static boolean booleanOr(double lhs, double rhs)
    //{
        //return ((lhs == 1.00) || (rhs == 1.00));
    //}    
    
    
    private static double boolToBinary(boolean value)
    {
        if(value == true)
            return 1.00;
        return 0.00;
    }
      
}
    


/*
    
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
                return new FloatArg(true, binaryOr(left.getDouble(), right.getDouble()));
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
        
*/