package neuralnetwork;

/**
 * Created by kaustubh on 4/24/17.
 */
public interface ActivationFunction {
    double getOutput(double netInput);

    boolean hasDerivative();

    double getDerivativeOutput(double netInput);
}
