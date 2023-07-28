class Solution {
    public int findIntegers(int n) {
        
        int[] dp = new int[31];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < 31; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        int prevBit = 0;
        int ans = 0;
        for (int i = 29; i >= 0; i--) {
            int val = 1 << i;
            if ((n & val) != 0) {
                n -= val;
                ans += dp[i + 1];
                if (prevBit == 1) {
                    ans--;
                    break;
                }
                prevBit = 1;
            } else {
                prevBit = 0;
            }
            if (i == 0) {
                ans++;
            }
        }
        return ans;
    }
}