class Solution {
public:
    int kthLargestValue(vector<vector<int>>& matrix, int k) {
        
        int m = matrix.size();
        int n = matrix[0].size();
        vector<vector<int>> xorSum(m + 1, vector<int>(n + 1, 0));
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                xorSum[i][j] = xorSum[i - 1][j] ^ xorSum[i][j - 1] ^ xorSum[i - 1][j - 1] ^ matrix[i - 1][j - 1];
            }
        }
        vector<int> ans;
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                ans.push_back(xorSum[i][j]);
            }
        }
        sort(ans.begin(), ans.end(), greater<int>());
        return ans[k - 1];
    }
};