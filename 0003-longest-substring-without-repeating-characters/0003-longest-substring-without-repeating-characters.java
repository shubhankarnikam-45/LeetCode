class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        //crearting hashset to perfor ongoing operaton.
        HashSet<Character> hset = new HashSet<>();

        //creating ans variable to return.
        int ans = 0;

        //travese string and find the answer.
        for(int j=0 ;j<s.length();j++)
        {
            for(int i=j; i<s.length(); i++)
                {
                    if(hset.contains(s.charAt(i)))
                    {
                        ans = Math.max(ans, hset.size());
                        hset.clear();
                        break;
                    }

                    // if(s.charAt(i) >= 'a' && s.charAt(i)<='z' || s.charAt(i)== ' ')
                    hset.add(s.charAt(i));
                }
                
        }
        ans = Math.max(ans, hset.size());

        return ans;
    }
}