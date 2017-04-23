package neuralnetwork;

/**
 * Created by kaustubh on 3/28/17.
 */
public interface NeuralNetwork {
    void train(double input[]);

    void recall(double input[]);

    void train(double input[], double output[]);
}
