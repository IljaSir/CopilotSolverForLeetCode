class Solution {
public:
    int maxEqualRowsAfterFlips(vector<vector<int>>& matrix) {
        
        unordered_map<string, int> m;
        int res = 0;
        for (auto& v : matrix) {
            string s1 = "", s2 = "";
            for (int i = 0; i < v.size(); ++i) {
                s1 += v[i] + '0';
                s2 += (1 - v[i]) + '0';
            }
            m[s1] += 1;
            m[s2] += 1;
            res = max(res, max(m[s1], m[s2]));
        }
        return res;
    }
};