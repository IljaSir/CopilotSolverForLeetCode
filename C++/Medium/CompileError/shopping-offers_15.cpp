class Solution {
public:
    int shoppingOffers(vector<int>& price, vector<vector<int>>& special, vector<int>& needs) {
        
        int n = needs.size();
        vector<int> dp(1 << n, 0);
        for (int i = 1; i < dp.size(); i++) {
            dp[i] = INT_MAX;
            for (int j = 0; j < n; j++) {
                if ((i >> j) & 1) {
                    dp[i] = min(dp[i], dp[i ^ (1 << j)] + price[j]);
                }
            }
        }
        for (auto& s : special) {
            vector<int> ns(needs);
            int mask = 0;
            for (int i = 0; i < n; i++) {
                if (ns[i] >= s[i]) {
                    ns[i] -= s[i];
                } else {
                    mask = -1;
                    break;
                }
                mask |= ns[i] << i;
            }
            if (mask != -1) {
                dp[mask] = min(dp[mask], dp[i] + s.back());
            }
        }
        return dp.back();
    }
};