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
        int[] visited = new int[nums.length];
        return dfs(nums, visited, 0, k, 0, 0, target);
    }

    private boolean dfs(int[] nums, int[] visited, int start_index, int k, int cur_sum, int cur_num, int target) {
        if (k == 1) {
            return true;
        }
        if (cur_sum == target && cur_num > 0) {
            return dfs(nums, visited, 0, k - 1, 0, 0, target);
        }
        for (int i = start_index; i < nums.length; i++) {
            if (visited[i] == 0) {
                visited[i] = 1;
                if (dfs(nums, visited, i + 1, k, cur_sum + nums[i], cur_num++, target)) {
                    return true;
                }
                visited[i] = 0;
            }
        }
        return false;
    }
}