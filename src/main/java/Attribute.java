import java.util.ArrayList;
import java.util.Map;

/**
 * Created by kaustubh on 3/31/17.
 */
public class Attribute {
    String attributeName = null;
    int instanceCount = 0;
    ArrayList <String> values = null;
    Map <String , Integer> attributeInstancesCount;
    int totalValues = 0;
    Attribute(ArrayList values, String name, int totalValues)
    {
        this.values = values;
        this.attributeName = name;
        instanceCount = values.size();
    }
    public void calculateInstanceCount() {
        for (String value : values) {
            if (attributeInstancesCount.containsKey(value))
                attributeInstancesCount.put(value,
                        attributeInstancesCount.get(value) + 1);
            else
                attributeInstancesCount.put(value, 1);
        }
    }

    private double log2(double num)
    {
        return Math.log(num)/Math.log(2);
    }
    public double getAverageEntropy()
    {
        for (Map.Entry<String, Integer> attribute:attributeInstancesCount.entrySet())
        {
            double nant = attribute.getValue()/totalValues;
            

        }
        return 0;
    }

}
