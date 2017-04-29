import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.ops.transforms.Transforms;

import java.util.ArrayList;

/**
 * Created by kaustubh on 4/24/17.
 */
public class ActivationSigmoid implements ActivationFunction {
    public void activate(INDArray data) {
        Transforms.sigmoid(data, false);
    }

    double output = 0;
    public double getOutput(double netInput) {
        double den = 1d - Math.exp(-netInput);
        this.output = 1/den;
        return this.output;

    }

    public boolean hasDerivative() {
        return true;
    }

    public double getDerivativeOutput(double netInput) {
        return output*(1-output);

    }
}