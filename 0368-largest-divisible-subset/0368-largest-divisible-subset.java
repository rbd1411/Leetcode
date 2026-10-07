class Solution {
    public List<Integer> largestDivisibleSubset(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        int maxLen = 1;

        for(int i=n-2;i>=0;i--){
            int max = 0;
            for(int j=i+1;j<n;j++){
                if(arr[j] % arr[i] == 0){ // j -> i due to LDS
                    max = Math.max(max,dp[j]);
                }
            }
            dp[i] += max;
            maxLen = Math.max(maxLen,dp[i]);
        }

        int idx = 0;
        for(int i=0;i<n;i++){
            if(dp[i] == maxLen) {
                idx = i;
                break;
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(arr[idx]);
        maxLen--;

        int prevIdx = idx;
        for (int i = idx + 1; i < n; i++) {
            if (maxLen == 0) break; 
            if (arr[i] % arr[prevIdx] == 0 && dp[i] == maxLen) {
                ans.add(arr[i]);
                prevIdx = i;
                maxLen--;   
            }
        }
        return ans;
    }
}