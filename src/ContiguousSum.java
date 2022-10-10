
import java.util.*;

public class ContiguousSum{
    private ArrayList<Integer> numbers;

    ContiguousSum()
    {
        numbers = new ArrayList<Integer>();
    }

    void addElements(){
        int size =0;
        System.out.print("How many elements you want to input in array: ");

        Scanner scan = new Scanner(System.in);
        size = scan.nextInt();

        if (size > 0){
            int number;
            for (int index =0; index < size; index++){
                number = scan.nextInt();
                numbers.add(number);
            }
        }
        else {
            System.out.println("You entered negative size");
        }
    }

    void printArray(){
        System.out.println("Printing array");

        for (int number : numbers){
            System.out.println(number);
        }
    }

    public int findLargestContiguousSum(){
        int sum = Integer.MIN_VALUE;
        int maxEnding = 0, index =0;


        while ( index < numbers.size()){

            maxEnding+= numbers.get(index);

            if (sum  < maxEnding){
                sum = maxEnding;
            }

            if (maxEnding < 0){
                maxEnding = 0;
            }

            index++;
        }
        return sum;
    }

    public static void main(String[] args) {
        ContiguousSum cSum = new ContiguousSum();
        cSum.addElements();
        cSum.printArray();
        System.out.println("Maximum Contigous sum is: "+ cSum.findLargestContiguousSum());
    }
}
