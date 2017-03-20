import jdk.nashorn.internal.runtime.regexp.joni.exception.SyntaxException;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;
import org.nd4j.linalg.ops.transforms.Transforms;

/**
 * Created by kaustubh on 3/18/17.
 */
public class HiddenLayer implements Layer {
    private int numNeurons = 0;
    private INDArray neurons = null;
    private Layer layerBefore = null;
    HiddenLayer(int numNeurons, Layer layerBefore)
    {
        System.out.println("Inside Hidden Layer");
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
            System.out.println(sum);
            System.out.println(neurons);
            neurons.getRow(i).add(sum);
            System.out.println(neurons);
        }
        Transforms.sigmoid(neurons);
        System.out.println(neurons);
        Transforms.sigmoid(neurons);
        System.out.println("Hidden layer end");
    }

    public INDArray getNeurons() {
        return neurons;
    }

    public int getNumNeurons() {
        return numNeurons;
    }
}
