/**
 * Created by kaustubh on 4/28/17.
 */
public class Connection {
    Neuron to;
    Neuron from;
    double weight;

    public double getWeight()
    {
        return this.weight;
    }

    public double getWeightedOutput()
    {
        return to.getNetInput()*weight;
    }
}
