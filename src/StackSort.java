import java.util.Scanner;
import java.util.Stack;

// assumption we will only sort the stack which would be of numbers
public class StackSort {
    private Stack<Integer> stack;

    StackSort(){
        stack = new Stack<Integer>();
    }

    void inputStack(){
        int number;
        System.out.println("Enter elements in stack. Press -1 for stopping");

        Scanner scanner = new Scanner(System.in);
        number = scanner.nextInt();

        while(number != -1){
            stack.push(number);
            number = scanner.nextInt();
        }
    }

    void printStack(){

        System.out.println("Printing stack");

        for(int number: stack){
            System.out.println(number);
        }
    }

    Stack<Integer> sortStack(){

        Stack<Integer> sortedStack = new Stack<Integer>();

        while(!stack.isEmpty()){
            int element = stack.pop();

            while(sortedStack.peek() > element && !sortedStack.isEmpty()){
                stack.push(sortedStack.pop());
            }
            sortedStack.push(element);

        }

        return sortedStack;
    }

    public static void main(String[] args) {
        StackSort sortStack = new StackSort();
        sortStack.inputStack();
        sortStack.printStack();
        Stack<Integer> stck =sortStack.sortStack();

        System.out.println("Printing sorted stack");

        while (!stck.isEmpty()){
            System.out.println(stck.pop());
        }

        // 34 3 31 98 92 23
    }
}
