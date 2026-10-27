class Solution {
    public double minimumAverage(int[] nums) 
    {
        Arrays.sort(nums);
        int l=0;
        int r=nums.length-1;
        double ans=Double.MAX_VALUE;
        while(l<r)
        {
            ans=Math.min(ans,((double)nums[l]+(double)nums[r])/2);
            l++;
            r--;
        }
        return ans;
    }
}