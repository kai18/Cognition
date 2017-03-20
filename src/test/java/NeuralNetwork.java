import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.cpu.nativecpu.NDArray;
import org.nd4j.linalg.factory.Nd4j;
import org.nd4j.linalg.ops.transforms.Transforms;

import java.util.ArrayList;

/**
 * Created by kaustubh on 3/15/17.
 */
public class NeuralNetwork {
    int numHiddenLayers;
    INDArray inputLayer;
    INDArray outputLayer;
    ArrayList hiddenLayers;
    ArrayList weightArrays;


    NeuralNetwork(int numHiddenLayers, double input[])
    {
        weightArrays = new ArrayList(numHiddenLayers);
        this.numHiddenLayers = numHiddenLayers;
        inputLayer = Nd4j.create(input);
        inputLayer.transposei();
        outputLayer = Nd4j.zeros(input.length, 1);
        hiddenLayers = new ArrayList();
        for(int i = 0; i < numHiddenLayers; i++)
        {
            INDArray weightArray = Nd4j.rand(input.length, input.length);
            weightArrays.add(i , weightArray);
            INDArray hiddenLayer = Nd4j.zeros(6,1);
            hiddenLayers.add(hiddenLayer);
        }
    }

    public void feedForward()
    {


    }
}
