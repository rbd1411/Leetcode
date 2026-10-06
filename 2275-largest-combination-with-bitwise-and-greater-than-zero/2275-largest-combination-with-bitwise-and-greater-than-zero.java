class Solution {
        public int largestCombination(int[] candidates) {
        int largest = 0;
        for (int i = 0; i < 24; ++i) {
            int sum = 0;
            for (int c : candidates) {
                sum += (c >> i) & 1;
            }
            largest = Math.max(largest, sum);
        }
        return largest;
    }
}