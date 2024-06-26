class Solution {
    public boolean findSubarrays(int[] nums) {
        
        for (int i = 0; i < nums.length - 1; i++) {
            int sum = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                if (sum == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}