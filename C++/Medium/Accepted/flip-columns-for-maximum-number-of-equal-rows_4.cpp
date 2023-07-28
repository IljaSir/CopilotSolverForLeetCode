class Solution {
public:
    int maxEqualRowsAfterFlips(vector<vector<int>>& matrix) {
        
        unordered_map<string, int> m;
        int res = 0;
        for (auto& row : matrix) {
            string s1, s2;
            for (auto& c : row) {
                s1 += to_string(c);
                s2 += to_string(!c);
            }
            m[s1]++;
            m[s2]++;
            res = max(res, max(m[s1], m[s2]));
        }
        return res;
    }
};