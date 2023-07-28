class Solution {
public:
    vector<vector<int>> substringXorQueries(string s, vector<vector<int>>& queries) {
        
        int n = s.size();
        vector<int> prefix(n + 1, 0);
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] ^ (s[i] - '0');
        }
        vector<vector<int>> ans;
        for (auto &q : queries) {
            int first = q[0];
            int second = q[1];
            for (int i = 0; i <= n; i++) {
                if ((prefix[i] ^ first) == second) {
                    ans.push_back({i - 1, i});
                    break;
                }
            }
        }
        return ans;
    }
};