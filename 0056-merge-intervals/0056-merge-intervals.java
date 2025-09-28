class Solution {

    //created the pair class.
    public class Pair implements Comparable<Pair>
    {
        int sp;
        int ep;

        Pair(int sp, int ep)
        {
            this.sp = sp;
            this.ep = ep;
        }

        public int compareTo(Pair p)
        {
            if(this.sp != p.sp)
            {
                return this.sp - p.sp;
            }
            else
            {
                return this.ep - p.ep;
            }
        }
    }
    public int[][] merge(int[][] intervals) {
        
        //length of intervals array.
        int n = intervals.length;

        // if size of 2d array is zero.
        if(n  == 0) return new int[0][0];

        //created array of pair class.
        Pair pair[] = new Pair[n];

        //add array element to the pair class.
        for(int i=0; i<n; i++)
        {
            pair[i] = new Pair(intervals[i][0], intervals[i][1]);
        }

        //sort array.
        Arrays.sort(pair);

        //created Stak of pair class.
        Stack<Pair> stack = new Stack<>();

        stack.push(pair[0]);

        //now traverse pair array 
        for(int i=1; i<n; i++)
        {
            //extract the top value of stack.
            Pair top = stack.peek();

            if(top.ep >= pair[i].sp)
            {
                top.sp = Math.min(top.sp, pair[i].sp);
                top.ep = Math.max(top.ep, pair[i].ep);
            }
            else
            {
                stack.push(pair[i]);
            }
        }

        //curent size of stack.
        int sos = stack.size();

        //created 2d array of size sos to return teh final answer
        int ans[][] = new int[sos][2];


        for(int i=sos -1 ; i>=0; i--)
        {
            Pair p = stack.pop();
            ans[i][0] = p.sp;
            ans[i][1] = p.ep; 
        }


        //return the answer.
        return ans;

    }
}