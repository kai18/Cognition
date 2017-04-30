/**
 * Created by kaustubh on 4/30/17.
 */
public class ActivationFunctionFactory {
    public static ActivationFunction getActivationFunction(String functionName)
    {
        if(functionName == "SIGMOID")
        {
            return new ActivationSigmoid();
        }
        return null;
    }
}
