class Solution {
    public int subtractProductAndSum(int n) {
        int remainder = 0, product = 1, sum = 0;

        while (n > 0) {
            remainder = n % 10;
            product *= remainder;
            sum += remainder;
            n = n / 10;
        }

        return product - sum;
    }
}