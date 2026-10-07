class Solution {
    public int countDigitOccurrences(int[] nums, int digit) {
        int res=0;
        for(int n:nums){
            while(n!=0){
                int d=n%10;
                n/=10;
                if(d==digit)res++;
            }
        }
        return res;
    }
}