class Solution {
    public int minimizeSum(int[] nums) {
        
        int n = nums.length;
        int[] min = new int[n];
        int[] max = new int[n];
        min[0] = nums[0];
        for (int i = 1; i < n; i++)
            min[i] = Math.min(min[i - 1], nums[i]);
        max[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--)
            max[i] = Math.max(max[i + 1], nums[i]);
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n - 1; i++)
            res = Math.min(res, Math.max(nums[i + 1] - nums[0], max[i + 1] - nums[0]));
        for (int i = 1; i < n; i++)
            res = Math.min(res, Math.max(nums[n - 1] - nums[i], nums[n - 1] - min[i - 1]));
        return res;
    }
}