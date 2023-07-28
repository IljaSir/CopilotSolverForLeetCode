class Solution {
    public int squareFreeSubsets(int[] nums) {
        
        int n = nums.length;
        int mod = (int)1e9 + 7;
        int[] dp = new int[1 << n];
        dp[0] = 1;
        int ans = 0;
        for (int i = 1; i < (1 << n); i++) {
            int k = Integer.bitCount(i);
            int[] a = new int[k];
            int t = 0;
            for (int j = 0; j < n; j++) {
                if (((i >> j) & 1) == 1) {
                    a[t++] = nums[j];
                }
            }
            int c = 0;
            for (int j = 1; j < (1 << k); j++) {
                int b = Integer.bitCount(j);
                int p = 1;
                for (int l = 0; l < k; l++) {
                    if (((j >> l) & 1) == 1) {
                        p *= a[l];
                    }
                }
                if (b % 2 == 1) {
                    c += dp[i ^ p];
                } else {
                    c -= dp[i ^ p];
                }
            }
            dp[i] = c;
            if (c != 0) {
                ans += dp[i];
                ans %= mod;
            }
        }
        return ans;
    }
}