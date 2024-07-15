class Solution {
    public String maximumOddBinaryNumber(String s) {
        
        int oncesCount = 0;
        int zerosCount = 0;

        for(char ch : s.toCharArray())
        {
            if(ch =='1')
            {
                oncesCount++;
            }
            else
            {
                zerosCount++;
            }
        }


        if(oncesCount == 0) return s;

        String ans ="";

        for(int i=0; oncesCount != 1 && i<oncesCount-1; i++)
        {
            ans+='1';
        }

         for(int i=0; i<zerosCount; i++)
        {
            ans+='0';
        }

        ans+='1';

        return ans;
    }
}