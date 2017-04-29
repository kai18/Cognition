import java.util.ArrayList;

/**
 * Created by kaustubh on 4/29/17.
 */
public class BackpropagationLearning implements LearningMethod {

    NeuralNetworkTopology neuralNetwork = null;
    BackpropagationLearning(NeuralNetworkTopology neuralNetwork)
    {
        this.neuralNetwork = neuralNetwork;

    }
    public void learn() {
        Layer inputLayer = neuralNetwork.getInputLayer();
        ArrayList <Layer> hiddenLayers = neuralNetwork.getHiddenLayers();
        Layer outputLayer = neuralNetwork.getOutputLayer();
    }

    private void calculateActivations(ArrayList<Layer> allLayers)
    {
        for (Layer layer:allLayers) {
            ArrayList<Neuron> neurons = layer.getNeurons();
            for (Neuron neuron: neurons) {
                neuron.fire();
            }

        }

    }
}
