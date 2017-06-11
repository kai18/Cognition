package neuralnetwork;

/**
 * Created by kaustubh on 6/6/17.
 */
public class ActivationRelu implements ActivationFunction {
    public double getOutput(double netInput) {
        return 0;
    }

    public boolean hasDerivative() {
        return false;
    }

    public double getDerivativeOutput(double netInput) {
        return 0;
    }
}
