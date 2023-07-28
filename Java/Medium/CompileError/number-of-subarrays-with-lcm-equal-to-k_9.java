class Solution {
    public int subarrayLCM(int[] nums, int k) {
        
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0] % k == 0 ? 1 : 0;
        int ans = dp[0];
        for (int i = 1; i < n; i++) {
            dp[i] = nums[i] % k == 0 ? 1 : 0;
            for (int j = i - 1; j >= 0; j--) {
                int g = gcd(nums[j], nums[i]);
                if (g % k == 0) {
                    dp[i] += dp[j] + 1;
                }
            }
            ans += dp[i];
        }
        return ans;
    }
    private int gcd(int a, int b) {
        return a == 0 ? b : gcd(b % a, a);
    }
}
    }
}