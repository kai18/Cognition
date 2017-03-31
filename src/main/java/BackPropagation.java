import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;
import org.nd4j.linalg.ops.transforms.Transforms;

import java.util.ArrayList;

/**
 * Created by kaustubh on 3/20/17.
 */
public class BackPropagation implements NeuralNetwork {

    private int numHiddenLayers = 0;
    private int numhiddenNeurons[];
    private double in[] = null;
    private InputLayer inputLayer = null;
    private OutputLayer outputLayer = null;
    private HiddenLayer hiddenLayers[] = null;
    private ArrayList<INDArray> weights;
    private ArrayList errors = null;
    private double trainingRate = 0;
    private INDArray expectedOutput = null;

    BackPropagation(int numHiddenLayers,
                    int numHiddenNeurons[], double trainingRate, int inputSize) {
        this.trainingRate = trainingRate;
        this.numhiddenNeurons = numHiddenNeurons;
        this.numHiddenLayers = numHiddenLayers;
        errors = new ArrayList(numHiddenLayers+1);

        hiddenLayers = new HiddenLayer[numHiddenLayers];
        hiddenLayers[0] = new HiddenLayer(numHiddenNeurons[0], inputLayer);

        weights = new ArrayList<INDArray>(numHiddenLayers + 1);
        weights.add(Nd4j.rand(numHiddenNeurons[0], inputSize));

        for (int i = 1; i < numHiddenLayers; i++) {
            hiddenLayers[i] = new HiddenLayer(numHiddenNeurons[i], hiddenLayers[i - 1]);
            weights.add(Nd4j.rand(numHiddenNeurons[i], numHiddenNeurons[i - 1]));
        }


        weights.add(Nd4j.rand(outputLayer.getNumNeurons(), numHiddenNeurons[numHiddenLayers - 1]));
    }

    public void train(double[] input) {

    }

    public void recall(double[] input) {

    }

    public void train(double [] input, double[] output)
    {
        this.in = input;
        this.expectedOutput = Nd4j.create(output);
        inputLayer = new InputLayer(this.in.length, this.in);
        outputLayer = new OutputLayer(this.in.length - 1,
                hiddenLayers[numHiddenLayers - 1]);


        feedForward();
        feedBackward();
        updateWeight();
    }

    private void feedBackward()
    {
        INDArray outputError = calculateOutputError(expectedOutput, outputLayer.getNeurons());
        errors.add(numHiddenLayers);
        for(int i = numHiddenLayers-1; i >= 0 ;i++)
        {
            INDArray hiddenError = Nd4j.zeros(numhiddenNeurons[i]);
            INDArray hiddenLayer = hiddenLayers[i].getNeurons();
            INDArray errorBefore = (INDArray) errors.get(numHiddenLayers-1-i);
            INDArray weight = weights.get(i);
            for (int j = 0; j < hiddenLayers[i].getNumNeurons(); j++)
                hiddenError.addi(errorBefore.mul(weight.getColumn(i).sumNumber().doubleValue()));
            hiddenError.muli(sigmoidP((INDArray) hiddenLayers[i]));
            errors.add(hiddenError);
            System.out.println(hiddenError);
        }

    }

    private void updateWeight()
    {
        for (int i = 0; i < numHiddenLayers; i++)
        {
            INDArray layer = hiddenLayers[i].getNeurons();
            INDArray weight = weights.get(i);
            weight.addi(layer.mul(trainingRate).
                    mul((INDArray) errors.get(numHiddenLayers-i)));
            System.out.println(weight);
        }

    }

    private INDArray calculateOutputError(INDArray expected, INDArray present) {
        INDArray errors = expected.sub(present);
        errors = errors.mul(sigmoidP(present));
        return errors;
    }

    private void feedForward() {
        System.out.println(weights.get(numHiddenLayers));

        for (int i = 0; i < numHiddenLayers; i++) {
            System.out.println("Executing hidden layer");
            System.out.println(weights.get(i));
            hiddenLayers[i].activate(weights.get(i));
        }
        outputLayer.activate(weights.get(numHiddenLayers));
    }

    private float sigmoid(float x) {
        return (float) (1.0f / (1.0f + Math.exp((double) (-x))));
    }

    private INDArray sigmoidP(INDArray array) {

        INDArray temp = Transforms.sigmoid(array, true);
        return temp.mul(temp.sub(1).mul(-1));
    }
}
