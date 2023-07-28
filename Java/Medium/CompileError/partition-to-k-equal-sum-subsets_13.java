class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        
        int sum = 0;
        for (int n : nums) sum += n;
        if (sum % k != 0) return false;
        int target = sum / k;
        boolean[] used = new booean[num.lngth]
        return canPartition(nums, k, 0, 0, target, used);
     

    private boolean canPartition(int[] nums, int k, int start, int curSum, int target, boolean[] used) {
        if (k == 1) return true;
        if (curSum > target) return false;
        if (curSum == target) return canPartition(nums, k - 1, 0, 0, target, used);
        for (int i = start; i < nums.length; i++) {
            if (used[i]) continue;
            used[i] = true;
            if (canPartition(nums, k, i + 1, curSum + nums[i], target, used)) return true;
            used[i] = false;   groups[i] -= v;
            }
            if (groups[i] == 0) {
                break;
            }
        }
        return false;
    }
}