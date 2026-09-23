class Solution {
    public int maxDistinct(String s) {
        int mask = 0, res = 0;
        for (char c : s.toCharArray()) {
            int bit = 1 << (c - 'a');
            if ((mask & bit) == 0) {
                mask |= bit;
                res++;
                if (res == 26) break;
            }
        }
        return res;
    }
}