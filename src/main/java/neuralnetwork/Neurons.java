package neuralnetwork;

import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;

/**
 * Created by kaustubh on 4/23/17.
 */
public class Neurons {
    private INDArray neurons;

    Neurons(double neurons[])
    {
        this.neurons = Nd4j.create(neurons);
    }

    public void setData(double input[])
    {
        neurons.cleanup();
        neurons = Nd4j.create(input);
    }
}
