class Solution {
public:
    int numberOfUniqueGoodSubsequences(string binary) {
        
        int n = binary.size();
        int dp[n + 1];
        dp[0] = 0;
        int i;
        for (i=1; i<=n; i++) {
            if (binary[i-1] == '0') {
                dp[i] = dp[i-1];
            } else {
                dp[i] = dp[i-1] + 1;
            }
        }
        int cnt = 0;
        for (i=0; i<n; i++) {
            if (binary[i] == '1') {
                cnt++;
            }
        }
        if (cnt == 0) {
            return 1;
        }
        return (dp[n] + pow(2, cnt-1)) % (1000000000 + 7);
    }
};