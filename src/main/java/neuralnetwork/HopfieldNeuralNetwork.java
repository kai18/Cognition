package neuralnetwork;

import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;

/**
 * Created by kaustubh on 3/28/17.
 */
public class HopfieldNeuralNetwork{

    Layer inputLayer = null;
    private RealMatrix weight = null;


    public HopfieldNeuralNetwork(int inputSize) {
        weight = MatrixUtils.createRealMatrix(inputSize, inputSize);
    }

    public void train(double input[]) {
        toBipolar(input);
        RealMatrix temp1 = MatrixUtils.createColumnRealMatrix(input);
        RealMatrix temp2 = MatrixUtils.createRowRealMatrix(input);
        weight = weight.add(temp1.multiply(temp2));
        for (int i = 0; i < input.length; i++)
            weight.setEntry(i, i, 0);
    }

    public void recall(double pattern[]) {
        INDArray patternArray = Nd4j.create(pattern);
        double out[] = new double[pattern.length];
        for (int i = 0; i < inputLayer.getNumNeurons(); i++) {
            INDArray temp = patternArray.mul(Nd4j.create(weight.getRow(i)));
            double output = temp.sumNumber().doubleValue();
            out[i] = output;
        }
        toBinary(out);
        System.out.println(Nd4j.create(out));
    }

    public void train(double[] inputpp, double[] output) {

    }

    private void toBipolar(double pattern[]) {
        for (int i = 0; i < pattern.length; i++) {
            if (pattern[i] <= 0)
                pattern[i] = -1;
            else
                pattern[i] = 1;
        }
    }

    private void toBinary(double pattern[]) {
        for (int i = 0; i < pattern.length; i++) {
            if (pattern[i] <= -1)
                pattern[i] = 0;
            else
                pattern[i] = 1;
        }
    }

    public double[][] multiply(double input1[]) {
        double ans[][] = new double[input1.length][input1.length];
        for (int i = 0; i < input1.length; i++) {
            for (int j = 0; i < input1.length; j++) {
                ans[i][j] += input1[i] * input1[j];
            }
        }
        return ans;
    }
}
