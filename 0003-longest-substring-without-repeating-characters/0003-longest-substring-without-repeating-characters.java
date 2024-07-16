class Solution {
    public int lengthOfLongestSubstring(String s) {
        //required two pointer left and right which equals to 0.
        int left=0;
        int right=0;

        //length
        int n=s.length();

        //hashmap for storing character and it's frequency.
        HashMap<Character,Integer>hmap=new HashMap<>();

        //for storing final answer.
        int len=0;

        while(right<n)
        {
            //current character 
            char ch=s.charAt(right);

            //if this character is contains in hmap.
            //then do something.
            if(hmap.containsKey(ch)==true)
            {
                left=Math.max(hmap.get(ch)+1,left);
            }

            //everytime we put current character in the hashmap.
            hmap.put(ch,right);

            //calculate len
            len=Math.max(len,right-left+1);


            right++;
        }


        //return answer.
        return len;
    }
}