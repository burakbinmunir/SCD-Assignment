import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;


public class QuickSort {
    private Vector<Integer> array;

    QuickSort(){
        array = new Vector<Integer>();
    }

    public void inputArray(){
        int size = 0;
        Scanner scanner  = new Scanner(System.in);
        System.out.print("How many numbers you want to add: ");
        int number;

        size = scanner.nextInt();

        if (size > 0){
            int count = 0;
            while(count < size){
                number = scanner.nextInt();
                array.add(number);
                count++;
            }

        }else {
            System.out.println("You entered negative size");
        }
    }

    void printArray(){

        for(int number : array){
            System.out.println(number);
        }
    }

    public int divideArray(int lowIndex, int highIndex){
        int i = lowIndex;
        int j = highIndex;
        int pivot = array.get(lowIndex);


        while (i < j) {

            do {
                i++;
            } while (array.get(i) <= pivot);

            do {
                j--;
            }
            while (array.get(j) > pivot);

            if (i < j) {
                Collections.swap(array, i, j);
            }
        }
        Collections.swap(array, lowIndex, j);

        return i;
    }

    public void quickSort(int lowIndex, int highIndex){
        if (lowIndex < highIndex){

            int pivot = divideArray(lowIndex,highIndex);
            divideArray(lowIndex,pivot-1);
            divideArray(pivot+1,highIndex);
        }
    }
    
    public void sortArray(){ // sorting will be done using quick sort element
        quickSort(0, array.size()-1);
        printArray();
        
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        quickSort.inputArray();
       // quickSort.printArray();
        quickSort.sortArray();
    }
}
