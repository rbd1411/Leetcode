class Solution {
    public String longestSubsequenceRepeatedK(String s, int k) {
        int n = s.length();
        int freq[] = new int[26];

        for(int i=0;i<n;i++){
            int ch = s.charAt(i) - 'a';
            freq[ch]++;
        }

        StringBuilder sb = new StringBuilder("");
        for(int i=25;i>=0;i--){
            if(freq[i] >= k)
                sb.append((char)(i+'a'));
        }

        return helper(s,sb.toString(),"",k);
    }

    private String helper(String s,String newS,String currS,int k){
        if(!kSub(s,currS,k))
            return "";

        String res = currS;
        for(char ch : newS.toCharArray()){
            String ret = helper(s, newS, currS + ch, k);
            if (ret.length() > res.length())
                res = ret;
            else if (ret.length() == res.length())
                res = res.compareTo(ret) > 0 ? res : ret;
        }

        return res;   
    }

    private boolean kSub(String s,String currS,int k){
        int i = 0;
        int n = s.length();
        int m = currS.length();
        if (m == 0) return true;

        while(i < n && k > 0){
            int j = 0;
            while(i < n && j < m){
                if(s.charAt(i) == currS.charAt(j))
                    j++;
                i++;
            }
            
            if(j == m)
                k--;
        }

        return k == 0;
    }
}