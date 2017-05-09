package neuralnetwork;

import java.util.ArrayList;

/**
 * Created by kaustubh on 4/28/17.
 */
public interface Neuron {

    ArrayList<Connection> inputConnections = null;
    ArrayList<Connection> outputConnections = null;
    InputFunction inputFunction = null;
    ActivationFunction activationFunction = null;
    double netInput = 0;
    double output = 0;
    double error = 0;

    public double getValue();

    public void setValue(double value);

    public double fire();

    public double getNetInput();

    public double getOutput();

    public void addInputConnection(Connection con);

    public void addOutputConnection(Connection con);

    public double getError();

    public void setError(double error);

    public abstract ActivationFunction getActivationFunction();

    public abstract void setActivationFunction(ActivationFunction function);

    public ArrayList<Connection> getOutputConnection();

    public ArrayList<Connection> getInputConnections();
}
