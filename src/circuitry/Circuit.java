package circuitry;

import java.util.HashMap;
import java.util.Map;

/**
 * This class is the facade to the Circuit API library. To create and simulate a
 * circuit first create an instance of Circuit class then add inputs and and gates
 * after that connect the gates and inputs then select the gate to be an output gate
 * finally run the simulation by calling the method run.
 * @author group 4
 */
public final class Circuit{
    private final Map<String, Gate> gates = new HashMap<>();
    private String outputGateName = null;

    /**
     * Creates an OR gate and adds it to the circuit
     * @param name name of the gate
     */
    public void addOrGate(String name){
        Gate orGate = new Or();
        gates.put(name, orGate);
    }
    
    /**
     * Creates an AND gate and adds it to the circuit
     * @param name a name for the AND gate to be added
     */
    public void addAndGate(String name){
        Gate andGate = new And();
        gates.put(name, andGate);
    }
    
    /**
     * Adds a NOT gate to the circuit
     * @param name name for the NOT gate to be added
     */
    public void addNotGate(String name){
        Gate notGate = new Not();
        gates.put(name, notGate);
    }

    /**
     * Adds input to the circuit
     * @param name name for the input gate to be added
     */
    public void addInput(String name){
        Gate input = new Input();
        gates.put(name, input);
    }

    /**
     * Connects gate 1 input to gate 2 output.
     * @param gate1Name the first gate to be connected
     * @param gate2Name the second gate to be connect
     * @param inputNumber gate ones input number
     */
    public void connect(String gate1Name, String gate2Name, int inputNumber){
        
        if (!gates.containsKey(gate1Name)) {
            throw new Error(gate1Name + " is not a gate.");
        }
        if (!gates.containsKey(gate2Name)) {
            throw new Error(gate2Name + " is not a gate.");
        }
        
        Gate gate1 = gates.get(gate1Name);
        Gate gate2 = gates.get(gate2Name);
        
        if(gate1 instanceof Input){
            throw new Error("An Input gate has no input pin.");
        }else
        if(gate1 instanceof UnaryGate){ // connect input
            if (inputNumber == 1) {
                ((UnaryGate)gate1).connectInput(gate2);
            } else{
                throw new Error("Unary gate can have only one input.");
            }
        }else
        if(gate1 instanceof BinaryGate){
            if (inputNumber == 1) {
                ((BinaryGate)gate1).connectInput1(gate2);
            }else
            if (inputNumber == 2) {
                ((BinaryGate)gate1).connectInput2(gate2);
            } else {
                throw new Error("Binary gates can have only two inputs.");
            }
        }
    }
    
    /**
     * Runs the circuit
     * @return result of the circuit
     */
    public boolean run(){
        if (outputGateName == null) {
            throw new Error("Set output gate first.");
        }
        return gates.get(outputGateName).getValue();
    }

    
    /**
     * Sets the level of the input gate to high (true) or low (false)
     * @param inputName name of the input gate
     * @param value true or false
     */
    public void setInputValue(String inputName, boolean value){
        if (!gates.containsKey(inputName)) {
            throw new Error(inputName + " not found.");
        }
        
        Gate input = gates.get(inputName);
        if (!(input instanceof Input)) {
          throw new Error(inputName + " is not an input gate.");
        } 
        ((Input)gates.get(inputName)).setValue(value);
    }
    
    /**
     * Select the gate to be the output of the circuit
     * @param gateName name of the gate to select
     */
    public void setOutputGate(String gateName){
        if (!gates.containsKey(gateName)) {
            throw new Error(gateName + " not found.");
        }
        this.outputGateName = gateName;
    }
    public void addCustomBinaryGate(CustomBinaryOperation operation, String gateName){
        CustomBinaryGate gate = new CustomBinaryGate(operation);
        gates.put(gateName, gate);
    }
    
    public void addCustomUnaryGate(CustomUnaryOperation operation, String gateName){
        CustomUnaryGate gate = new CustomUnaryGate(operation);
        gates.put(gateName, gate);
    }

    public void addNotFloatGate(String not) {
        NotFloat gate = new NotFloat();
        gates.put(not, gate);
    }

    public void setInputFloatValue(String inputName, double value) {
        if (!gates.containsKey(inputName)) {
            throw new Error(inputName + " not found.");
        }
        
        Gate input = gates.get(inputName);
        if (!(input instanceof InputFloat)) {
          throw new Error(inputName + " is not a float input gate.");
        } 
        if (value < 0 || value > 1) {
            throw new Error("Input value should be between 0 and 1 inclusive.");
        }
        ((InputFloat)input).setValue(value);
    }

    public double runFloat() {
        if (outputGateName == null) {
            throw new Error("Set output gate first.");
        }
        if (!gates.containsKey(outputGateName)){
            throw new Error("output gate " + outputGateName + " not found.");
        }
        
        Gate outputGate = gates.get(outputGateName);
        
        if (!(outputGate instanceof FloatFunctions)){
            throw new Error(outputGateName + " is a binary gate. use run() instead.");
        }
        
        return ((FloatFunctions) outputGate).getFloatValue().getDouble();
    }

    public void addInputFloat(String inputGateName) {
        InputFloat input = new InputFloat();
        gates.put(inputGateName, input);
    }

    public void addGteGate(String inputGateName) {
        Gate gte = new Gte();
        gates.put(inputGateName, gte);
    }

    public void addAndFloatGate(String gateName) {
        Gate andFloatGate = new AndFloat();
        gates.put(gateName, andFloatGate);
    }

    public void addOrFloatGate(String gateName) {
        Gate orFloatGate = new OrFloat();
        gates.put(gateName, orFloatGate);
    }

    public void addCustomUnaryFloatGate(CustomUnaryFloatOperation customUnaryFloatOperation, String gateName) {
        Gate gate = new CustomUnaryFloatGate(customUnaryFloatOperation);
        gates.put(gateName, gate);
    }

    public void addCustomBinaryFloatGate(CustomBinaryFloatOperation customBinaryFloatOperation, String gateName) {
        Gate gate = new CustomBinaryFloatGate(customBinaryFloatOperation);
        gates.put(gateName, gate);
    }

}
