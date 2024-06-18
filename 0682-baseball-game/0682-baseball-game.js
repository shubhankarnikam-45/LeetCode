/**
 * @param {string[]} operations
 * @return {number}
 */
var calPoints = function(operations) {
    
    //creating the stack.
    const stack= [];

    //return sum
    let sum = 0;
    for(let i=0; i<operations.length ;i++)
    {
        //current operaton.
        currentOperation = operations[i];

        if(currentOperation === "+")
        {
            let nthNumber = stack[stack.length-1];
            let nthm1Number = stack[stack.length-2];
            stack.push(nthNumber + nthm1Number);
            sum+=nthNumber + nthm1Number;
        }
        else if(currentOperation === "D")
        {
            let double = stack[stack.length-1] * 2;

            stack.push(double);
            sum+=double;
        }
        else if(currentOperation === "C")
        {
            sum -= stack.pop();
        }
        else 
        {
            //this means we added to the stack.
            //converted to current string to number.
            let num = parseInt(currentOperation);
            stack.push(num);
            sum+=num;
        }
    }

    return sum;
};