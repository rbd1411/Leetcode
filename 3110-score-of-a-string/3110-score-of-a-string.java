class Solution {
    public int scoreOfString(String s) {
        char[] chars = s.toCharArray();
        int score = 0;

        for (int i = 0; i < chars.length - 1; i++) {
            int diff = chars[i] - chars[i + 1];
            if (diff >= 0) {
                score += diff;
            } else {
                score -= diff;
            }
        }

        return score;
    }
}