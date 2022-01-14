/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package circuitry;

/**
 *
 * @author 20215187
 */
class InputFloat extends Gate implements FloatFunctions{

    FloatArg value;
    
    @Override
    public boolean getValue() {
        if (value.getDouble() != 0 && value.getDouble() != 1.0) {
            throw new Error("Double value " + value.getDouble() + " can not be converted to boolean.");
        }
        return value.getDouble() == 1.0 ;
        
    }

    public void setValue(double value) {
        this.value = new FloatArg(false, value);
    }
    
    @Override
    public FloatArg getFloatValue() {
       return value;
    }
    
}
