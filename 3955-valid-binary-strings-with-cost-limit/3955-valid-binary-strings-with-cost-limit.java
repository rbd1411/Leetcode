class Solution {

    private List<String> res;

    public List<String> generateValidStrings(int n, int k) {
        res = new ArrayList<>();
        char[] curr = new char[n];

        dfs(0, false, 0, k, curr);

        return res;
    }

    private void dfs(int idx, boolean prevOne, int cost, int k, char[] curr) {
        if (cost > k)
            return;

        if (idx == curr.length) {
            res.add(new String(curr));
            return;
        }

        curr[idx] = '0';
        dfs(idx + 1, false, cost, k, curr);

        if (!prevOne) {
            curr[idx] = '1';
            dfs(idx + 1, true, cost + idx, k, curr);
        }
    }
}