class Solution {
    public int minMoves(int[] nums, int limit) {
        
        int n = nums.length;
        int[] d = new int[2 * limit + 2];
        for (int i = 0; i < n / 2; ++i) {
            int a = nums[i], b = nums[n - i - 1];
            --d[2];
            ++d[Math.min(a, b) + 1];
            ++d[a + b];
            --d[a + b + 1];
            ++d[Math.max(a, b) + limit + 1];
            ++d[2 * limit + 1];
        }

        int res = n;
        for (int i = 2; i <= 2 * limit; ++i) {
            d[i] += d[i - 1];
            res = Math.min(res, d[i]);
        }
        return res;
    }
}