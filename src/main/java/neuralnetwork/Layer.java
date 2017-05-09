package neuralnetwork;

import java.util.ArrayList;

/**
 * Created by kaustubh on 4/24/17.
 */
public interface Layer {
    int numNeurons = 0;
    ArrayList<Neuron> neurons = null;

    int getNumNeurons();

    ArrayList<Neuron> getNeurons();

    void setNeurons(ArrayList<Neuron> neurons);

    void setNeurons(double input[]);
}
