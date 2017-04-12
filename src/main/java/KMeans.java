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
    private ArrayList <INDArray> clusterCenter = null;
    private ArrayList <Integer> clusterCenterIndex = null;
    private Map <Integer, Integer> clusterCollection = null;
    private int maxIterations = 20;

    public KMeans(int cluster, INDArray data)
    {
        clusterCenterIndex = new ArrayList<Integer>();
        this.data = data;
        System.out.println(this.data);
        this.numCluster = cluster;
        clusterCenter = new ArrayList<INDArray>();
        clusterCollection = new HashMap<Integer, Integer>();
        System.out.println(data.getRow(0));
        System.out.println(data.getColumn(0));
    }

    private double calculateDistance(INDArray a1, INDArray a2)
    {
        return a1.squaredDistance(a2);
    }

    public void init()
    {
        Random rand = new Random();
        for (int i = 0; i < numCluster; i++) {
            clusterCenterIndex.add(rand.nextInt(data.columns()));
            clusterCenter.add(data.getRow(clusterCenterIndex.get(i)));
            System.out.println(clusterCenter.get(i));
        }
    }

    private void calculateCenter(Map<Integer, Integer> newCluster,
                                 ArrayList< Integer> clusterMemberCount)
    {
        System.out.println("Calculating new Centres");
        ArrayList <INDArray> list = new ArrayList<INDArray>(numCluster);
        for (int index: clusterCenterIndex)
        {
            int i = 0;
            INDArray arr = Nd4j.create(clusterMemberCount.get(i), data.columns());
            for (Map.Entry<Integer, Integer> entry: newCluster.entrySet())
            {
                System.out.println("Entry Set: "+ data.getRow(entry.getValue()));
                if(entry.getValue() ==  index)
                    arr.putRow(i++, data.getRow(entry.getKey()));
            }
            System.out.println(arr);
            INDArray array = Nd4j.create(data.columns());
            for (int j = 0; j < arr.columns(); j++)
            {
                System.out.println("J: "+ j);
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
        double distance = 1000000;
        int index = 0;
        for (int i = 0; i < numCluster; i++)
        {
            double d =calculateDistance(row, clusterCenter.get(i));
            System.out.println("d "+ d);
            if(distance > d)
            {
                distance = d;
                index = i;
                System.out.println("distance: "+distance);
            }
        }
        System.out.println("Index is: "+ index);
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
            System.out.println("Iteration: "+ maxIterations);
            ArrayList <Integer> clusterMemberCount = new ArrayList<Integer>(numCluster);
            for (int i = 0; i < numCluster; i++)
            {
                clusterMemberCount.add(0);
            }
            System.out.println("List :"+ clusterMemberCount);
            for (int i = 0; i < data.rows(); i++) {
                int belongsToCluster = getBelongsToCluster(data.getRow(i));
                clusterMemberCount.add(belongsToCluster,
                        clusterMemberCount.get(belongsToCluster)+1);

                System.out.println("Cluster: "+ clusterMemberCount.get(belongsToCluster));
                System.out.println("Belongs to: "+belongsToCluster);
                newCluster.put(i, belongsToCluster);
                System.out.println(newCluster.get(i));
            }
            calculateCenter(newCluster, clusterMemberCount);

            stop = changes(newCluster, clusterCollection);
            clusterCollection = newCluster;
            maxIterations--;
        }

    }


}
