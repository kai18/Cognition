import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;

import java.util.ArrayList;

/**
 * Created by kaustubh on 3/20/17.
 */
public class BackPropagation {

    private int numHiddenLayers = 0;
    int numhiddenNeurons[];
    private double in[] = null;
    private Layer inputLayer = null;
    private Layer outputLayer = null;
    private Layer hiddenLayers[] = null;
    private ArrayList <INDArray> weights;
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
        weights = new ArrayList<INDArray>(numHiddenLayers+1);
        for (int i = 0; i < numHiddenLayers; i++)
        {
            INDArray weight = Nd4j.zeros(numHiddenNeurons[i], numHiddenNeurons[i]);
            weights.add(weight);
        }
        INDArray weight = Nd4j.rand(outputLayer.getNumNeurons());
        weights.add(weight);
    }

    private void feedForward()
    {
        while(true)
        {
            for (int i = 0; i < numHiddenLayers; i++)
                hiddenLayers[i].activate(weights.get(i));
        }
    }
}
