class Solution {
    public int minMoves(int[] nums, int limit) {
        
        int[] diff = new int[2 * limit + 2];
        int n = nums.length;
        for (int i = 0; i < n / 2; i++) {
            int sum = nums[i] + nums[n - 1 - i];
            diff[2] += 2;
            diff[Math.min(nums[i], nums[n - 1 - i]) + 1]--;
            diff[sum]--;
            diff[sum + 1]++;
            diff[Math.max(nums[i], nums[n - 1 - i]) + limit + 1]++;
        }
        int res = n, cur = 0;
        for (int i = 2; i <= 2 * limit; i++) {
            cur += diff[i];
            res = Math.min(res, cur);
        }
        return res;
    }
}