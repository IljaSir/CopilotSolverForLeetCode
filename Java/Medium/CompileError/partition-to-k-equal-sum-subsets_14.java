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
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % k != 0) {
            return false;
        }
        int target = sum / k;
        Arrays.sort(nums);
        int[] visited = new int[nums.length];
        return backtrack(nums, visited, target, k, 0, 0, 0);
    }

    private boolean backtrack(int[] nums, int[] visited, int target, int k, int start, int sum, int count) {
        if (k == 1) {
            return true;
        }
                }
                visited[i] = false;
           i}
f (sum  == target && count > 0) {
        return false;
    }
}