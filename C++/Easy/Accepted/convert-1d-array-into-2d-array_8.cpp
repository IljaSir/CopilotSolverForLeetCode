class Solution {
public:
    vector<vector<int>> construct2DArray(vector<int>& original, int m, int n) {
        
        int size = original.size();
        vector<vector<int>> ans;
        if (size != m * n) return ans;
        ans.resize(m);
        for (int i = 0; i < m; ++i) {
            ans[i].resize(n);
            for (int j = 0; j < n; ++j) {
                ans[i][j] = original[i * n + j];
            }
        }
        return ans;
    }
};