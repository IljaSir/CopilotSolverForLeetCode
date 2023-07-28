class Solution {
public:
    vector<bool> canMakePaliQueries(string s, vector<vector<int>>& queries) {
        
        int n = s.size();
        vector<vector<int>> count(n + 1, vector<int>(26, 0));
        for (int i = 0; i < n; i++) {
            count[i + 1] = count[i];
            count[i + 1][s[i] - 'a']++;
        }
        vector<bool> res;
        for (auto& q: queries) {
            int odd = 0;
            for (int i = 0; i < 26; i++) {
                odd += (count[q[1] + 1][i] - count[q[0]][i]) % 2;
            }
            res.push_back(odd / 2 <= q[2]);
        }
        return res;
    }
};