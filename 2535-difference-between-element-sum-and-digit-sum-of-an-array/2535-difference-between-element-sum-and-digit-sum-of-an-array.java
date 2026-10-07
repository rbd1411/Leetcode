class Solution {
    public int differenceOfSum(int[] nums) {
        int sum=0;
        int sum2=0;
        for(int i = 0 ; i<nums.length ; i++){
            sum+=nums[i];
            while(nums[i]>0){
                int ld = nums[i]%10;
                sum2+=ld;
                nums[i]/=10;
            }
        }
        return sum-sum2;
    }
}