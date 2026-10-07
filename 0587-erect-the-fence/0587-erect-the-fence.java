class Solution {

    public int[][] outerTrees(int[][] trees) {

        int n = trees.length;

        // If only 1 or 2 points, return directly
        if (n <= 3) {
            return trees;
        }

        // Sort points by x-coordinate, then y-coordinate
        Arrays.sort(trees, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        List<int[]> hull = new ArrayList<>();

        // Build lower hull
        for (int[] point : trees) {

            while (hull.size() >= 2 &&
                   cross(hull.get(hull.size() - 2),
                         hull.get(hull.size() - 1),
                         point) < 0) {

                hull.remove(hull.size() - 1);
            }

            hull.add(point);
        }

        // Build upper hull
        int lowerSize = hull.size();

        for (int i = n - 2; i >= 0; i--) {

            int[] point = trees[i];

            while (hull.size() > lowerSize &&
                   cross(hull.get(hull.size() - 2),
                         hull.get(hull.size() - 1),
                         point) < 0) {

                hull.remove(hull.size() - 1);
            }

            hull.add(point);
        }

        // Remove duplicates using Set
        Set<String> seen = new HashSet<>();
        List<int[]> result = new ArrayList<>();

        for (int[] p : hull) {

            String key = p[0] + "," + p[1];

            if (!seen.contains(key)) {
                seen.add(key);
                result.add(p);
            }
        }

        // Convert List<int[]> to int[][]
        int[][] ans = new int[result.size()][2];

        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }

        return ans;
    }

    // Cross Product
    private int cross(int[] o, int[] a, int[] b) {

        return (a[0] - o[0]) * (b[1] - o[1]) -
               (a[1] - o[1]) * (b[0] - o[0]);
    }
}