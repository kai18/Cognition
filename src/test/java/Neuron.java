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
    double output = 0;
    double error = 0;

    public Neuron(InputFunction inputFunction,
                  ActivationFunction activationFunction) {
        this.inputConnections = inputConnections;
        this.outputConnections = outputConnections;
        this.inputFunction = inputFunction;
        this.activationFunction = activationFunction;
        this.netInput = 0d;
        this.output = 0d;
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

    public double getOutput()
    {
        return this.output;
    }

    public void addInputConnection(Connection con)
    {
        inputConnections.add(con);
    }

    public void addOutputConnection(Connection con)
    {
        outputConnections.add(con);
    }

    public double getError()
    {
        return error;
    }

    public void setError(double error)
    {
        this.error = error;
    }

    public ActivationFunction getActivationFunction()
    {
        return activationFunction;
    }

    public ArrayList <Connection> getOutputConnection()
    {
        return outputConnections;
    }

}
