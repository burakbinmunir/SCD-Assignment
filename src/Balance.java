
public class Balance {
    static String balance(String expression)
    {

        String tempexpression = expression;
        StackUsingLinkedlist list1 =new StackUsingLinkedlist();
        StackUsingLinkedlist list2=new StackUsingLinkedlist();
        int len =tempexpression.length();
        for(int i=0;i<len;i++)
        {
            if(tempexpression.charAt(i)=='(')
            {
                list1.push(i,tempexpression.charAt(i));
            }
            else
            {
                if(tempexpression.charAt(i)==')')
                {
                    if(list1.peek()!=null && list1.peek().data=='(' && list2.peek().data!='/' && list2.peek().data!='*' && list2.peek().data!='+' && list2.peek().data!='%' && list2.peek().data!='-')
                    {
                        list1.pop();
                    }
                    else
                    {
                        list1.push(i,tempexpression.charAt(i));
                    }
                }
                else
                {
                    list2.push(i,tempexpression.charAt(i));
                }

            }
        }
        if(!list1.isEmpty())
        {
            if (list1.top == null) {
                System.out.println("\nStack Underflow");
            }
            else {
                StackUsingLinkedlist.Node temp = list1.top;
                while (temp != null) {
                    tempexpression = tempexpression.substring(0,temp.index)+' '+tempexpression.substring(temp.index + 1);
                    temp = temp.link;
                }
                tempexpression=tempexpression.replaceAll("\\s", "");
            }
        }
        return tempexpression;
    }

    public static void main(String[] args) {
        String exp = "(2+2))";
        System.out.println(balance(exp));
    }

}
// Create Stack Using Linked list
class StackUsingLinkedlist {


    public class Node {

        char data; // integer data
        int index;
        Node link; // reference variable Node type

    }

    Node top;

    StackUsingLinkedlist() { this.top = null; }


    public void push(int ind,char x) // insert at the beginning
    {
        // create new node temp and allocate memory
        Node temp = new Node();

        // check if stack (heap) is full. Then inserting an
        //  element would lead to stack overflow
        if (temp == null) {
            System.out.print("\nHeap Overflow");
            return;
        }

        // initialize data into temp data field
        temp.index=ind;
        temp.data = x;

        // put top reference into temp link
        temp.link = top;

        // update top reference
        top = temp;
    }

    public boolean isEmpty() { return top == null; }

    public Node peek()
    {
        // check for empty stack
        if (!isEmpty()) {
            return top;
        }
        else {
            return null;
        }
    }

    public void pop()
    {
        // check for stack underflow
        if (top == null) {
            System.out.print("\nStack Underflow");
            return;
        }

        // update the top pointer to point to the next node
        top = (top).link;
    }

    public void display()
    {
        // check for stack underflow
        if (top == null) {
            return;
        }
        else {
            Node temp = top;
            while (temp != null) {

                // print node data
                System.out.print(temp.data);
                System.out.println(temp.index);
                // assign temp link to temp
                temp = temp.link;
                if(temp != null)
                    System.out.print(" -> ");
            }
        }
    }
}
