import java.util.ArrayList;

/**
 * Created by kaustubh on 4/29/17.
 */
public class BackpropagationLearning implements LearningMethod {

    NeuralNetworkTopology neuralNetwork = null;
    double input[] = null;
    double expectedOutput[] = null;
    BackpropagationLearning(NeuralNetworkTopology neuralNetwork)
    {
        this.neuralNetwork = neuralNetwork;

    }
    public void learn(double input[], double expectedOutput[]) {
        this.input = input;
        this.expectedOutput = expectedOutput;
        Layer inputLayer = neuralNetwork.getInputLayer();
        inputLayer.setNeurons(input);
        ArrayList <Layer> hiddenLayers = neuralNetwork.getHiddenLayers();
        Layer outputLayer = neuralNetwork.getOutputLayer();
        calculateOutputLayerErrors(outputLayer);
        calculateHiddenLayerErrors(hiddenLayers);
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

    private void calculateOutputLayerErrors(Layer outputLayer)
    {
        ArrayList<Neuron> neurons = outputLayer.getNeurons();
        int i = 0;
        for (Neuron neuron: neurons) {
            ActivationFunction function = neuron.getActivationFunction();
            neuron.setError(expectedOutput[i++]-(neuron.getOutput()*
                    function.getDerivativeOutput(neuron.getOutput())));
        }
    }

    private void calculateHiddenLayerErrors(ArrayList<Layer> hiddenLayers)
    {
        for (Layer hiddenLayer:hiddenLayers)
        {
            ArrayList<Neuron> neurons = hiddenLayer.getNeurons();
            for (Neuron neuron: neurons)
            {
                ArrayList<Connection> cons = neuron.getOutputConnection();
                double error= 0;
                for (Connection con: cons) {
                    error += con.getWeight()*con.getToNeuron().getError();
                }
                neuron.setError(error);
            }
        }
    }

    private void updateWeights()
    {

    }


}
