package neuralnetwork;

import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.ops.transforms.Transforms;

/**
 * Created by kaustubh on 4/24/17.
 */
public class ActivationSigmoid implements ActivationFunction {
    private double output = 0;

    public void activate(INDArray data) {
        Transforms.sigmoid(data, false);
    }

    public double getOutput(double netInput) {
        double den = 1d - Math.exp(-netInput);
        this.output = 1 / den;
        return this.output;

    }

    public boolean hasDerivative() {
        return true;
    }

    public double getDerivativeOutput(double netInput) {
        return getOutput(netInput) * (1 - getOutput(netInput));

    }

    public double getDerivativeOutput() {
        return output * (1 - output);
    }
}
