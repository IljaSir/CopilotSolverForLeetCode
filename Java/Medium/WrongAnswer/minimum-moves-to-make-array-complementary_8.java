class Solution {
    public int minMoves(int[] nums, int limit) {
        
        int n = nums.length;
        int[] diff = new int[2 * limit + 2];
        for (int i = 0; i < n / 2; ++i) {
            int lo = Math.min(nums[i], nums[n - 1 - i]) + 1;
            int hi = Math.max(nums[i], nums[n - 1 - i]) + limit;
            diff[lo]--;
            diff[hi + 1]++;
            diff[nums[i] + nums[n - 1 - i]] += 2;
        }
        int ans = n;
        int cur = 0;
        for (int i = 2; i <= 2 * limit; ++i) {
            cur += diff[i];
            ans = Math.min(ans, cur);
        }
        return ans;
    }
}