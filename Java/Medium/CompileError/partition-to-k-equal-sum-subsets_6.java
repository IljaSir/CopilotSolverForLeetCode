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
        boolean[] visited = neisited, 0, k - 1, 0, 0, target);
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