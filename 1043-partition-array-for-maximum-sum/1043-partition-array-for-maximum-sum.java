class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int dp[]=new int[n+1];
        for(int idx=n-1;idx>=0;idx--)
            {
                int maxi=0;
                int sum=0;
                int maxAns=0;
                int len=0;
                for(int j=idx;j<Math.min(n,idx+k);j++)
                    {
                        len++;
                        maxi=Math.max(maxi,arr[j]);
                        sum=maxi*len+dp[j+1];
                        maxAns=Math.max(sum,maxAns);
                    }
                dp[idx]=maxAns;
            }
        return dp[0];
    }
}