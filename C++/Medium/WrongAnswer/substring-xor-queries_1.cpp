class Solution {
public:
    vector<vector<int>> substringXorQueries(string s, vector<vector<int>>& queries) {
        
        vector<int> dp(s.size() + 1, 0);
        for (int i = 1; i <= s.size(); i++) {
            dp[i] = dp[i - 1] ^ (s[i - 1] - '0');
        }
        vector<vector<int>> ans;
        for (auto& q : queries) {
            int l = q[0], r = q[1];
            ans.push_back({dp[l] ^ dp[r + 1], r});
        }
        sort(ans.begin(), ans.end());
        vector<vector<int>> res;
        for (auto& a : ans) {
            res.push_back({a[1], a[0]});
        }
        return res;
    }
};