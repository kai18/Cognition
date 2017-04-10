import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by kaustubh on 4/9/17.
 */
public class KMeans {
    private INDArray data = null;
    private int numCluster = 0;
    ArrayList <INDArray> clusterCenter = null;
    ArrayList <Integer> clusterIndex = null;
    Map <Integer, Integer> clusterCollection = null;
    int maxIterations = 20;

    public KMeans(int cluster, INDArray data)
    {
        clusterIndex = new ArrayList<Integer>();
        this.data = data;
        this.numCluster = cluster;
        clusterCenter = new ArrayList<INDArray>();
        clusterCollection = new HashMap<Integer, Integer>();
    }

    private double calculateDistance(INDArray a1, INDArray a2)
    {
        return a1.squaredDistance(a2);
    }

    public void init()
    {
        Random rand = new Random();
        for (int i = 0; i < numCluster; i++) {
            clusterIndex.add(rand.nextInt() % (data.columns()));
            clusterCenter.add(data.getRow(clusterIndex.get(i)));
            System.out.println(clusterCenter.get(i));
        }
    }

    private void calculateCenter(Map<Integer, Integer> newCluster)
    {
        System.out.println("Calculating new Centres");
        ArrayList <INDArray> list = new ArrayList<INDArray>(numCluster);
        for (int index: clusterIndex)
        {
            INDArray arr = Nd4j.create(newCluster.size(), data.columns());
            int i = 0;
            for (Map.Entry<Integer, Integer> entry: newCluster.entrySet())
            {
                if(entry.getValue() ==  index)
                    arr.putRow(i++, data.getRow(entry.getKey()));
            }
            System.out.println(arr);
            INDArray array = Nd4j.create(data.columns());
            for (int j = 0; j < arr.columns(); j++)
            {
                INDArray temp = arr.getColumn(j);
                double sum = temp.sumNumber().doubleValue();
                array.putScalar(i, sum);
                System.out.println("New cluster center: "+array);
            }
            list.add(array);
        }

        clusterCenter = list;
    }

    private int getBelongsToCluster(INDArray row)
    {
        double distance = 0;
        int index = 0;
        for (int i = 0; i < numCluster; i++)
        {
            double d =calculateDistance(row, clusterCenter.get(i));
            if(distance > d)
            {
                distance = d;
                index = i;
            }
        }

        return index;
    }

    private  boolean changes(Map newCluster, Map oldCluster)
    {
        return newCluster.equals(oldCluster);
    }
    public void train()
    {
        System.out.println("Calling init");
        init();
        Map<Integer, Integer> newCluster = new HashMap<Integer, Integer>();
        boolean stop = false;
        while(!stop || maxIterations > 0) {
            for (int i = 0; i < data.rows(); i++) {
                int belongsToCluster = getBelongsToCluster(data.getRow(i));
                newCluster.put(i, belongsToCluster);
            }
            calculateCenter(newCluster);

            stop = changes(newCluster, clusterCollection);
            clusterCollection = newCluster;
            maxIterations--;
        }

    }


}
