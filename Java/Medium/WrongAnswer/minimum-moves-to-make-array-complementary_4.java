class Solution {
    public int minMoves(int[] nums, int limit) {
        
        int n = nums.length;
        int[] diff = new int[2 * limit + 2];
        for (int i = 0; i < n / 2; i++) {
            int a = nums[i];
            int b = nums[n - 1 - i];
            int l = Math.min(a, b) + 1;
            int r = Math.max(a, b) + limit;
            diff[l]--;
            diff[a + b]--;
            diff[a + b + 1]++;
            diff[r + 1]++;
        }
        int res = n;
        int cur = 0;
        for (int i = 2; i <= 2 * limit; i++) {
            cur += diff[i];
            res = Math.min(res, cur);
        }
        return res;
    }
}