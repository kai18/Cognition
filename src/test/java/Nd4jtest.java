import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;

/**
 * Created by kaustubh on 3/16/17.
 */
public class Nd4jtest {
    public static void main(String args[])
    {
        double input[] = {1.2, 0, 1, 1.9, .8, .6 , .9, .23, .50, .78};
        INDArray in = Nd4j.create(input);
        System.out.println(in);
        System.out.println(in.transposei());
        System.out.println(in);
        System.out.println(in.reshape(2,5).transposei());
        System.out.println(in.sumNumber().doubleValue());
        NeuralNetwork network = new NeuralNetwork(1, input);
        System.out.println(in.getColumn(2).muli(2));
        System.out.print(in);
        network.feedForward();
    }
}
