class Solution {
    public int gcdOfOddEvenSums(int n) {
        int oddSum = 0, evenSum = 0;

        for (int i = 1; i <= n; i++) {
            evenSum += 2 * i;
            oddSum += 2 * i - 1;
        }

        return gcd(oddSum, evenSum);
    }

    private int gcd(int a, int b) {
        if (b == 0)
            return a;

        return gcd(b, a % b);
    }
}