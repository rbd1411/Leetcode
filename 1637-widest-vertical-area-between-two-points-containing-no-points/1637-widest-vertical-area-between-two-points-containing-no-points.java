class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        Set<Integer> set = new HashSet<>();
        int res = 0;
        for (int[] point : points) {
            set.add(point[0]);
        }
        Integer[] sortedSet = set.toArray(new Integer[0]);
        Arrays.sort(sortedSet);
        for (int i = 1; i < sortedSet.length; i++) {
            res = Math.max(res, sortedSet[i] - sortedSet[i - 1]);
        }
        return res;
    }
}