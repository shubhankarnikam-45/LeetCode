class Solution {
    public int calPoints(String[] operations) {
        //creating the stack.
    Stack<Integer> stack = new Stack<>();

    //return sum
    int sum = 0;
    for(int i=0; i<operations.length ;i++)
    {
        //current operaton.
        String currentOperation = operations[i];

        if(currentOperation.equals("+"))
        {
            int nthNumber = stack.pop();
            int nthm1Number = stack.peek();
            stack.push(nthNumber);

            stack.push(nthNumber + nthm1Number);
            sum+=nthNumber + nthm1Number;


            


        }
        else if(currentOperation.equals("D"))
        {
            int doubleE = stack.peek()* 2;

            stack.push(doubleE);
            sum+=doubleE;
        }
        else if(currentOperation.equals("C"))
        {
            sum -= stack.pop();
        }
        else 
        {
            //this means we added to the stack.
            //converted to current string to number.
            int num = Integer.parseInt(currentOperation);
            stack.push(num);
            sum+=num;
        }
    }

    return sum;
    }
}