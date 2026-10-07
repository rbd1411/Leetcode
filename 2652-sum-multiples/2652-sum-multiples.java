class Solution {
    public int sumOfMultiples(int n) {
        int sum = 0;
        for (int i=1; i*3<=n || i*5<=n || i*7<=n; i++) {
            if (i*3 <= n) sum += i*3;
            if (i*5 <= n && i%3 != 0) sum += i*5;
            if (i*7 <= n && i%3 != 0 && i%5 != 0) sum += i*7;
        }

        return sum;
    }
}