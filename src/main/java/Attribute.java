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
    Attribute(ArrayList values, String name)
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

}
