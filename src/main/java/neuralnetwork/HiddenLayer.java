package neuralnetwork;

import org.nd4j.linalg.api.ndarray.INDArray;

/**
 * Created by kaustubh on 3/18/17.
 */
public class HiddenLayer implements Layer {

    private Neurons neurons;
    HiddenLayer(double input[])
    {
        neurons = new Neurons(input);
    }
    public INDArray getNeurons() {
        return null;
    }

    public void setNeurons(double input[]) {
        neurons.setData(input);

    }

    public int getNumNeurons() {
        return 0;
    }

    public void activate(INDArray weights) {

    }
}
