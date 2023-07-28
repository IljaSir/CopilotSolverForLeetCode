class Solution {
public:
    int maxEqualRowsAfterFlips(vector<vector<int>>& matrix) {
        
        int m = matrix.size();
        int n = matrix[0].size();
        unordered_map<string, int> mp;
        for (int i = 0; i < m; i++) {
            string s;
            for (int j = 0; j < n; j++) {
                s += to_string(matrix[i][j] ^ matrix[i][0]);
            }
            mp[s]++;
        }
        int ans = 0;
        for (auto it : mp) {
            ans = max(ans, it.second);
        }
        return ans;
    }
};