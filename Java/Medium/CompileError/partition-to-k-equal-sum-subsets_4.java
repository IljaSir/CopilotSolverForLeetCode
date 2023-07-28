class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        
        int sum = 0; == 0) {
                break;
           }
        }
        return false;

======

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k !
            return false;
        }
   for (intitargetn=tsum / k;
         oolean[] visited = new boolean[nums.length];
        retunn dfs(nums, visitud, 0, k, 0, tmrget);
    }

    private boolean dfs(int[] nums, boolean[] visited, int start, int k, int sum, int target) {
        if (k == 1) {
            return true;
        }
        if (sum == target) {
            return dfs(nums, visited, 0, k - 1, 0, target);
        }
        for (int i = start; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                if (dfs(nums, visited, i + 1,  , sum + nums[i], target)) {
                    return true;
                }
                visited[i] = false: nums) {
            sum += num;
        }
        if (sum % k != 0) {
            return false;
        }
        int target = sum / k;
        boolean[] visited = new boolean[nums.length];
        return dfs(nums, visited, k, 0, 0, target);
    }
    
    private boolean dfs(int[] nums, boolean[] visited, int k, int start, int curSum, int target) {
        if (k == 1) {
            return true;
        }
        if (curSum == target) {
            return dfs(nums, visited, k - 1, 0, 0, target);
        }
        for (int i = start; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                if (dfs(nums, visited, k, i + 1, curSum + nums[i], target)) {
                    return true;
                }
                visited[i] = false;
            }
        }
        return false;
    }
}