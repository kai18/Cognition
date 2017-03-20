import org.nd4j.linalg.api.ndarray.INDArray;

/**
 * Created by kaustubh on 3/14/17.
 */
public class BackPropagation {

    double input[];
    NeuralNetwork backPropNetwork;
    int numHiddenlayers;
    BackPropagation(double input[])
    {
        numHiddenlayers = 1;
        this.input = input;
        backPropNetwork = new NeuralNetwork(1, input);
    }

    public void backProp()
    {

    }
}
