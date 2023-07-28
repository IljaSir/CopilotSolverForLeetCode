class Solution {
    public int findMiddleIndex(int[] nums) {
        
        int leftSum = 0;
        int rightSum = 0;
        for (int i = 1; i < nums.length; i++) {
            rightSum += nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            if (leftSum == rightSum) {
                return i;
            }
            leftSum += nums[i];
            if (i + 1 < nums.length) {
                rightSum -= nums[i + 1];
            }
        }
        return -1;
    }
}