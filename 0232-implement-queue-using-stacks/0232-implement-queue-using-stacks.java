class MyQueue {

    //created two stack 
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    
    public void push(int x) {
        stack1.push(x);
    }
    
    public int pop() {  

        while(stack1.size() > 1) stack2.push(stack1.pop());
        
        //this element we have to return.
        int popElement = stack1.pop();

        //now we again insert element in the stack1 for future use.
        while(stack2.size() > 0) stack1.push(stack2.pop());

        //here we return the poped element.
        return popElement;

        
    }
    
    public int peek() {
        while(stack1.size() > 1) stack2.push(stack1.pop());
        
        //this element we have to return.
        int popElement = stack1.peek();

        //now we again insert element in the stack1 for future use.
        while(stack2.size() > 0) stack1.push(stack2.pop());

        //here we return the poped element.
        return popElement;
    }
    
    public boolean empty() {
        return (stack1.size() == 0) ? (true) : (false);
    }
}
