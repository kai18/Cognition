import java.util.ArrayList;
import java.util.HashMap;
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
    ArrayList result = null;
    Map<String, Integer> results = null;

    Attribute(ArrayList values, String name, int totalValues,
              ArrayList result, Map results)
    {
        this.values = values;
        this.attributeName = name;
        this.result = result;
        instanceCount = values.size();
        this.results = results;
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

    public void calculateInstanceResult()
    {
        Map<String, ArrayList> temp = new HashMap<String, ArrayList>();

        for (Map.Entry<String, Integer> entry: attributeInstancesCount.entrySet())
        {
            for(int i = 0 ; i < values.size(); i++)
            {
                int resultIndex = results.get(result.get(i));
                ArrayList<Integer> temp2;
               if(temp.containsKey(values.get(i)))
                   temp2 = temp.get(values.get(i));
               else
                   temp2 = new ArrayList<Integer>(results.size());
               temp2.add(temp2.get(resultIndex)+1);
            }
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
            double x = attribute.getValue()/totalValues;



        }
        return 0;
    }

}
