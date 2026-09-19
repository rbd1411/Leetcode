class Solution {
    public int[] buildArray(int[] nums) {
        int len = nums.length;
        int[] rez = new int[len];

        for (int i = 0; i < len; i++) {
            rez[i] = nums[nums[i]];
        }

        return rez;
    }
}