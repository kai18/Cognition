import java.util.ArrayList;

/**
 * Created by kaustubh on 4/28/17.
 */
public class Neuron {

    ArrayList<Connection> inputConnections;
    ArrayList<Connection> outputConnections;
    InputFunction inputFunction;
    ActivationFunction activationFunction;
    double netInput = 0;
    double output;

    public Neuron(InputFunction inputFunction,
                  ActivationFunction activationFunction) {
        this.inputConnections = inputConnections;
        this.outputConnections = outputConnections;
        this.inputFunction = inputFunction;
        this.activationFunction = activationFunction;
    }


    public double fire(){
        this.output = this.activationFunction.getOutput(this.netInput);
        return output;
    }

    public double getNetInput()
    {
        this.netInput = this.inputFunction.getInput(inputConnections);
        return this.netInput;

    }

    public void addInputConnection(Connection con)
    {
        inputConnections.add(con);
    }

    public void addOutputConnection(Connection con)
    {
        outputConnections.add(con);
    }

}
