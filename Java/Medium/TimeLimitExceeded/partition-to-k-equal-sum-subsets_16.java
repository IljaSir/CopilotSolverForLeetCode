class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % k != 0) {
            return false;
        }
        int target = sum / k;
        boolean[] visited = new boolean[nums.length];
        return canPartition(nums, visited, k, 0, 0, target);
    }

    public boolean canPartition(int[] nums, boolean[] visited, int k, int start, int curSum, int target) {
        if (k == 1) {
            return true;
        }
        if (curSum == target) {
            return canPartition(nums, visited, k - 1, 0, 0, target);
        }
        for (int i = start; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                if (canPartition(nums, visited, k, i + 1, curSum + nums[i], target)) {
                    return true;
                }
                visited[i] = false;
            }
        }
        return false;
    }
}