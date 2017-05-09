import neuralnetwork.BackpropagationLearning;
import neuralnetwork.MultilayerPerceptron;
import neuralnetwork.NeuralNetworkBuilder;
import neuralnetwork.NeuralNetworkTopology;

import java.io.IOException;

/**
 * Created by kaustubh on 3/16/17.
 */
public class Nd4jtest {

    static double[] in1 = {0, 1, 0, 1};
    static double[] in2 = {1, 0, 1, 0};


    static double[] in3 = {1 , 1, 0, 1};

    static double[][] out1 = {{4.9f, 9.1f, 1.1f},{5.1f, 7.1f, 2.9f}
,{2.1f, 5.9f, 8.1f}, {1.1f, 7.1f, 0.9f}, {10.1f, 3.9f, 8.1f}, {6.9f, 9.1f, 1.1f}};

    static double[] out2 = {4.9f, 9.1f, 1.1f};
    static double[] out3 = {5.1f, 7.1f, 2.9f};

    static double[] test1 ={1.1f, 7.1f, 0.9f} ;
    static double[] test2 = {10.1f, 3.9f, 8.1f};
    static double[] test3 = {10.1f, 3.9f, 8.1f};

    public static void main(String args[]) throws IOException {

        //NeuralNetworkTopology mnn = new MultilayerPerceptron();
        //NeuralNetworkBuilder builder = new NeuralNetworkBuilder();
        //builder.setTopology(mnn);
        //BackpropagationLearning learning = new BackpropagationLearning(mnn);


        /*INDArray arr = Nd4j.create(out1);
        KMeans km = new KMeans(2, arr);
        km.train();*/

       /* int num[] = {4};
        BackPropagation backProp = new BackPropagation(1, num,.5, out1.length);
        backProp.train(in1, out2);
        backProp.train(in2, out3);
        backProp.train(in3, test1);
        double temp[] = {1, -1, 1, -1};*/

       /*INDArray temp1 = Nd4j.create(temp);
       INDArray temp2 = Nd4j.create(temp, new int[]{temp.length, 1});
       System.out.println(temp1.mmul(temp2));
       neuralnetwork.HopfieldNeuralNetwork net = new neuralnetwork.HopfieldNeuralNetwork(in1.length);
       net.train(in1);
       net.train(in2);
       net.recall(in1);
       net.recall(in2);
       net.recall(in3);
      /* File f = new File("/home/kaustubh/IdeaProjects/Cognition/src/test/java/data.csv");
       FileReader read = new FileReader(f);
       CsvReader readCsv = new CsvReader(read);
       System.out.println(readCsv.getHeaders().get(0));*/


    }
}
