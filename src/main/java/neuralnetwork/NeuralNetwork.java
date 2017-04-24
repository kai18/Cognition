package neuralnetwork;

/**
 * Created by kaustubh on 3/28/17.
 */
public interface NeuralNetwork {

    void recall(double input[]);

    void train(double input[], double output[]);
}
