class Solution {
public:
    int numberOfUniqueGoodSubsequences(string binary) {
        
        int n = binary.size();
        int mod = 1000000007;
        vector<long long> dp(n+1, 0);
        dp[0] = 1;
        int lastOne = -1;
        for(int i = 0; i < n; i++) {
            if(binary[i] == '0') {
                dp[i+1] = (dp[i] * 2) % mod;
            } else {
                dp[i+1] = (dp[i] * 2 + 1) % mod;
                lastOne = i;
            }
        }
        if(lastOne == -1) {
            return 1;
        } else {
            return dp[lastOne+1];
        }
    }
};