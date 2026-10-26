class Solution {
    public int countSubstrings(String s, String t) {
        int n = s.length();
        int m = t.length(); 
        
        int [][] lcs = new int[n][m];
        int [][] diff = new int[n][m]; // we will return the sum of all the cells as the answer
        int count = 0; 
        for (int i = 0; i < n; i++) { // loop for string s 
            for (int j = 0; j < m; j++) { // loop for string t 
                if (s.charAt(i) == t.charAt(j)) {
                    // diff same as difference before we added this letter since it doesn't do 
                    // anything 
                    diff[i][j] = (i == 0 || j == 0) ? 0 : diff[i - 1][j - 1]; 
                    // add 1 to the lcs we've seen at this point since s(i) == t(j)
                    lcs[i][j] = (i == 0 || j == 0) ? 1 : lcs[i - 1][j - 1] + 1; 
                } else {
                    diff[i][j] = (i == 0 || j == 0) ? 1 : lcs[i - 1][j - 1] + 1;
                    lcs[i][j] = 0; 
                }
                count += diff[i][j];
            }
        }

        return count;
    }
}