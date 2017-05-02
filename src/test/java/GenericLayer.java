import java.util.ArrayList;

/**
 * Created by kaustubh on 5/1/17.
 */
public class GenericLayer{

    ArrayList <Neuron> neurons;
    String activationFunction= null;
    String inputFunction = null;

    public GenericLayer(String activationFunction, String inputFunction) {
        this.neurons = new ArrayList<Neuron>();
        this.activationFunction = activationFunction;
        this.inputFunction = inputFunction;
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
            Neuron n = new InputNeuron();
            n.setValue(in);
            n.setActivationFunction(ActivationFunctionFactory.
                    getActivationFunction(activationFunction));
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
