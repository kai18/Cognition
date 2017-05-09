package neuralnetwork;

import java.util.ArrayList;

/**
 * Created by kaustubh on 4/24/17.
 */
public interface NeuralNetworkTopology {
    ArrayList<Layer> layers = null;
    Layer inputLayer = null;
    ArrayList<Layer> hiddenLayers = null;
    Layer outputLayer = null;

    public void getWeight();

    public void setWeight();

    public Layer getInputLayer();

    public Layer getOutputLayer();

    public Layer getLayer(int i);

    public ArrayList<Layer> getHiddenLayers();

    public Layer getHiddenLayer(int i);

    ArrayList<Layer> getLayers();

    public void addInputLayer(Layer layer);

    public void addHiddenLayer(Layer layer);

    public void addOutputLayer(Layer layer);
}
