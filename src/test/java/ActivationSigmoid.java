import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.ops.transforms.Transforms;

/**
 * Created by kaustubh on 4/24/17.
 */
public class ActivationSigmoid implements ActivationFunction {
    public void activate(INDArray data) {
        Transforms.sigmoid(data, false);
    }

    public boolean hasDerivative() {
        return true;
    }

    public void activateDerivative(INDArray data) {
        data.muli(data.sub(1).mul(-1));
    }
}
