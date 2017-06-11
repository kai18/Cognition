package neuralnetwork;

/**
 * Created by kaustubh on 4/30/17.
 */
public class InputFunctionFactory {
    public static InputFunction getInputFunction(String functionName) {
        if (functionName == "SOMOFPRODUCT") {
            return new SumofProduct();
        }
        return null;
    }

}
