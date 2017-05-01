import java.util.ArrayList;

/**
 * Created by kaustubh on 5/1/17.
 */
public class GenericLayer{

    int numNeurons;
    ArrayList <Neuron> neurons;
    String activationFunction= null;
    String inputFunction = null;

    public int getNumNeurons() {
        return neurons.size();
    }

    public ArrayList<Neuron> getNeurons() {
        return neurons;
    }

    public void setNeurons(double[] input) {
        for (double in: input)
        {
            Neuron n = new InputNeuron();
            n.setValue(in);
            neurons.add(n);
        }
    }

    public void setNeurons(ArrayList<Neuron> neurons) {
        this.neurons = neurons;
    }

    public void addNeuron(Neuron neuron)
    {
        neurons.add(neuron);
    }
}
