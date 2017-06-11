package neuralnetwork;

import java.util.ArrayList;

/**
 * Created by kaustubh on 4/29/17.
 */
public class SumofProduct implements InputFunction {
    public double getInput(ArrayList<Connection> connections) {
        double output = 0;
        for (Connection con : connections)
            output += con.getWeightedOutput();
        return output;
    }
}
