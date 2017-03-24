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
    private double expectedOutput[] = null;
    BackPropagation(double in[], double expectedOutput[], int numHiddenLayers, int numHiddenNeurons[])
    {
       this.in = in;
       this.expectedOutput = expectedOutput;
       this.numhiddenNeurons = numHiddenNeurons;
       this.numHiddenLayers = numHiddenLayers;

       hiddenLayers = new HiddenLayer[numHiddenLayers];
       inputLayer = new InputLayer(this.in.length, this.in);
       hiddenLayers[0] = new HiddenLayer(numHiddenNeurons[0], inputLayer);

       weights = new ArrayList<INDArray>(numHiddenLayers+1);
       weights.add(Nd4j.rand(numHiddenNeurons[0], this.in.length));

       for (int i = 1; i < numHiddenLayers; i++) {
           hiddenLayers[i] = new HiddenLayer(numHiddenNeurons[i], hiddenLayers[i - 1]);
           weights.add(Nd4j.rand(numHiddenNeurons[i], numHiddenNeurons[i-1]));
       }

       outputLayer = new OutputLayer(this.in.length-1, hiddenLayers[numHiddenLayers-1]);

       weights.add(Nd4j.rand(outputLayer.getNumNeurons(), numHiddenNeurons[numHiddenLayers-1]));
    }


   /* private INDArray calculateError(INDArray expected, INDArray present)
    {
        INDArray error = expected.subi(present);

    }*/

    public void feedForward()
    {
        System.out.println(weights.get(numHiddenLayers));

        for (int i = 0; i < numHiddenLayers; i++) {
            System.out.println("Executing hidden layer");
            System.out.println(weights.get(i));
            hiddenLayers[i].activate(weights.get(i));
        }
        outputLayer.activate(weights.get(numHiddenLayers));
    }
}
