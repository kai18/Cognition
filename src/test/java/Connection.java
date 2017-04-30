/**
 * Created by kaustubh on 4/28/17.
 */
public class Connection {

    Neuron toNeuron;
    Neuron fromNeuron;
    double weight;

    public Neuron getToNeuron() {
        return toNeuron;
    }

    public void setToNeuron(Neuron toNeuron) {
        this.toNeuron = toNeuron;
    }

    public Neuron getFromNeuron() {
        return fromNeuron;
    }

    public void setFromNeuron(Neuron fromNeuron) {
        this.fromNeuron = fromNeuron;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getWeight()
    {
        return this.weight;
    }

    public double getWeightedOutput()
    {
        return toNeuron.getNetInput()*weight;
    }


}
