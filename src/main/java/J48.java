import java.util.ArrayList;
import java.util.Map;

/**
 * Created by kaustubh on 3/30/17.
 */
public class J48 {

    int selectedAattributes[] = null;
    CsvReader reader = null;
    ArrayList<Attribute> attributes = null;
    ArrayList<String> attributeList = null;
    int resultIndex = 0;
    Map results = null;

    public J48(CsvReader reader) {
        this.reader = reader;
        attributeList = reader.getHeaders();
        this.resultIndex = reader.numColumns - 1;
        results = TransformData.fromNominalToNumerical(reader.getColumn(resultIndex));
    }

    public void selectAtrributes(int indices[]) {
        selectedAattributes = indices;
        attributes = new ArrayList<Attribute>(indices.length);
        for (int i = 0; i < attributes.size(); i++) {
            attributes.add(new Attribute(reader.getColumn(indices[i]),
                    attributeList.get(indices[i]), reader.getColumn(resultIndex), results));
        }
    }

    public Attribute getMinEntropyAttribute()
    {
        int minEntropyAttribute = 0;
        double minEntropy = 0;
        for (int i = 0; i < attributes.size(); i++)
        {
            if(attributes.get(i).getAverageEntropy() < minEntropy)
            {
                minEntropy = attributes.get(i).getAverageEntropy();
                minEntropyAttribute = i;
            }
        }
        Attribute atrib = attributes.get(minEntropyAttribute);
        attributes.remove(minEntropy);
        return atrib;
    }


}
