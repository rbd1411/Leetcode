class Solution {
        public int[][] sortTheStudents(int[][] score, int k) {
        return Arrays.stream(score).sorted(Comparator.comparing(a -> -a[k])).toArray(int[][]::new);
    }
}