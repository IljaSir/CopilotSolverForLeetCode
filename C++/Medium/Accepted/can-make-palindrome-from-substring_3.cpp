class Solution {
public:
    vector<bool> canMakePaliQueries(string s, vector<vector<int>>& queries) {
        
        int n = s.size();
        vector<int> dp(n + 1, 0);
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] ^ (1 << (s[i - 1] - 'a'));
        }
        vector<bool> ans;
        for (auto& q : queries) {
            int diff = dp[q[1] + 1] ^ dp[q[0]];
            int cnt = 0;
            for (int i = 0; i < 26; i++) {
                if (diff & (1 << i)) cnt++;
            }
            ans.push_back(cnt / 2 <= q[2]);
        }
        return ans;
    }
};