import java.util.ArrayList;

/**
 * Created by kaustubh on 4/30/17.
 */
public class InputNeuron implements Neuron{
   private ArrayList<Connection> inputConnections = null;
   private ArrayList<Connection> outputConnections = null;
   private double netInput = 0;
   private double output = 0;

    public void setValue(double value) {
        this.netInput = value;
    }

    public double getValue() {
        return this.netInput;
    }

    public double fire() {
        return netInput;
    }

    public double getNetInput() {
        return netInput;
    }

    public double getOutput() {
        return output;
    }

    public void addInputConnection(Connection con) {
        inputConnections.add(con);
    }

    public void addOutputConnection(Connection con) {
        outputConnections.add(con);
    }

    public double getError() {
        return 0;
    }

    public void setError(double error) {

    }

    public ActivationFunction getActivationFunction() {
        return null;
    }

    public void setActivationFunction(ActivationFunction function) {

    }

    public ArrayList<Connection> getOutputConnection() {
        return null;
    }

    public ArrayList<Connection> getInputConnections() {
        return inputConnections;
    }
}
