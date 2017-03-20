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
        neurons = Nd4j.zeros(numNeurons, 1);
        System.out.println(neurons);
    }

    public INDArray getNeurons() {
        return neurons;
    }

    public int getNumNeurons() {
        return numNeurons;
    }

    public void activate(INDArray weights) {

    }
}
