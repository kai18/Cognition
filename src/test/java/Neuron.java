import java.util.ArrayList;

/**
 * Created by kaustubh on 4/28/17.
 */
public class Neuron {
    ActivationFunction function;
    ArrayList<Connection> inputConnections;
    ArrayList<Connection> outputConnections;
    InputFunction inputFunction;
    ActivationFunction activationFunction;
    double netInput;
    double output;

    public void getOutput(){

    }

    public double getNetInput()
    {
        return this.netInput;

    }

}
