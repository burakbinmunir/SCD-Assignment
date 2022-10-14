import java.util.Scanner;
import java.util.Stack;

// assumption we will only sort the stack which would be of Integer numbers
public class StackSort {
    private Stack<Integer> stack;

    StackSort(){
        stack = new Stack<Integer>();// Initialization
    }

    // this function inputs the stack elements
    void inputStack(){
        int number;
        int size = 0;
        System.out.println("How many numbers you want to add in stack: ");

        Scanner scanner = new Scanner(System.in);
        size = scanner.nextInt();
        if (size > 0) { // in case size is positive

            int index = 0;
            while (index < size) {
                number = scanner.nextInt();
                stack.push(number);
                index++;
            }
        }
        else {
            System.out.println("BuBye");
        }
    }

    // this function prints the elements of stack
    void printStack(){

        System.out.println("Printing stack");

        for(int number: stack){
            System.out.println(number);
        }
    }

    // this function sorts the stack
    Stack<Integer> sortStack(){

        Stack<Integer> sortedStack = new Stack<Integer>();

        while(!stack.isEmpty()){
            int element = stack.pop();

            if (sortedStack.isEmpty()){ // for first element
                sortedStack.push(element);
            }
            else {
                while(!sortedStack.isEmpty() && sortedStack.peek() > element ){
                    stack.push(sortedStack.pop());
                }
                sortedStack.push(element);
            }
        }
        stack = sortedStack;
        return sortedStack;
    }

    public static void main(String[] args) {
        StackSort sortStack = new StackSort();
        sortStack.inputStack();
        sortStack.printStack();
        Stack<Integer> stck =sortStack.sortStack();

        System.out.println("Printing sorted stack");
        for (int num : stck){
            System.out.println(num);
        }
    }
}
