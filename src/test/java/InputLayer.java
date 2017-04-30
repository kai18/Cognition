import jdk.internal.util.xml.impl.Input;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kaustubh on 4/30/17.
 */
public class InputLayer  implements Layer {

    int numNeurons;
    ArrayList <Neuron> neurons;
    InputFunction inputFunction;
    ActivationFunction activationFunction;

    public InputLayer(InputFunction inputFunctionfunction,
                      ActivationFunction activationFunction) {
        this.inputFunction = inputFunctionfunction;
        this.neurons = new ArrayList<Neuron>();
    }

    public int getNumNeurons() {
        return neurons.size();
    }

    public ArrayList<Neuron> getNeurons() {
        return neurons;
    }

    public void setNeurons(double[] input) {
        for (double in: input)
        {
            
        }

    }

    public void setNeurons(ArrayList<Neuron> neurons) {

    }

    public void addNeuron(Neuron neuron)
    {
        if(neuron != null)
            neurons.add(neuron);
        else
            System.out.println("Null neuron");
    }

    public void addNeuron(int index, Neuron neuron)
    {
        if(neuron!=null)
            neurons.add(index, neuron);
    }

    public void removeNeuron(int index)
    {
        if (!neurons.isEmpty())
            neurons.remove(index);
    }

}
