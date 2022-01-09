/*
 */
package circuitry;

/**
 *
 * @author 20215191
 */
class CustomUnaryGate extends UnaryGate{

        private CustomUnaryOperation operation;

    public CustomUnaryGate(CustomUnaryOperation operation){
        this.operation = operation;
    }

    @Override
    public boolean getValue() {
        boolean v1 = this.inputGate.getValue();
        return operation.doOperation(v1);
    }
    
}
