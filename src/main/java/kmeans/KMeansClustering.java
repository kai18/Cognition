package kmeans;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Vector;

public class KMeansClustering 
{    
    Data set;
    int k;
    public int n[];
    public double classifiedData[][];
    public double unclassifiedData[][];
    public double centroids[][]; //initial value of centroids
    public double newCentroids[][];
    public boolean checkCentroid;
    public boolean equalCentroids;
    static BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
    
    
    /**
     * Constucts KMeansClustering, populating centroids with first k numbers of data.
     * 
     * @param Number of centroids.
     */
    public KMeansClustering(int k) //k = the number of centroids 
    {
        this.k = k;
        centroids = new double[k][7]; //6 attributes for each centroid
        n = new int[k];             
        set = new Data();
        classifiedData = set.readTrainingFile();
        unclassifiedData = set.readTestFile();

        for (int i = 0; i < k; i++) { //populate centroids with first k no. of data
            for(int j = 0; j < 7; j++) {
                centroids[i][j] = classifiedData[i][j];
            }
        }
    }

    /**Calculates Euclidean distance between cluster centroid to each object in data[][].
     * data[i] is the whole row eg: data[0] = {1.0,1.0} (same with centroids[i]).
     * 
     * @param Array of datum and array of centroid.
     * @return Distances for one row of centroid.
     */
    public double getDistance(double[] datum, double[] centroid) 
    {
        double d = 0.0;

        for (int i = 0; i < datum.length - 1; i++) { //calculate distance for each row of data
            d += Math.pow(datum[i] - centroid[i], 2); //Euclidean distance
        }

        return(Math.sqrt(d)); //return distance (note: only returns distances for one row of centroid)
    }

    /**
     * Gets centroids with the smallest distance for one datum.
     * 
     * @param Array of datum.
     * @return closestCentroid to datum.
     */
    public int getClosestCentroid(double[] datum)
    {
        double min = Double.MAX_VALUE; //starts with minimum = centroids[0]
        int closestIndex = -1; //-1 because 0 could be a result value

        for (int i = 0; i < centroids.length; i++) { //for each centroid
            double d = getDistance(datum, centroids[i]); // between cluster centroid and object

            if (d < min) { //current distance is less than the minimum distance
                closestIndex = i; //k is now the location of the closest centroid
                min = d; 
            } 
        } 
        return(closestIndex); //returns index of the closest centroid for current datum
    }

    /**
     * Print array of datum to terminal.
     * 
     * @param Array of datum.
     */
    public void printDatum(double[] datum) 
    {
        Vector<Double> v = new Vector<Double>();

        for (int j = 0; j < datum.length - 1; j++) {
            v.add(new Double(datum[j]));
        }

        System.out.println(v);
    }

    /**
     * Print centroids to terminal.
     * 
     * @param Array of datum.
     */
    public void printCentroids() 
    {
        for (int i = 0; i < centroids.length; i++) {
            printDatum(centroids[i]);
        }

        System.out.println("-------------------");
    }

    /**
     * The run method essentially creates new centroids. Firstly, it resets the value of n as this counts
     * how many data objects belong to a centroid - it needs to be 0 as the centroids modify themelf at
     * every iteration. The closestCentroid variable holds the index of the closest centroid of certain data,
     * it does this using Euclidean Distance. It sums up all datum sharing the same closest centroid in order
     * to get the mean of all the data belonging to that centroid.
     * It calls the terminator method to check for stability between old and new centroids, stability will
     * cause the run method to terminate.
     * It then calls the getClassification method to assign centroids to a classication value, then print
     * output to file.
     */
    public void run() 
    {
        boolean check = false;

        while (check == false) {

            boolean result = true;
            double newCentroids[][] = new double[k][7];// length = k

            for (int i = 0; i < k; i++) {
                n[i] = 0; //reset value of n[]
            }
            printCentroids();

            for (int i = 0; i < classifiedData.length; i++) { //ALL data objects
                int count = getClosestCentroid(classifiedData[i]); //gets closest centroid for ALL distances

                for (int j = 0; j < 6; j++) {
                    newCentroids[count][j] += classifiedData[i][j]; //sums all datum belonging to certain centroid 
                }
                n[count]++; //counts the no. of members of datum that belong to centroid group 
            }

            //finds the average between all datum belonging to certain centroid
            for (int i = 0; i < k; i++) {
                for(int j = 0; j < 6; j++) {
                    newCentroids[i][j] = newCentroids[i][j] / n[i];
                }
            }

            //checks if newCentroid values are same as Centroid
            //If they are then there are no more move groups and no more iterations are needed
            for (int i = 0; i < k; i++) {
                for (int j = 0; j < 6; j++) {
                    if(result == true) {
                        if(newCentroids[i][j] == centroids[i][j]) { //checks for stability
                            check = true;
                            result = true;
                        } else {
                            check = false;
                            result = false; 
                        }
                    }
                }
            }

            centroids = newCentroids;
            getClassification(classifiedData, centroids);
        }
        try {
			printNewClassifications(unclassifiedData, newCentroids);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    /**
     * Assigns new centroid arrays with a clasification value of 1 or 0. It looks for target
     * (classified) data that are closest to the new centroid being processed and checks to see if the 
     * classification value for the classifiedData array being processed is a 1 or a 0 then assigns
     * that classification value to the centroid array being processed.
     */
    public void getClassification(double[][] datum, double[][] centroid) {

        int positive = 0; //represents 1
        int negative = 0; //represents 0 

        for (int i = 0; i < centroid.length; i++) {
            for (int j = 0; j < datum.length; j++) {
                if (i == getClosestCentroid(datum[j])) { //if data is closest to current newCentroid
                    if (datum[j][6] == 1) { //count positive or negative
                        positive++;
                    } else {
                        negative++;
                    }
                }

                if (positive > negative) { //use counted values to label new centroid
                    centroid[i][6] = 1;
                } else {
                    centroid[i][6] = 0;
                }
            }

            positive = 0;
            negative = 0;
        }
    }

    /**
     * Prints out classification values for test (unclassified) data in both the terminal window and
     * a new file "output.txt" in the root folder. Throws an input output exception.
     * 
     * @param An unclassifiedData array, a centroid array.
     */
    public void printNewClassifications(double[][] unclassifiedData, double[][] centroid) throws IOException {

        //creates an outputfile in ascii format
        FileWriter outputFile = new FileWriter("kmeans/output.txt");
        PrintWriter outputPrint = new PrintWriter(outputFile);

        //for all test data length, checks distance and classifies new centroids
        for (int i = 0; i < unclassifiedData.length; i++) {
            int closest = getClosestCentroid(unclassifiedData[i]);
            outputPrint.println((int)centroids[closest][6]);
        }

        outputPrint.println("");
        outputPrint.close();
    }

    /**
     * Main method, asks for number of centroids (k) and creates a KMeansClustering object with k amount of 
     * centroids.
     */
    public static void main(String args[]) throws IOException 
    {
    	System.out.println("Type number of centroids: ");
    	String userInput = inFromUser.readLine();
        new KMeansClustering(Integer.parseInt(userInput)).run();
    }
}

