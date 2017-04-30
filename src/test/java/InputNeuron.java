import java.util.ArrayList;

/**
 * Created by kaustubh on 4/30/17.
 */
public class InputNeuron implements Neuron{
    ArrayList<Connection> inputConnections = null;
    ArrayList<Connection> outputConnections = null;
    double netInput = 0;
    double output = 0;

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
}
