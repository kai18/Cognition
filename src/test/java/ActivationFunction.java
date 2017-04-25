import org.nd4j.linalg.api.ndarray.INDArray;

/**
 * Created by kaustubh on 4/24/17.
 */
public interface ActivationFunction {
    void activate(INDArray data);
    boolean hasDerivative();
    void activateDerivative(INDArray data);
}
