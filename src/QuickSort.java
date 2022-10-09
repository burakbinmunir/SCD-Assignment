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

    int partition( int lowIndex, int highIndex) {

        int pivot = array.get(highIndex);

        int i = lowIndex - 1;

        // traverse through all elements
        // compare each element with pivot
        for (int j = lowIndex; j < highIndex; j++) {

            if (array.get(j) <= pivot) {
                i++;

                int temp = array.get(i);
                array.set(i, array.get(j));
                array.set(j, temp);
            }

        }


        int temp = array.get(i + 1);
        array.set(i + 1, array.get(highIndex));
        array.set(highIndex, temp);

        return (i + 1);
    }

    void quickSort( int lowIndex, int highIndex) {
        if (lowIndex < highIndex) {
            int pivot = partition(lowIndex, highIndex);

            quickSort( lowIndex, pivot - 1);
            quickSort( pivot + 1, highIndex);
        }
    }

    public void sortArray(){
        quickSort(0,array.size()-1);
    }


    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        quickSort.inputArray();

        quickSort.sortArray();
         quickSort.printArray();
    }
}
