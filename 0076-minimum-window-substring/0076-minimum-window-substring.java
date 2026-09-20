class Solution {
    public String minWindow(String str, String t) {
        int[] freqt = new int[128];
        int[] freqs = new int[128];
        int m = 0;
        for(char ch:t.toCharArray()){
            if(freqt[ch] == 0)++m;
            freqt[ch]++;
        }
        char[] s = str.toCharArray();
        int n = s.length;
        int minWindow = Integer.MAX_VALUE;
        int start = -1 , end = -1;
        int left = 0;
        for(int right = 0 ; right < n ; ++right){
            char chs = s[right];
            freqs[chs]++;
            if(freqs[chs] == freqt[chs])--m;
            while(m == 0 && left <= right){
                if(right - left + 1 < minWindow){
                    minWindow = right - left+1;
                    start = left;
                    end = right + 1;
                }
                char chl = s[left++];
                freqs[chl]--;
                if(freqs[chl] < freqt[chl])++m;
            }
        }
        return minWindow == Integer.MAX_VALUE ? "" : str.substring(start,end);
    }
}