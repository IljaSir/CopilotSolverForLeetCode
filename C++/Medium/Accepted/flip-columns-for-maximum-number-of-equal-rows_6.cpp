class Solution {
public:
    int maxEqualRowsAfterFlips(vector<vector<int>>& matrix) {
        
        unordered_map<string, int> m;
        for (auto& r : matrix) {
            string s1, s2;
            for (auto& v : r) {
                s1 += v + '0';
                s2 += !v + '0';
            }
            m[s1]++;
            m[s2]++;
        }
        int ans = 0;
        for (auto& p : m) {
            ans = max(ans, p.second);
        }
        return ans;
    }
};