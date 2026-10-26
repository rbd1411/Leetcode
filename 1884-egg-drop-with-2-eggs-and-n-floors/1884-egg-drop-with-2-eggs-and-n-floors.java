class Solution {
    
    public int twoEggDrop(int n) {
        int floors = n;
        int eggs = 2;
        int[] dp = new int[eggs+1];
        int moves = 0;
        for(moves = 0;dp[eggs] < floors;moves++) {
            for(int i = eggs;i>0;i--) {
                dp[i] += dp[i-1] + 1;
            }
        }
        return moves;
    }
}