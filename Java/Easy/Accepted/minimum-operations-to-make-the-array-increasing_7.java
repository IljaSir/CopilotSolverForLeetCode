class Solution {
    public int minOperations(int[] nums) {
        
        int count = 0;
        int cur = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= cur) {
                count += cur - nums[i] + 1;
                cur++;
            } else {
                cur = nums[i];
            }
        }
        return count;
    }
}