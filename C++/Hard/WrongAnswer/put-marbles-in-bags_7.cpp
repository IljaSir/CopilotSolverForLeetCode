class Solution {
public:
    long long putMarbles(vector<int>& weights, int k) {
        
        int n = weights.size();
        vector<long long> pre(n+1);
        for (int i = 0; i < n; ++i) pre[i+1] = pre[i] + weights[i];
        vector<vector<long long>> dp(k+1, vector<long long>(n+1, 1e18));
        for (int i = 0; i <= n; ++i) dp[1][i] = 0;
        for (int i = 2; i <= k; ++i) {
            for (int j = i; j <= n; ++j) {
                for (int l = i-1; l < j; ++l) {
                    dp[i][j] = min(dp[i][j], dp[i-1][l] + (pre[j]-pre[l])*(pre[j]-pre[l]));
                }
            }
        }
        return dp[k][n];
    }
    int minimumIncompatibility(vector<int>& weights, int k) {
        int n = weights.size();
        if (n%k) return -1;
        int m = n/k;
        sort(begin(weights), end(weights));
        int ans = 1e9;
        do {
            int cur = 0;
            for (int i = 0; i < n; i += m) {
                cur += weights[i+m-1] - weights[i];
            }
            ans = min(ans, cur);
        } while (next_permutation(begin(weights), end(weights)));
        return ans;
    }
};