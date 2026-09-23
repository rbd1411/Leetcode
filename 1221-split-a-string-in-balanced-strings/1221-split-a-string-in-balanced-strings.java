class Solution {
    public int balancedStringSplit(String s) {
        int r = 0;
        int l = 0;
        int count = 0;
        int i = 0;

        while (i < s.length()) {
            if (s.charAt(i) == 'L') {
                l++;
            } else {
                r++;
            }

            if (l == r) {
                count++;
                l = 0;
                r = 0;
            }

            i++;
        }

        return count;
    }
}