// import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class SortUtil {

    /**
     * @pre: both list1 and list2 must be in sorted order
     * @return a new sorted list containing all elements from list1 and list2
     */
    public static ArrayList<Integer> merge(ArrayList<Integer> list1, ArrayList<Integer> list2){
        //must run in O(n+m) time (n+m being the addition of both lists)
        int size1 = list1.size();
        int size2 = list2.size();

        ArrayList<Integer> sortedList = new ArrayList<Integer>();

        int list1Index = 0;
        int list2Index = 0;
        int sortedListIndex = 0;


        while (list1Index < size1 && list2Index < size2) {
            if (list1.get(list1Index) <= list2.get(list2Index)) {
                sortedList.add(sortedListIndex, list1.get(list1Index));
                list1Index++;
            } else {
                sortedList.add(sortedListIndex, list2.get(list2Index));
                list2Index++;
            }
            sortedListIndex++;
        }
        
        while (list1Index < size1) {
            sortedList.add(sortedListIndex, list1.get(list1Index));
            list1Index++;
            sortedListIndex++;
        }

        while (list2Index < size2) {
            sortedList.add(sortedListIndex, list2.get(list2Index));
            list2Index++;
            sortedListIndex++;
        }

        return sortedList;
    }

    /**
     * @return a new sorted list containing all elements from aList
     */
    public static ArrayList<Integer> mergeSort(ArrayList<Integer> aList){
        // If the list is size 1, return a copy of the list
        if (aList.size() == 1) {
            return new ArrayList<>(aList);
        }
        // If the list is size 0, return an empty list
        else if (aList.size() == 0) {
            return new ArrayList<Integer>();
        }
        // Else
        else {
            // choose a midpoint to split the list
            int midPoint = aList.size()/2;

            // make a new list (copy) with all elements from first half, and another new list (copy) with all elements from 2nd half
            ArrayList<Integer> firstHalf = new ArrayList<Integer>();
            ArrayList<Integer> secondHalf = new ArrayList<Integer>();

            for (int i=0; i<midPoint; i++) {
                firstHalf.add(aList.get(i));
            }
            for (int i=midPoint; i<aList.size(); i++) {
                secondHalf.add(aList.get(i));
            }
            // call merge sort on each of these new lists
            firstHalf = mergeSort(firstHalf);
            secondHalf = mergeSort(secondHalf);

            // call merge on the result sorted lists 
            ArrayList<Integer> sortedList = merge(firstHalf, secondHalf);

            return sortedList;
        }
        // throw new RuntimeException("Not");
    }


    public static void testMerge(){
        ArrayList<Integer> testList1 = new ArrayList<>(Arrays.asList(-8, -4, 2, 3, 13, 18 , 22, 56));
        ArrayList<Integer> testList2 = new ArrayList<>(Arrays.asList(-9, -8, 0, 1, 2, 7, 9, 11, 113, 187, 590));
        ArrayList<Integer> result = merge(testList1, testList2);
        System.out.println("Originals: " + testList1 + testList2);
        System.out.println("Merged: " + result);
    }

    public static void testMergeSort(){
        Random randGen = new Random();

        ArrayList<Integer> testList = new ArrayList<>();
        for (int i=0; i<20; i++){
            testList.add(randGen.nextInt(1000));
        }

        System.out.println("Original: " + testList);
        ArrayList<Integer> result = mergeSort(testList);
        System.out.println("Original: " + testList);
        System.out.println("Sorted: " + result);
    }

    public static void main(String[] args){
        testMerge();
        testMergeSort();
    }
}