class Solution {
public:
    int minimumLines(vector<vector<int>>& stockPrices) {
        
        int n = stockPrices.size();
        if (n <= 2) return n;
        int ans = 2;
        vector<int> dp(n, 1);
        for (int i = 1; i < n; ++i) {
            int l = 0, r = i - 1;
            while (l < r) {
                int m = l + (r - l) / 2;
                long long x1 = stockPrices[m][0], y1 = stockPrices[m][1];
                long long x2 = stockPrices[i][0], y2 = stockPrices[i][1];
                if (x1 * y2 == x2 * y1) {
                    l = m;
                    break;
                } else if (x1 * y2 > x2 * y1) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }
            if (l == r) {
                dp[i] = dp[r] + 1;
            } else {
                dp[i] = dp[l] + 1;
            }
            ans = max(ans, dp[i]);
        }
        return ans;
    }
};