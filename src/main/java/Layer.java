import org.nd4j.linalg.api.ndarray.INDArray;

/**
 * Created by kaustubh on 3/18/17.
 */
public interface Layer {
    int numNeurons = 0;
    INDArray neurons = null;
    public INDArray getNeurons();
    public int getNumNeurons();
    public void activate(INDArray weights);

}
