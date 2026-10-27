class Solution {
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];        
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        System.arraycopy(grid[0], 0, dp[0], 0, m);        
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < m; k++) {
                    dp[i + 1][k] = Math.min(
                        dp[i + 1][k],
                        dp[i][j] + grid[i + 1][k] + moveCost[grid[i][j]][k]
                    );
                }
            }
        }
        
        int minCost = Integer.MAX_VALUE;
        for (int cost : dp[n - 1]) {
            minCost = Math.min(minCost, cost);
        }
        
        return minCost;
    }
}