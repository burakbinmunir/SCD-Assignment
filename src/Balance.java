import java.util.Stack;

public class Balance {
    private Stack<String> stack;

    Balance(){
        stack = new Stack<String>();
    }
/*
    void balanceEquation(String equation){
        Stack<char> openBrackets = new Stack<char>();
        Stack<char> closeBrackets = new Stack<char>();

        for (int index =0; index < equation.length(); index++){
            if (equation.charAt(index) == '(')
                openBrackets.push(equation.charAt(index));

            if (equation.charAt(index) == ')')
                closeBrackets.push(equation.charAt(index));
        }
        // checking uneven case
        if (openBrackets.size()%2 == 0 && closeBrackets.size()%2== 0){
            System.out.println("Even");
        }
        else {

        }
    }
*/
    public void printStack(){
        for (String str : stack){
            System.out.println(str);
        }
    }

    public void add(String n){
        stack.push(n);
    }

    int doCalculate(int num1, int num2, String operator){
        if (operator.equals("+")){
            return num1 + num2;
        }

        if (operator.equals("-")){
            return num1 - num2;
        }
        if (operator.equals("/")){
            if (num2 > 0) {
                return num1 / num2;
            }
            return 0;
        }
        if (operator.equals("*")){
            return num1 * num2;
        }
        System.out.println("Wrong operator");
        return -1;
    }

    public int compute(){
        if (!stack.isEmpty()) {
            reverseStack();
            while (true) {
                int num1 = Integer.parseInt(stack.pop());
                String operator = stack.pop();
                int num2 = Integer.parseInt(stack.pop());
                int result = doCalculate(num1, num2, operator);

                if (stack.isEmpty()) {
                    return result;
                } else {
                    stack.push(String.valueOf(result));
                }
            }
        }
        else {
            System.out.println("Stack is empty");
            return 0;
        }
    }

    void reverseStack(){
        Stack<String> newStack = new Stack<String>();
        for(String ele : stack){
            newStack.push(ele);
        }
        stack.clear();
        for (String ele: newStack ){
            stack.push(ele);
        }
    }

    public static void main(String[] arg){
        Balance balance = new Balance();
       balance.add("2");
        balance.add("+");
        balance.add("2");
        balance.add("*");
        balance.add("2");
        balance.add("/");
        balance.add("2");
        balance.add("*");
        balance.add("2");

        int sum = balance.compute();
        System.out.println(sum);

    }
}
