import java.util.ArrayList;

/**
 * Created by kaustubh on 4/30/17.
 */
public class InputLayer  implements Layer {

    int numNeurons;
    ArrayList <Neuron> neurons;
    InputLayer()
    {
        this.neurons = new ArrayList<Neuron>();
    }

    public int getNumNeurons() {
        return neurons.size();
    }

    public ArrayList<Neuron> getNeurons() {
        return neurons;
    }

    public void setNeurons(double[] input) {

    }

    public void setNeurons(ArrayList<Neuron> neurons) {

    }
}
