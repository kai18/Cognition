import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.cpu.nativecpu.NDArray;
import org.nd4j.linalg.factory.Nd4j;
import org.nd4j.linalg.ops.transforms.Transforms;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

/**
 * Created by kaustubh on 3/16/17.
 */
public class Nd4jtest {

    static double[] in1 = {0, 1, 0, 1};
    static double[] in2 = {1, 0, 1, 0};


    static double[] in3 = {1 , 1, 0, 1};

    static double[] out1 = {0.9f, 0.1f, 0.1f};
    static double[] out2 = {0.1f, 0.1f, 0.9f};
    static double[] out3 = {0.1f, 0.9f, 0.1f};

    static double[] test1 = {0.1f, 0.1f, 0.9f};
    static double[] test2 = {0.1f, 0.9f, 0.1f};
    static double[] test3 = {0.9f, 0.1f, 0.1f};

    public static void main(String args[])
    {

       /* BackPropagation backProp = new BackPropagation(1, new int[]{5}, .5);
        backProp.train(in1, out1);
        backProp.train(in2, out2);
        backProp.train(in3, out3);*/
       double temp[] = {1, -1, 1, -1};

       INDArray temp1 = Nd4j.create(temp);
       INDArray temp2 = Nd4j.create(temp, new int[]{temp.length, 1});
       System.out.println(temp1.mmul(temp2));
       HopfieldNeuralNetwork net = new HopfieldNeuralNetwork(in1.length);
       net.train(in1);
       net.train(in2);
       net.recall(in1);
       net.recall(in2);
       net.recall(in3);

    }
}
