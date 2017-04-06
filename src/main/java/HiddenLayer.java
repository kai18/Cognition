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

    HiddenLayer(int numNeurons, Layer layerBefore) {
        System.out.println("Inside Hidden Layer");
        this.layerBefore = layerBefore;
        this.numNeurons = numNeurons;
        neurons = Nd4j.zeros(numNeurons);
        System.out.println(neurons);
    }

    public void activate(INDArray weights) {
        System.out.println("Hidden Layer");
        System.out.println(weights);

        INDArray previousNeurons = layerBefore.getNeurons();
        System.out.println(layerBefore.getNeurons());

        for (int i = 0; i < numNeurons; i++) {
            INDArray temp = weights.getRow(i);
            System.out.println(temp);
            System.out.println(neurons);
            double change = previousNeurons.mul(temp).sumNumber().doubleValue();
            neurons.getColumn(i).addi(change);
            System.out.println(change);
            System.out.println(neurons);
        }
        System.out.println(neurons);
        Transforms.sigmoid(neurons, false);
        System.out.println(neurons);
        System.out.println("Hidden layer end");
    }

    public INDArray getNeurons() {
        return neurons;
    }

    public void setNeurons(INDArray input) {

    }

    public int getNumNeurons() {
        return numNeurons;
    }
}
