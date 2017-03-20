import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;
import org.nd4j.linalg.ops.transforms.Transforms;

/**
 * Created by kaustubh on 3/20/17.
 */
public class OutputLayer implements Layer {

    private int numNeurons = 0;
    private INDArray neurons = null;
    private Layer layerBefore = null;

    OutputLayer(int numNeurons, Layer layerBefore)
    {
        System.out.println("Inside Output Layer");
        this.layerBefore = layerBefore;
        this.numNeurons = numNeurons;
        neurons = Nd4j.zeros(numNeurons, 1);
        System.out.println(neurons);
    }

    public void activate(INDArray weights)
    {
        INDArray previousNeurons = layerBefore.getNeurons();
        for (int i = 0 ; i < layerBefore.getNumNeurons(); i++)
        {
            INDArray change = weights.getColumn(i).mul(previousNeurons.getDouble(i));
            System.out.println(change);
            double sum = change.sumNumber().doubleValue();
        }
        System.out.println(neurons);
        Transforms.sigmoid(neurons);
        System.out.println("Output layer end");
    }

    public INDArray getNeurons() {
        return neurons;
    }

    public int getNumNeurons() {
        return numNeurons;
    }
}
