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
    private InputLayer inputLayer = null;
    private OutputLayer outputLayer = null;
    private HiddenLayer hiddenLayers[] = null;
    private ArrayList <INDArray> weights;
    BackPropagation(double in[], int numHiddenLayers, int numHiddenNeurons[])
    {
        this.in = in;
        inputLayer = new InputLayer(in.length);
        hiddenLayers = new HiddenLayer[numHiddenLayers];
        hiddenLayers[0] = new HiddenLayer(numHiddenNeurons[0], inputLayer);
        for (int i = 1; i < numHiddenLayers; i++)
        {
            hiddenLayers[i] = new HiddenLayer(numHiddenNeurons[i], hiddenLayers[i-1]);
        }
        outputLayer = new OutputLayer(in.length, hiddenLayers[numHiddenLayers-1]);
        weights = new ArrayList<INDArray>(numHiddenLayers+1);
        for (int i = 0; i < numHiddenLayers; i++)
        {
            INDArray weight = Nd4j.rand(numHiddenNeurons[i], numHiddenNeurons[i]);
            weights.add(weight);
        }
        INDArray weight = Nd4j.rand(hiddenLayers[numHiddenLayers-1].getNumNeurons(), outputLayer.getNumNeurons());
        weights.add(weight);
        System.out.println("Starting");
    }

    public void feedForward()
    {
        int x= 10;
        while(x-- > 0)
        {
            System.out.println(x);
            for (int i = 0; i < numHiddenLayers; i++)
                hiddenLayers[i].activate(weights.get(i));
            outputLayer.activate(weights.get(numHiddenLayers));
        }
    }
}
