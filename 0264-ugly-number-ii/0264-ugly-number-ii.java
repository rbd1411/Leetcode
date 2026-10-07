class Solution {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        HashSet<Long> set = new HashSet<>();

        pq.add(1L);
        set.add(1L);

        long ugly = 1;

        while (n-- > 0) {
            ugly = pq.poll();

            long a = ugly * 2;
            long b = ugly * 3;
            long c = ugly * 5;

            if (a <= Integer.MAX_VALUE && set.add(a)) {
                pq.add(a);
            }

            if (b <= Integer.MAX_VALUE && set.add(b)) {
                pq.add(b);
            }

            if (c <= Integer.MAX_VALUE && set.add(c)) {
                pq.add(c);
            }
        }

        return (int) ugly;
    }
}