class Solution {
public:
    int minimumPartition(string s, int k) {
        
        int n = s.size();
        vector<int> dp(n+1, INT_MAX);
        dp[0] = 0;
        for(int i=1; i<=n; i++) {
            int cur = 0;
            for(int j=i; j>=1; j--) {
                cur = cur*10 + s[j-1] - '0';
                if(cur > k) break;
                if(dp[j-1] != INT_MAX) dp[i] = min(dp[i], dp[j-1]+1);
            }
        }
        return dp[n] == INT_MAX ? -1 : dp[n];
    }
};