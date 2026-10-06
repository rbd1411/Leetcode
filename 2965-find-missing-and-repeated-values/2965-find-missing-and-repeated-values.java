class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map.put(grid[i][j], map.getOrDefault(grid[i][j], 0) + 1);
            }
        }

        int[] ans = new int[2];

        for (int i = 1; i <= n * n; i++) {
            if (map.getOrDefault(i, 0) == 2)
                ans[0] = i;

            if (!map.containsKey(i))
                ans[1] = i;
        }

        return ans;
    }
}