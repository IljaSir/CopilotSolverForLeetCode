class Solution {
    public int minMoves(int[] nums, int limit) {
        
        int n = nums.length;
        int[] diff = new int[2 * limit + 2];
        for (int i = 0; i < n / 2; i++) {
            int sum = nums[i] + nums[n - 1 - i];
            diff[2] += 2;
            diff[sum]--;
            diff[sum + 1]++;
            diff[sum + limit + 1]--;
            diff[2 * limit + 1]++;
        }
        int ans = n;
        int cur = 0;
        for (int i = 2; i <= 2 * limit; i++) {
            cur += diff[i];
            ans = Math.min(ans, cur);
        }
        return ans;
    }
}