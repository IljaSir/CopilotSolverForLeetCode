class Solution {
public:
    int maxEqualRowsAfterFlips(vector<vector<int>>& matrix) {
        
        int m = matrix.size();
        int n = matrix[0].size();
        unordered_map<string, int> hash;
        for (auto& row : matrix) {
            string s;
            for (int i = 0; i < n; i++) {
                s += (row[i] ^ row[0]) + '0';
            }
            hash[s]++;
        }
        int res = 0;
        for (auto& [k, v] : hash) {
            res = max(res, v);
        }
        return res;
    }
};