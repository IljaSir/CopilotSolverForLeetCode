class Solution {
    public int minOperations(int[] nums) {
        
        int res = 0;
        int prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= prev) {
                res += prev + 1 - nums[i];
                prev++;
            } else {
                prev = nums[i];
            }
        }
        return res;
    }
}