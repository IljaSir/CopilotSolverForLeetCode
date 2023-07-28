class Solution {
public:
    int maxEqualRowsAfterFlips(vector<vector<int>>& matrix) {
        
        int m = matrix.size();
        int n = matrix[0].size();
        unordered_map<string, int> mp;
        for (int i = 0; i < m; i++) {
            string s1 = "";
            string s2 = "";
            for (int j = 0; j < n; j++) {
                if (matrix[i][j]) {
                    s1 += "1";
                    s2 += "0";
                } else {
                    s1 += "0";
                    s2 += "1";
                }
            }
            mp[s1]++;
            mp[s2]++;
        }
        int ans = 0;
        for (auto it = mp.begin(); it != mp.end(); it++) {
            ans = max(ans, it->second);
        }
        return ans;
    }
};