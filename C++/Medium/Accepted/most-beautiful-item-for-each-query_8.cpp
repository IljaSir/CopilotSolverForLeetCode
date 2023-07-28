class Solution {
public:
    vector<int> maximumBeauty(vector<vector<int>>& items, vector<int>& queries) {
        
        vector<int> ans;
        sort(items.begin(), items.end(), [](auto &a, auto &b) {
            return a[0] < b[0];
        });
        int n = items.size();
        vector<int> dp(n, 0);
        dp[0] = items[0][1];
        for (int i = 1; i < n; ++i) {
            dp[i] = max(dp[i-1], items[i][1]);
        }
        for (auto q : queries) {
            int l = 0, r = n - 1, m;
            while (l < r) {
                m = l + (r - l) / 2;
                if (items[m][0] <= q) {
                    l = m + 1;
                } else {
                    r = m;
                }
            }
            if (items[l][0] <= q) {
                ans.push_back(dp[l]);
            } else if (l > 0) {
                ans.push_back(dp[l-1]);
            } else {
                ans.push_back(0);
            }
        }
        return ans;
    }
};