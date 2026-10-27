class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            int remaining_width = shelfWidth, currentHeight = 0;
            for (int j = i - 1; j >= 0; j--) {
                remaining_width -= books[j][0];
                if (remaining_width<0) break;
                currentHeight = Math.max(currentHeight, books[j][1]);
                dp[i] = Math.min(dp[i], dp[j] + currentHeight);
            }
        }

        return dp[n];
    }
}