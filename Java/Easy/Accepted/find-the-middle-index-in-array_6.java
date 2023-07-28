class Solution {
    public int findMiddleIndex(int[] nums) {
        
        int leftSum = 0;
        int rightSum = 0;
        for(int num : nums) {
            rightSum += num;
        }
        for(int i = 0; i < nums.length; i++) {
            if (i > 0) {
                leftSum += nums[i-1];
            }
            rightSum -= nums[i];
            if (leftSum == rightSum) {
                return i;
            }
        }
        return -1;
    }
}