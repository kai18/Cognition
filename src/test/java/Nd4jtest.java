import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;

/**
 * Created by kaustubh on 3/16/17.
 */
public class Nd4jtest {
    public static void main(String args[])
    {
        double input[] = {1.2, 0, 1, 1.9, .8, .6 , .9, .23, .50, .78};
        double output[] ={1, 0, 1, 2, 1, 1, 1, 0, 1, 1};
       BackPropagation backProp = new BackPropagation(input, output,1, new int[]{5});
       backProp.feedForward();
    }
}
