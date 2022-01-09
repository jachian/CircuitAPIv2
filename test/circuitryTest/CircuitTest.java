/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package circuitryTest;

import circuitry.Circuit;
import circuitry.CustomBinaryOperation;
import circuitry.CustomUnaryFloatOperation;
import circuitry.CustomUnaryOperation;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 20215191
 */
public class CircuitTest {
    
    public CircuitTest() {
    }

    /** 
     * Create a circuit to evaluate x1 and x2 and then
     * verify that its result is false for input (false, true) and
     * it is true for input (true, true).
     */
    @Test
    public void testX1andX2() {
        // make the circuit       
	Circuit c = new Circuit();
        
        c.addInput("X1");
        c.addInput("X2");
        c.addAndGate("and");
        
        c.connect("and", "X1", 1);
        c.connect("and", "X2", 2);
        
        c.setOutputGate("and");
        
        // test the circuit for different inputs        
 	c.setInputValue("X1", false);
	c.setInputValue("X2", true);
        
        assertEquals(false, c.run());      
        
        c.setInputValue("X1", true);
        c.setInputValue("X2", true);
        
        assertEquals(true, c.run());          
    }
    
        /** 
     * Create a circuit to evaluate (x1 and x2) or x3 and then
     * verify that its result is false for input (false, true, false) and
     * it is true for input (false, false, true).
     */
   
 
    @Test
    public void testX1andX2orX3() {
        // make the circuit        
	Circuit c = new Circuit();
        
        c.addInput("X1");
        c.addInput("X2");
        c.addInput("X3");
        c.addAndGate("and");
        c.addOrGate("or");
        
        c.connect("and", "X1", 1);
        c.connect("and", "X2", 2);
        c.connect("or", "and", 1);
        c.connect("or", "X3", 2);
        
        c.setOutputGate("or");
        
        // test the circuit for different inputs        
        c.setInputValue("X1", false);
        c.setInputValue("X2", true);
        c.setInputValue("X3", false);
        assertEquals(false, c.run());  
        
        c.setInputValue("X1", true);
        c.setInputValue("X2", false);
        c.setInputValue("X3", true);
        assertEquals(true, c.run());      	  
    }

        /** 
     * Create a circuit to evaluate (x1 or not(x1)) and then
     * verify that its result is true for all values of x1.
     */
    @Test
    public void testAlwaysTrue() {
        // make the circuit   
	Circuit c = new Circuit();
        
        c.addInput("X1");
        c.addNotGate("not");
        c.addOrGate("or");
        
        c.connect("or", "not", 1);
        c.connect("or", "X1", 2);
        c.connect("not", "X1", 1);
        
        c.setOutputGate("or");
        
        // test the circuit for different inputs
        c.setInputValue("X1", true);
        assertEquals(true, c.run());             
        c.setInputValue("X1", false);     
        assertEquals(true, c.run());      	 
    } 
    
    @Test
    public void testCustomBinaryGate(){
        Circuit c = new Circuit();
        
        c.addInput("X1");
        c.addInput("X2");
        c.addInput("X3");
        
        c.addOrGate("or");
        
        c.addCustomBinaryGate(new CustomBinaryOperation() {
            @Override
            public boolean doOperation(boolean op1, boolean op2) {
                return op1 ^ op2;
            }
        }, "xor");
        
        c.connect("xor", "or", 1);
        c.connect("xor", "X3", 2);
        c.connect("or", "X1", 1);
        c.connect("or", "X2", 2);
        
        c.setOutputGate("xor");
        
        c.setInputValue("X1", true);
        c.setInputValue("X2", true);
        c.setInputValue("X3", true);
        assertEquals(false, c.run());
        
        c.setInputValue("X1", true);
        c.setInputValue("X2", true);
        c.setInputValue("X3", false);
        assertEquals(true, c.run());
        
        c.setInputValue("X1", true);
        c.setInputValue("X2", false);
        c.setInputValue("X3", true);
        assertEquals(false, c.run());

    }
    
