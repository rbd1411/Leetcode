class Solution {
    public String stringHash(String s, int k) {
        StringBuilder ans = new StringBuilder();

        for(int i =0 ;i<s.length();i=i+k){
            int num = i;
            int sum = 0;
            while(num < i + k && num < s.length()){              
            char ch = s.charAt(num);
                sum = sum + (int)ch - 97;
                num++;
            }
            ans.append((char)((sum%26)+97));
        }
        return ans.toString();
    }
}