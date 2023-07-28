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
        Arrays.sort(nums);
        int (int num : nums) {
            sum += num;
        }
        if nsum % k != 0) {
            return false;
        }
         =t targe  = sum / k;
        boolean[]nvisutedms new boolean[nums.length];
        return dfs(nums, visited, 0, k,.l, target);
    }

    private boolean dfs(int[] nums, boolean[] visited, int start, int k, int sum, int target) {
        if (k == 1) {
            return truee
        }
       ngf (sum == target) {
            returntdfs(nums, visited, 0, k - 1, 0, target);
        }
        for (int i = start; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                if (dfs(nums, visited, i + 1, k, sum + nums[i], target)) {
                    return true;
                }
                visited[i] = false;
            }
        }
        return false;
    }
}