    @Test
    public void testNot(){
        Circuit c = new Circuit();
        
        c.addInput("X1");
        c.addNotGate("not");
        
        c.connect("not", "X1", 1);
        
        c.setOutputGate("not");
        
        // test the circuit for different inputs 
	    c.setInputValue("X1", true);
        
        assertEquals(false, c.run());      
        
        c.setInputValue("X1", false);
        
        assertEquals(true, c.run()); 
    }
    
    @Test
    public void testNotFloat(){
        
        Circuit c = new Circuit();
        
        c.addInputFloat("X1");
        c.addNotFloatGate("not");
        
        c.connect("not", "X1", 1);
        
        c.setOutputGate("not");
        
        // test the circuit for different inputs 
	    c.setInputFloatValue("X1", 0.3);
        
        assertEquals(0.7, c.runFloat(), 0.001);      
        
        c.setInputFloatValue("X1", 0);
        
        assertEquals(1.0, c.runFloat(), 0.001); 
        
        
        c.setInputFloatValue("X1", 1);
        
        assertEquals(0, c.runFloat(), 0.001); 
    }
    
    @Test
    public void testGte(){
        Circuit c = new Circuit();
        
        c.addInputFloat("X1");
        c.addInputFloat("X2");
        c.addGteGate("gte");
        
        c.connect("gte", "X1", 1);
        c.connect("gte", "X2", 2);
        
        c.setOutputGate("gte");
        
        // test the circuit for different inputs 
	    c.setInputFloatValue("X1", 0.3);
	    c.setInputFloatValue("X2", 0.4);
        
        assertEquals(false, c.run());      
        
        c.setInputFloatValue("X1", 0.5);
        
        assertEquals(true, c.run());
    }
    
    @Test
    public void testAndFloat(){
        Circuit c = new Circuit();
        
        c.addInputFloat("X1");
        c.addInputFloat("X2");
        c.addAndFloatGate("and");
        
        c.connect("and", "X1", 1);
        c.connect("and", "X2", 2);
        
        c.setOutputGate("and");
        
        // test the circuit for different inputs 
	    c.setInputFloatValue("X1", 0.3);
	    c.setInputFloatValue("X2", 0.3);
        
        assertEquals(0.09, c.runFloat(), 0.001);      
        
        c.setInputFloatValue("X1", 0);
        
        assertEquals(0.0, c.runFloat(), 0.001); 
        
        
        c.setInputFloatValue("X1", 1);
        
        assertEquals(0.3, c.runFloat(), 0.001); 
    }
    
    @Test
    public void testOrFloat(){
        Circuit c = new Circuit();
        c.addInputFloat("X1");
        c.addInputFloat("X2");
        c.addOrFloatGate("or");

        c.connect("or","X1", 1);
        c.connect("or","X2", 2);

        c.setOutputGate("or");

        //test the circuit for different inputs (Binary and Float)
        c.setInputFloatValue("X1", 0.6);
        c.setInputFloatValue("X2", 0.6);
        assertEquals(0.84, c.runFloat(), 0.001);

        c.setInputFloatValue("X1", 1);
        c.setInputFloatValue("X2", 1);
        assertEquals(1, c.runFloat(), 0.001);

        c.setInputFloatValue("X1", 0);
        c.setInputFloatValue("X2", 0.8);
        assertEquals(0.8, c.runFloat(), 0.001);
    }
    
    @Test
    public void testCustomBinaryFloatGate(){}
    
    @Test
    public void testCustomUnaryFloatGate(){
        Circuit c = new Circuit();
        
        c.addInputFloat("X1");
        c.addCustomUnaryFloatGate(new CustomUnaryFloatOperation() {
            @Override
            public double doOperation(double arg) {
                return 1/arg;
            }
        }, "1/x");
        
        c.connect("1/x", "X1", 1);
        
        c.setOutputGate("1/x");
        
        // test the circuit for different inputs 
        c.setInputFloatValue("X1", 0.1);
        assertEquals(10, c.runFloat(), 0.001);      
    }
    
    @Test
    public void testCustomUnaryGate(){

    }
}
