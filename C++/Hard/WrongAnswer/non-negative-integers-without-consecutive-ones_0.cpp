class Solution {
public:
    int findIntegers(int n) {
        
        vector<int> dp(32, 0);
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < 32; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        int pre = 0, res = 0;
        for (int i = 30; i >= 0; i--) {
            int val = 1 << i;
            if (n & val) {
                n -= val;
                res += dp[i + 1];
                if (pre == 1) {
                    res -= 1;
                    break;
                }
                pre = 1;
            } else {
                pre = 0;
            }
            if (i == 0) {
                res += 1;
            }
        }
        return res;
    }
};