class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> res = new ArrayList<>(l.length);
        for (int i = 0; i < l.length; i++) {
            res.add(check(nums, l[i], r[i]));
        }

        return res;
    }

    private static boolean check(int[] nums, int l, int r) {
        int n = r - l + 1;
        if (n < 3) return true;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = l; i <= r; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        if (max == min) return true;
        if ((max - min) % (n - 1) != 0) return false;
        int diff = (max - min) / (n - 1);

        boolean[] seen = new boolean[n];
        for (int i = l; i <= r; i++) {
            if ((nums[i] - min) % diff != 0) return false;
            int j = (nums[i] - min) / diff;
            if (seen[j]) return false;
            seen[j] = true;
        }
        
        return true;
    }
}