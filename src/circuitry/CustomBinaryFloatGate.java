/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package circuitry;

/**
 *
 * @author 20215191
 */
class CustomBinaryFloatGate extends BinaryGate implements FloatFunctions{
    
    private final CustomBinaryFloatOperation operation;
    
    public CustomBinaryFloatGate(CustomBinaryFloatOperation operation){
        this.operation = operation;
    }

    @Override
    public boolean getValue() {
        FloatArg floatValue = getFloatValue();
        if (!floatValue.getBoolean()) {
            throw new Error("Vaues between 0 and 1 can not be converted to boolean.");
        }
        
        return floatValue.getBoolean();
    }

    @Override
    public FloatArg getFloatValue(){
        FloatArg arg1, arg2;
        
        boolean isBoolean = true;
        
        if (this.inputGate1 instanceof FloatFunctions){
            arg1 = ((FloatFunctions)inputGate1).getFloatValue();
            isBoolean = false;
        }else{
            arg1 = new FloatArg(true, inputGate1.getValue()? 1.0 : 0);
        }
        
        if (this.inputGate2 instanceof FloatFunctions) {
            arg2 = ((FloatFunctions)inputGate2).getFloatValue();
            isBoolean = false;
        }else{
            arg2 = new FloatArg(true, inputGate2.getValue()? 1.0 : 0);
        }
        double result = operation.doOperation(arg1.getDouble(), arg2.getDouble());
        return new FloatArg(isBoolean, result);
    }

}
