class Solution {
    public int numSplits(String s) {
        int[] cntR = new int[26];
        int[] cntL = new int[26];
        int charsR = 0, charsL = 0, res = 0;

        // Count the occurrences of each character in the entire string
        for (char c : s.toCharArray()) {
            if (++cntR[c - 'a'] == 1) {
                charsR++;
            }
        }

        // Traverse the string again to calculate good splits
        for (char c : s.toCharArray()) {
            if (++cntL[c - 'a'] == 1) {
                charsL++;
            }
            if (--cntR[c - 'a'] == 0) {
                charsR--;
            }
            if (charsL == charsR) {
                res++;
            }
        }

        return res;
    }
}