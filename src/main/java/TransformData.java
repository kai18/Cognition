import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by kaustubh on 4/3/17.
 */
public class TransformData {
    public Map fromNominalToNumerical(ArrayList<String> list)
    {
        Map <String, Integer> map = new HashMap<String, Integer>();

        int x = 0;
        for (String entry: list)
        {
            if(!map.containsKey(entry))
                map.put(entry,x++);
        }
        return map;
    }
}
