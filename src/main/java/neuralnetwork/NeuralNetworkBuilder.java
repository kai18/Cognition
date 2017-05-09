package neuralnetwork;

import java.util.ArrayList;

/**
 * Created by kaustubh on 4/24/17.
 */
public class NeuralNetworkBuilder {

    private NeuralNetworkTopology topology;
    private ArrayList<Integer> numNeuronsinLayers = null;

    public NeuralNetworkBuilder(ArrayList<Integer> numNeuronsinLayers,
                                NeuralNetworkTopology topology) {
        this.numNeuronsinLayers = numNeuronsinLayers;
        Layer inputLayer = new InputLayer();
    }

    public void addNeurons() {
        for (int numNeurons : numNeuronsinLayers) {
            while (numNeurons-- > 0) {
                //Layer layer = new GenericLayer();
            }

        }
    }


}
