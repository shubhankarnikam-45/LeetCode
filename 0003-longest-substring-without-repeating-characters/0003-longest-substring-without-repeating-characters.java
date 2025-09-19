class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        //lengthof string
        int n = s.length();

        int hash[] = new int[256];
        Arrays.fill(hash, -1);

        int ans = 0;
        //creating two pointers l and r
        int l = 0;
        int r = 0;
        while(r < n)
        {
            if(hash[s.charAt(r)] != -1 && hash[s.charAt(r)] >=l) l = hash[s.charAt(r)] + 1;

            //find ans.
            int len = r - l + 1;
            ans = Math.max(ans, len);
            hash[s.charAt(r)] = r;
            r++;
        }
        return ans;
    }
}