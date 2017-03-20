import org.nd4j.linalg.api.ndarray.INDArray;

import java.util.ArrayList;

/**
 * Created by kaustubh on 3/20/17.
 */
public class BackPropagation {

    int numHiddenLayers = 0;
    int numhiddenNeurons[];
    double in[] = null;
    Layer inputLayer = null;
    Layer outputLayer = null;
    Layer hiddenLayers[] = null;
    ArrayList <INDArray> weights;
    BackPropagation(double in[], int numHiddenLayers, int numHiddenNeurons[])
    {
        this.in = in;
        inputLayer = new InputLayer(in.length);
        hiddenLayers = new Layer[numHiddenLayers];
        hiddenLayers[0] = new HiddenLayer(numHiddenNeurons[0], inputLayer);
        for (int i = 1; i < numHiddenLayers; i++)
        {
            hiddenLayers[i] = new HiddenLayer(numHiddenNeurons[i], hiddenLayers[i-1]);
        }
        outputLayer = new OutputLayer(in.length, hiddenLayers[numHiddenLayers-1]);
        weights = new ArrayList<INDArray>()
    }

    private void feedForward()
    {
        while(true)
        {
            for (int i = 0; i < numHiddenLayers; i++)
            {
                hiddenLayers[i].activate();
            }
        }
    }
}
