class Solution {
public:
    bool canDistribute(vector<int>& nums, vector<int>& quantity) {
        
        unordered_map<int, int> mp;
        for (auto& n: nums) ++mp[n];
        vector<int> cnt;
        for (auto& [k, v]: mp) cnt.push_back(v);
        sort(cnt.begin(), cnt.end());
        int n = cnt.size();
        int m = quantity.size();
        vector<vector<int>> dp(n+1, vector<int>(1<<m, 0));
        dp[n][0] = 1;
        for (int i=n-1; i>=0; --i) {
            for (int j=0; j<(1<<m); ++j) {
                if (dp[i+1][j] == 0) continue;
                dp[i][j] = 1;
                int k = 0;
                int t = j;
                while (t) {
                    if (t & 1) {
                        if (cnt[i] >= quantity[k]) {
                            dp[i][j | (1<<k)] = 1;
                        }
                    }
                    ++k;
                    t >>= 1;
                }
                if (cnt[i] >= quantity[k]) {
                    dp[i][j | (1<<k)] = 1;
                }
            }
        }
        return dp[0][(1<<m)-1] == 1;
    }
};