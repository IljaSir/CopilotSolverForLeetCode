class Solution {
    public int squareFreeSubsets(int[] nums) {
        
        int[] dp = new int[1 << nums.length];
        dp[0] = 1;
        int mod = 1000000007;
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            int mask = 0;
            for (int j = 0; j < nums.length; j++) {
                if (i != j && nums[j] == cur) {
                    mask |= (1 << j);
                }
            }
            for (int j = (1 << nums.length) - 1; j >= 0; j--) {
                if ((j & (1 << i)) != 0 || (j & mask) != 0) {
                    continue;
                }
                dp[j | (1 << i)] = (dp[j | (1 << i)] + dp[j]) % mod;
            }
        }
        int res = 0;
        for (int i = 0; i < (1 << nums.length); i++) {
            int cnt = 0;
            for (int j = 0; j < nums.length; j++) {
                if ((i & (1 << j)) != 0) {
                    cnt++;
                }
            }
            if (cnt % 2 == 0) {
                res = (res + dp[i]) % mod;
            } else {
                res = (res - dp[i] + mod) % mod;
            }
        }
        return res;
    }
}