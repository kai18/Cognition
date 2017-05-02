/**
 * Created by kaustubh on 4/24/17.
 */
public class NeuralNetworkBuilder {

    private NeuralNetworkTopology topology;
    private int numHiddenLayers;
    private int numHiddenLayerUnits[];

    public NeuralNetworkBuilder(int numHiddenLayers, int[] numHiddenLayerUnits,
                                int numInputLayerUnits, int numOutputLayerUnits,
                                NeuralNetworkTopology topology) {
        this.numHiddenLayers = numHiddenLayers;
        this.numHiddenLayerUnits = numHiddenLayerUnits;
        this.numInputLayerUnits = numInputLayerUnits;
        this.numOutputLayerUnits = numOutputLayerUnits;
        this.topology = topology;
        Layer inputLayer = new InputLayer();
        topology.addInputLayer(inputLayer);

    }

    private int numInputLayerUnits;
    private int numOutputLayerUnits;


}
