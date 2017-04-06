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

    OutputLayer(int numNeurons, Layer layerBefore) {
        System.out.println("Inside Output Layer");
        this.layerBefore = layerBefore;
        this.numNeurons = numNeurons;
        neurons = Nd4j.zeros(numNeurons);
        System.out.println(neurons);
    }

    public void activate(INDArray weights) {
        System.out.println("Inside output layer");
        System.out.println(weights);
        INDArray previousNeurons = layerBefore.getNeurons();
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
        Transforms.sigmoid(neurons);
        System.out.println("Output layer end");
    }

    public INDArray getOuput() {
        return neurons;
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
