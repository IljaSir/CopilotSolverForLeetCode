class Solution {
    public int pivotIndex(int[] nums) {
        
        int sum = 0;
        for(int i : nums) {
            sum += i;
        }
        int leftSum = 0;
        for(int i = 0; i < nums.length; i++) {
            if(leftSum * 2 == sum - nums[i]) {
                return i;
            } else {
                leftSum += nums[i];
            }
        }
        return -1;
    }
}