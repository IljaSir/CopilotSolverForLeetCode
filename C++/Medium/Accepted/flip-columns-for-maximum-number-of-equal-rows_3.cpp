class Solution {
public:
    int maxEqualRowsAfterFlips(vector<vector<int>>& matrix) {
        
        unordered_map<string, int> cnt;
        for (auto& row : matrix) {
            string s1, s2;
            for (auto& c : row) {
                s1 += '0' + c;
                s2 += '0' + 1 - c;
            }
            cnt[s1]++; cnt[s2]++;
        }
        int ans = 0;
        for (auto& [_, v] : cnt) ans = max(ans, v);
        return ans;
    }
};