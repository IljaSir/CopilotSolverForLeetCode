class Solution {
    public int minOperations(int[] nums, int[] numsDivide) {
        
        int n = nums.length;
        int m = numsDivide.length;
        int gcd = 0;
        for (int i = 0; i < m; ++i) {
            gcd = gcd(gcd, numsDivide[i]);
        }
        int[] cnt = new int[gcd];
        for (int i = 0; i < n; ++i) {
            cnt[nums[i] % gcd]++;
        }
        int res = n;
        for (int i = 0; i < m; ++i) {
            if (numsDivide[i] % gcd == 0) {
                res = Math.min(res, n - cnt[0]);
            }
        }
        return res == n ? -1 : res;
    }
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}