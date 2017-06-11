package tree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// Main class for decision tree learner
public class DTLearner {
	
	// Extracts data set from ARFF file
	@SuppressWarnings("resource")
	private static DataSet read(String filename) {
		DataSet data = new DataSet();
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File(filename));
		} catch (FileNotFoundException exception) {
			System.out.println("Error: could not find file");
			System.exit(1);
		}
		String line;
		scanner.nextLine(); // Skip first line
		while (scanner.hasNextLine()) {
			line = scanner.nextLine();
			if (line.equals("@data"))
				break;
			data.addAttribute(line);
		}
		while (scanner.hasNextLine())
			data.addInstance(scanner.nextLine());
		return data;
	}
	
	public static void main(String[] args) {
		DataSet trainingSet = read("/home/kaustubh/IdeaProjects/Cognition/src/main/java/tree/demo.arff");
		DataSet testingSet = read("/home/kaustubh/IdeaProjects/Cognition/src/main/java/tree/demo.arff");
		int stopValue = 10;
		
		DecisionTree ID3 = new DecisionTree(stopValue);
		ID3.train(trainingSet);
		ID3.test(testingSet.instances);
	}
	
}
