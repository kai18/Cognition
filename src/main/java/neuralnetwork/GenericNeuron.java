package neuralnetwork;

import java.util.ArrayList;

/**
 * Created by kaustubh on 4/30/17.
 */
public class GenericNeuron implements Neuron {
    private ArrayList<Connection> inputConnections;
    private ArrayList<Connection> outputConnections;
    private InputFunction inputFunction;
    private ActivationFunction activationFunction;
    private double netInput = 0;
    private double output = 0;
    private double error = 0;

    public double getValue() {
        return this.netInput;
    }

    public void setValue(double value) {
        this.netInput = value;
    }

    public double fire() {
        this.output = this.activationFunction.getOutput(this.netInput);
        return output;
    }

    public double getNetInput() {
        this.netInput = this.inputFunction.getInput(inputConnections);
        return this.netInput;

    }

    public double getOutput() {
        return this.output;
    }

    public void addInputConnection(Connection con) {
        inputConnections.add(con);
    }

    public void addOutputConnection(Connection con) {
        outputConnections.add(con);
    }

    public double getError() {
        return error;
    }

    public void setError(double error) {
        this.error = error;
    }

    public ActivationFunction getActivationFunction() {
        return this.activationFunction;
    }

    public void setActivationFunction(ActivationFunction function) {
        this.activationFunction = function;
    }

    public ArrayList<Connection> getOutputConnection() {
        return outputConnections;
    }

    public ArrayList<Connection> getInputConnections() {
        return inputConnections;
    }

}
