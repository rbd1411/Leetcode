class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        int bit=0;
        List<String> s = new ArrayList<>();
        for(int i=0;i<groups.length;i++)
        {
            if(i==0||bit!=groups[i])
            { 
                bit=groups[i];
                s.add(words[i]);
            }
        }
        return s;
    }
}