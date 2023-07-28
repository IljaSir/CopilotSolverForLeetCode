class Solution {
public:
    int uniqueLetterString(string s) {
        
        int n = s.size();
        vector<vector<int>> pos(26);
        for (int i = 0; i < n; ++i) {
            pos[s[i] - 'A'].push_back(i);
        }
        int ans = 0, mod = 1e9 + 7;
        for (int i = 0; i < 26; ++i) {
            for (int j = 0; j < pos[i].size(); ++j) {
                int prev = j > 0 ? pos[i][j - 1] : -1;
                int next = j < pos[i].size() - 1 ? pos[i][j + 1] : n;
                ans = (ans + (pos[i][j] - prev) * (next - pos[i][j])) % mod;
            }
        }
        return ans;
    }
};