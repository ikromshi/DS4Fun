import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ListAnalysisMain {
    private static Random randGen = new Random();

    public static int find(List<Integer> aList, int itemToFind){
        for (int i=0; i< aList.size(); i++){
            if(aList.get(i).equals(itemToFind)){
              return i;
            }
        }
        return -1;
    } 

    public static long timeAFind(List<Integer> aList, int itemToFind){
		long start = System.nanoTime();
		find(aList, itemToFind);
		long end = System.nanoTime();
		long runTime = (end - start);
		return runTime;
	}

    //dataIncrementRate is the number of items that will be added to the list between each timing print out
    public static void outputFindData(List<Integer> aList, int dataIncrementRate){
		final int numDataPointsToPrint = 50;
		System.out.println("Items in list \t time to find");
        for(int dataPoint=0; dataPoint<numDataPointsToPrint; dataPoint++){
            for (int i=0; i< dataPoint*dataIncrementRate; i++){
              aList.add(randGen.nextInt(dataPoint*dataIncrementRate));
            }
            System.out.println(dataPoint*dataIncrementRate + " \t\t " + timeAFind(aList, (dataPoint*dataIncrementRate)+1));
        }
	}

    public static void main(String[] args){
        //TODO: Your code here, call outputFindData on a new ArrayList and on a new LinkedList,
        // Then use google sheets to graph the results (same as project 2)

      LinkedList<Integer> linkedList = new LinkedList<Integer>();
      ArrayList<Integer> arrayList = new ArrayList<Integer>();
    
      outputFindData(linkedList, 50);
      outputFindData(arrayList, 100000);
    }
}