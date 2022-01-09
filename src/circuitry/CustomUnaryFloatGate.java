/*
 */
package circuitry;

/**
 *
 * @author 20215191
 */
class CustomUnaryFloatGate extends UnaryGate implements FloatFunctions{

    private final CustomUnaryFloatOperation operation;

    public CustomUnaryFloatGate(CustomUnaryFloatOperation operation){
        this.operation = operation;
    }

    @Override
    public boolean getValue() {
        FloatArg floatValue = getFloatValue();
        if (!floatValue.getBoolean()) {
            throw new Error("Vaues between 0 and 1 can not be converted to boolean.");
        }
        
        return floatValue.getDouble() == 1.0;
    }

    @Override
    public FloatArg getFloatValue() {
        FloatArg arg;
        boolean isBoolean = false;
        
        if (this.inputGate instanceof FloatFunctions){
            arg = ((FloatFunctions)inputGate).getFloatValue();
            
        }else{
            arg = new FloatArg(true, inputGate.getValue()? 1.0 : 0);
            isBoolean = true;
        }

        double result = operation.doOperation(arg.getDouble());
        
        return new FloatArg(isBoolean, result);
    }
}
