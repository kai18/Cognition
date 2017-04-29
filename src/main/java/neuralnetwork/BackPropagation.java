package neuralnetwork;

import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;
import org.nd4j.linalg.ops.transforms.Transforms;

import java.util.ArrayList;

/**
 * Created by kaustubh on 3/20/17.
 */
public class BackPropagation implements NeuralNetwork{


    int numInputLayerNeurons;
    int numHiddenLayers
    int numHiddenLayerNeurons[];

    public BackPropagation(int numInputLayerNeurons, int numHiddenLayers,
                           int[] numHiddenLayerNeurons, int numOuputLayerNeurons,
                           double learningRate)
    {
        this.numInputLayerNeurons = numInputLayerNeurons;
        this.numHiddenLayers = numHiddenLayers;
        this.numHiddenLayerNeurons = numHiddenLayerNeurons;
        this.numOuputLayerNeurons = numOuputLayerNeurons;
        this.learningRate = learningRate;
    }

    int numOuputLayerNeurons;
    double learningRate;


    public void recall(double[] input) {

    }

    public void train(double[] input, double[] output) {

    }
}
