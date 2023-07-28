class Solution {
    public int minMoves(int[] nums, int limit) {
        
        int n = nums.length;
        int[] delta = new int[2 * limit + 2];
        for (int i = 0; i < n / 2; i++) {
            int a = nums[i], b = nums[n - 1 - i];
            delta[2] += 2;
            delta[Math.min(a, b) + 1] -= 1;
            delta[a + b] -= 1;
            delta[a + b + 1] += 1;
            delta[Math.max(a, b) + limit + 1] += 1;
        }
        int res = n, cur = 0;
        for (int i = 2; i <= 2 * limit; i++) {
            cur += delta[i];
            res = Math.min(res, cur);
        }
        return res;
    }
}