import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.cpu.nativecpu.NDArray;
import org.nd4j.linalg.factory.Nd4j;
import org.nd4j.linalg.ops.transforms.Transforms;

import java.util.ArrayList;

/**
 * Created by kaustubh on 3/15/17.
 */
public class NeuralNetwork {
    public static void main(String args[])
    {
        double input [] = {1.2, 0, 1, 1.9, .8, .6 , .9, .23, .50, .78};
        INDArray temp = Nd4j.create(input);
        INDArray temp1 = Nd4j.create(input);

        System.out.println(temp.mul(temp1));
        System.out.println(temp.transpose().mul(temp1.transpose()));
    }
}
