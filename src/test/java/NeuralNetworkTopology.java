import java.util.ArrayList;

/**
 * Created by kaustubh on 4/24/17.
 */
public interface NeuralNetworkTopology {
    public void getWeight();
    public void setWeight();
    public Layer getInputLayer();
    public Layer getOutputLayer();
    public Layer getLayer(int i);
    public ArrayList<Layer> getHiddenLayers();
    public Layer getHiddenLayer(int i);
    ArrayList<Layer> getLayers();

}
