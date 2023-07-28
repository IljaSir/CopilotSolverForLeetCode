class Solution {
public:
    vector<bool> canMakePaliQueries(string s, vector<vector<int>>& queries) {
        
        int n = s.size();
        vector<vector<int>> cnt(n + 1, vector<int>(26, 0));
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < 26; ++j) {
                cnt[i + 1][j] = cnt[i][j];
            }
            cnt[i + 1][s[i] - 'a']++;
        }
        vector<bool> ans;
        for (auto q: queries) {
            int odd = 0;
            for (int i = 0; i < 26; ++i) {
                odd += (cnt[q[1] + 1][i] - cnt[q[0]][i]) & 1;
            }
            ans.push_back(odd / 2 <= q[2]);
        }
        return ans;
    }
};