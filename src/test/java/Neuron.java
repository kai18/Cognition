import java.util.ArrayList;

/**
 * Created by kaustubh on 4/28/17.
 */
public class Neuron {
    ActivationFunction function;
    ArrayList<Connection> inputConnections;
    ArrayList<Connection> outputConnections;
    ActivationFunction input;
    ActivationFunction output;

    public void getOutput(){

    }

    public void getInput()
    {
        input.activate(inputConnections);
    }
}
