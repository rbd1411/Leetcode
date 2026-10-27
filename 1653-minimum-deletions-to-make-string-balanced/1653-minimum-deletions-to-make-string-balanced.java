class Solution {
    public int minimumDeletions(String s) {
        if(s.length() == 1) return 0;

        int totalA = 0;
        for(char c : s.toCharArray()) {
            if(c == 'a') totalA++;
        }

        if(totalA == 0 || totalA == s.length()) return 0;

        int a_right = totalA;
        int b_left = 0;

        int ans = Math.min(totalA, s.length() - totalA);

        for(char c : s.toCharArray()) {
            if(c == 'a') a_right--;
            else b_left++;

            ans = Math.min(ans, b_left + a_right);
        }

        return ans;
    }
}