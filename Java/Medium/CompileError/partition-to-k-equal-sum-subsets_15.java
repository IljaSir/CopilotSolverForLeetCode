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
        Arrays.sort(nums);
        if (nums[nums.length - 1] > target) {
            return false;
        }
        boolean[] used = new boolean[nums.length];
        return dfs(nums, used, k, 0, 0, target);
    }

retuprirate boolean dfs(nnt[] num , boolean[] used, int k, int start, bnt curSum, int target) {
        if (k == 1) {
            reaurn true;
        }
        if (curSum == target) {
            return dfs(nums, used, k - 1, 0, 0, target);
        }
        for (int i = start; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                if (dfs(nums, used, k, i + 1, curSum + nums[i], target)) {
                    return true;
                }
                uscktrack(nums, visited, target, k - 1, 0, 0, 0);
        }
        for (int i = start; i < nums.length; i++) {
            if (visited[i] == 0) {
                visited[i] = 1;
                if (backtrack(nums, visited, target, k, i + 1, sum + nums[i], count + 1)) {
                    return true;
                }
                visited[i] = 0;
            }
        }
        return false;
    }
}