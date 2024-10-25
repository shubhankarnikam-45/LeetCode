class Solution {

    public  int lcs(String s, String t) {
		
		//here we use the pattern match / not match.
		int m = s.length();
		int n = t.length();

		//Space optimization.
		int prev[] = new int[n + 1];
		int cur[]  = new int[n + 1];

		//first we write the base case.
		for(int index2 = 0; index2 <=n; index2++) prev[index2] = 0;
		

		for(int index1 = 1; index1 <= m; index1++)
		{
			for(int index2 = 1; index2 <= n; index2++)
			{
				//if string at current index matches.
				if(s.charAt(index1 - 1) == t.charAt(index2 - 1))
				{
					cur[index2] = 1 + prev[index2 - 1];
				}
				else 
				{
					cur[index2] = 0 + Math.max(prev[index2], cur[ index2 - 1]);
				}
				
			}

			 prev = (int[]) (cur.clone());
		}

		return prev[n];
    }

    public int longestStrChain(String[] words) {
        
        //length of array.
        int n = words.length;

        //variable that store the maximum length string in 'words[]'
        int maxStr = 0;

        //we traverse on array and found out the max length string.
        for(String str : words)
        {
            if(str.length() > maxStr) maxStr = str.length();
        }

        //adding string lengthwise in the arraylist.
        ArrayList<String> alist = new ArrayList<>();

        for(int i=1; i<= maxStr; i++)
        {
            for(String str : words)
            {
                if(str.length() == i)
                {
                    alist.add(str);
                }
            }
        }

        int dp[] = new int[n];

        //this holds the final answer.
        int maxi = 1;

        for(int i=0; i<n; i++)
        {
            dp[i] = 1;
            String s1 = alist.get(i);

            for(int prev = 0; prev<i; prev++)
            {
                //string 2
                String s2 = alist.get(prev);

                //length of both string.
                int lenOfS1 = s1.length();
                int lenOfS2 = s2.length();

                if(lenOfS2 + 1 == lenOfS1)
                {
                    int lcs = lcs(s1, s2);

                    if(lcs == lenOfS2)
                    {
                        if(dp[i] < dp[prev] + 1)
                        {
                            dp[i] = dp[prev] + 1;
                        }
                    }
                    
                       

                    

                }
            }


            if(maxi < dp[i])
            {
                maxi = dp[i];
            }
        }


        return maxi;


    }
}

