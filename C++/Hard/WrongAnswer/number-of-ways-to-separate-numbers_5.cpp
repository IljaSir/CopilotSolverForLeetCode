class Solution {
public:
    int numberOfCombinations(string num) {
        
        int n = num.size();
        vector<int> dp(n + 1, 0);
        dp[n] = 1;
        for(int i = n - 1; i >= 0; i--) {
            if(num[i] == '0') {
                dp[i] = 0;
                continue;
            }
            dp[i] = dp[i + 1];
            if(i + 1 < n) {
                dp[i] += dp[i + 2];
                if(num[i] == '1' || (num[i] == '2' && num[i + 1] <= '6')) {
                    if(i + 2 < n) {
                        dp[i] += dp[i + 3];
                    } else {
                        dp[i] += 1;
                    }
                }
            }
            dp[i] %= 1000000007;
        }
        return dp[0];
    }
};