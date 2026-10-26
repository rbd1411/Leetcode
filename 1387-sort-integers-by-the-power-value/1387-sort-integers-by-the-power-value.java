class Solution {
    static int[] dp = new int[1000000];
    public int getKth(int lo, int hi, int k) {
        int n = hi-lo+1;
        for(int i=1;i<1001;i++)dp[i] = helper(i);
        int[][] list = new int[n][2];
        for(int i=lo;i<=hi;i++){
            list[i-lo][0]=i;
            list[i-lo][1]=helper(i);
        }
        Arrays.sort(list, (a,b)-> a[1]-b[1]);
        return list[k-1][0];
    }
    private int helper(int val){
        if(val==1)return 1;
        if(dp[val]!=0)return dp[val];
        if((val&(val-1))==0)dp[val] = helper(1)+(int)(Math.log(val)/Math.log(2));
        else if(val%2!=0)dp[val] = 1+helper(val*3+1);
        else dp[val] = 1+helper(val/2);
        return dp[val];
    }
}