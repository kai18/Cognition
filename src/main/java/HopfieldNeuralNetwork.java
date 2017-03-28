import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;
import org.nd4j.linalg.ops.transforms.Transforms;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;

/**
 * Created by kaustubh on 3/28/17.
 */
public class HopfieldNeuralNetwork {

    private INDArray weight = null;
    Layer inputLayer = null;


    public HopfieldNeuralNetwork(int inputSize)
    {
        inputLayer = new InputLayer(inputSize);
        weight = Nd4j.zeros(inputSize, inputSize);
    }

    public void train(double input[])
    {
        toBipolar(input);

        inputLayer.setNeurons(Nd4j.create(input));
        System.out.println(inputLayer.getNeurons());
        System.out.println(weight);
        INDArray tempWeight = Nd4j.create(multiply(input));
        System.out.println(tempWeight);
       // INDArray tempWeight = inputLayer.getNeurons().mmul(inputLayer.getNeurons().transpose());
        weight.addi(tempWeight);
        System.out.println(weight);
    }

    public void recall(double pattern[])
    {
        INDArray patternArray = Nd4j.create(pattern);
        double out[] = new double[inputLayer.getNumNeurons()];
        for (int i = 0; i < inputLayer.getNumNeurons(); i++)
        {
            INDArray temp = patternArray.mul(weight.getRow(i));
            double output = temp.sumNumber().doubleValue();
            out[i] = output;
        }
        for (int i = 0; i < out.length; i++)
            System.out.print(out[i]+" ");
        System.out.println();
        toBinary(out);
        for (int i = 0; i < out.length; i++)
            System.out.println(out[i]);

    }

    public void toBipolar(double pattern[]) {
        for (int i = 0; i < pattern.length; i++)
        {
            if(pattern[i]<=0)
                pattern[i] = -1;
            else
                pattern[i] = 1;
        }
        System.out.println("P");
        System.out.println(Nd4j.create(pattern));
    }

    public void toBinary(double pattern[])
    {
        for (int i = 0; i < pattern.length; i++)
        {
            if(pattern[i] <= -1)
                pattern[i] = 0;
            else
                pattern[i] = 1;
        }
    }

    public double[][] multiply(double input1[])
    {
        double ans [][] = new double[input1.length][input1.length];
        for (int i = 0; i < input1.length; i++)
        {
            for (int j = 0; i < input1.length; j++)
            {
                ans[i][j] += input1[i]*input1[j];
            }
        }
        return ans;
    }
}
