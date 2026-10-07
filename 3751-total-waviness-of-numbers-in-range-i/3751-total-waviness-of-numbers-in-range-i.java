class Solution {
    public int totalWaviness(int num1, int num2) {
        int wavy = 0;

        for (int num = num1; num <= num2; num++) {
            String s = String.valueOf(num);
            int n = s.length();

            if (n < 3) continue;

            for (int i = 1; i < n - 1; i++) {
                int left  = s.charAt(i - 1) - '0';
                int mid   = s.charAt(i)     - '0';
                int right = s.charAt(i + 1) - '0';

                if (mid > left && mid > right) {
                    wavy++;
                } else if (mid < left && mid < right) {
                    wavy++;
                }
            }
        }

        return wavy;
    }
}