class Solution {
public:
    int garbageCollection(vector<string>& garbage, vector<int>& travel) {
        
        int n = garbage.size();
        vector<int> mp(n, 0);
        vector<int> pg(n, 0);
        vector<int> mg(n, 0);
        for (int i = 0; i < n; i++) {
            for (char ch : garbage[i]) {
                if (ch == 'M') {
                    mp[i]++;
                } else if (ch == 'P') {
                    pg[i]++;
                } else {
                    mg[i]++;
                }
            }
        }
        vector<int> dp(n, INT_MAX);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            if (i > 0) {
                dp[i] = min(dp[i], dp[i - 1] + travel[i - 1]);
            }
            if (mp[i]) {
                dp[i] = min(dp[i], dp[i] + mp[i]);
            }
            if (pg[i]) {
                dp[i] = min(dp[i], dp[i] + pg[i]);
            }
            if (mg[i]) {
                dp[i] = min(dp[i], dp[i] + mg[i]);
            }
        }
        return dp[n - 1];
    }
};