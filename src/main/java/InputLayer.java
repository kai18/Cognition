import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;

/**
 * Created by kaustubh on 3/19/17.
 */
public class InputLayer implements Layer {

    private INDArray neurons = null;
    private int numNeurons = 0;

    InputLayer(int numNeurons)
    {
        this.numNeurons = numNeurons;
        System.out.println(neurons);
    }

    InputLayer(int numNeurons, double input[])
    {
        this.numNeurons = numNeurons;
        neurons = Nd4j.create(input);
        System.out.println(neurons);
    }

    public INDArray getNeurons() {
        return neurons;
    }

    public int getNumNeurons() {
        return numNeurons;
    }

    public void setNeurons(INDArray neurons) {
        this.neurons = neurons;
    }

    public void activate(INDArray weights) {

    }
}
