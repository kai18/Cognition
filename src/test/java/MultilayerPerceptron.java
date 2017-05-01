import java.util.ArrayList;

/**
 * Created by kaustubh on 4/30/17.
 */
public class MultilayerPerceptron implements NeuralNetworkTopology {
    ArrayList<Layer> layers;
    Layer inputLayer;
    ArrayList<Layer> hiddenLayers;
    Layer outputLayer;

    public void getWeight() {

    }

    public void setWeight() {

    }

    public Layer getInputLayer() {
        return inputLayer;
    }

    public Layer getOutputLayer() {
        return outputLayer;
    }

    public Layer getLayer(int i) {
        return layers.get(i);
    }

    public ArrayList<Layer> getHiddenLayers() {
        return null;
    }

    public Layer getHiddenLayer(int i) {
        return hiddenLayers.get(i);
    }

    public ArrayList<Layer> getLayers() {
        return layers;
    }

    public void addInputLayer(Layer layer)
    {
        this.layers.add(layer);
        this.inputLayer = layer;
    }
    public void addHiddenLayer(Layer layer)
    {
        layers.add(layer);
        hiddenLayers.add(layer);
    }

    public void addOutputLayer(Layer layer)
    {
        layers.add(layer);
        this.outputLayer = outputLayer;
    }
}
