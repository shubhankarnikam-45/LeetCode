class Solution {
    public boolean isAnagram(String s, String t) {
        
        //length fo string s.
        int m = s.length();

        //length of string t.
        int n = t.length();

        //base case.
        //if length mismatch.        
        if(m != n) return false;

        //freq array 1 for string s.
        int freqS[] = new int[26];

        //freq array 2 for string t
        int freqT[]  = new int[26];

        //traverse to calculate the freq.
        for(int i=0; i<m; i++)
        {
            //current characters on both string.
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);

            freqS[ch1 - 'a']++;
            freqT[ch2 - 'a']++;
        }

        //again traverse and find final answer.
        for(int i=0; i<m ;i++)
        {
            //going with string s.
            char ch = s.charAt(i);

            int charToInt = ch - 'a';

            if(freqS[charToInt] != freqT[charToInt])
            {
                return false;
            }
        }

        //we reach here that means we found our answer.
        return true;

    }
}