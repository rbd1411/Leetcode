class Solution {
    //lets find the answer for this problem:
    static int Index(int[] nums){
        int MIN = nums[0];
        int Ind = 0;
        for(int i = 1;i < nums.length;i++){
            if(nums[i] < MIN){
                MIN = nums[i];
                Ind = i;
            }
        }
        return Ind; //it will return the index;
    }
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        //need to revolve the array nums for k times:
        int Pointer = 1;
        while(Pointer <= k){
            //now we need to git min index of nums:
            int minimum_index = Index(nums);
            int val = nums[minimum_index] * multiplier;
            nums[minimum_index] = val;
            Pointer++;
        }
        return nums;
    }
}