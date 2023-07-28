class Solution {
    public int numSquarefulPerms(int[] nums) {
        
        int n = nums.length;
        boolean[] used = new boolean[n];
        int[] path = new int[n];
        int[] res = new int[1];
        Arrays.sort(nums);
        dfs(nums, used, path, 0, res);
        return res[0];
    }
    
    private void dfs(int[] nums, boolean[] used, int[] path, int idx, int[] res) {
        if (idx == nums.length) {
            res[0]++;
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) {
                continue;
            }
            if (idx == 0 || isSquare(nums[i] + nums[idx - 1])) {
                used[i] = true;
                path[idx] = nums[i];
                dfs(nums, used, path, idx + 1, res);
                used[i] = false;
            }
        }
    }
}