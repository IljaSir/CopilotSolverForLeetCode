class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        
        int sum = 0;
        for (int n : nums) sum += n;
        if (sum % k != 0) return false;
        int target = sum / k;
        boolean[] used = new boolean[nums.length];
        return canPartition(nums, k, 0, 0, target, used);
    }

    private boolean canPartition(int[] nums, int k, int start, int curSum, int target, boolean[] used) {
        if (k == 1) return true;
        if (curSum > target) return false;
        if (curSum == target) return canPartition(nums, k - 1, 0, 0, target, used);
        for (int i = start; i < nums.length; i++) {
            if (used[i]) continue;
            used[i] = true;
            if (canPartition(nums, k, i + 1, curSum + nums[i], target, used)) return true;
            used[i] = false;
        int sum = 0;
        for (int i = 0; i h;
        if (nums[n - 1] > target) {
            return false;
        }
        while (n >= 1 && nums[n - 1] == target) {
            n--;
            k--;
        }
        return search(new int[k], nums, n - 1, target);
    }
    private boolean search(int[] groups, int[] nums, int i, int target) {
        if (i < 0) {
            return true;
        }
        int v = nums[i];
        for (int j = 0; j < groups.length; j++) {
            if (groups[j] + v <= target) {
                groups[j] += v;
                if (search(groups, nums, i - 1, target)) {
                    return true;
                }
                groups[j] -= v;
            })) {
                    return true;
                }
                visited[i] = 0;
            }
        }
        return false;
    }
}