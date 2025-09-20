class Solution {

    public boolean checkPalindrome(int i, int j, String s)
    {
        while(i < j)
        {
            if(s.charAt(i) == s.charAt(j)){

                i++;
                j--;
            }
            else return false;
        }

        return true;
    }
    public String longestPalindrome(String s) {
        
        //length of string.
        int n = s.length();
        
        //the answer string we later return.
        String ans = "";
        for(int i=0; i<n; i++)
        {
            for(int j=i; j<n; j++)
            {
                if(checkPalindrome(i, j, s) == true)
                {
                    String candidate = s.substring(i, j + 1);
                    
                    //check.
                    if(ans.length() < candidate.length())
                    {
                        ans = candidate;
                    }
                }
            }
        }

        return ans;
    }
}