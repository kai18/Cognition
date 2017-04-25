import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.ops.transforms.Transforms;

/**
 * Created by kaustubh on 4/24/17.
 */
public class ActivationTanH implements ActivationFunction {
    public void activate(INDArray data) {
        Transforms.tanh(data, false);
    }

    public boolean hasDerivative() {
        return true;
    }

    public void activateDerivative(INDArray data) {

    }
}
