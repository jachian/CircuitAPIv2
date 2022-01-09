/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package circuitry;

/**
 *
 * @author 20215191
 */
public class NotFloat extends UnaryGate implements FloatFunctions{

    @Override
    public boolean getValue() {
        return !inputGate.getValue();
    }

    @Override
    public FloatArg getFloatValue() {
        if (inputGate instanceof FloatFunctions) {
            FloatArg arg = ((FloatFunctions)inputGate).getFloatValue();
            FloatArg result = new FloatArg(false, 1 - arg.getDouble());
            return result;
        } 
        
        double result = inputGate.getValue()? 0: 1.0;
        return new FloatArg(false, result);
    }
    
}
