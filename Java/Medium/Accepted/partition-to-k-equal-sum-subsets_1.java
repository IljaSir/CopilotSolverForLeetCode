class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) {
            return false;
        }
        int target = sum / k;
        return backtracking(nums, new boolean[nums.length], k, target, 0, 0);
    }

    public boolean backtracking(int[] nums, boolean[] used, int k, int target, int curSum, int start) {
        if (k == 0) {
            return true;
        }
        if (curSum == target) {
            return backtracking(nums, used, k - 1, target, 0, 0);
        }
        for (int i = start; i < nums.length; i++) {
            if (!used[i] && curSum + nums[i] <= target) {
                used[i] = true;
                if (backtracking(nums, used, k, target, curSum + nums[i], i + 1)) {
                    return true;
                }
                used[i] = false;
            }
        }
        return false;
    }
}