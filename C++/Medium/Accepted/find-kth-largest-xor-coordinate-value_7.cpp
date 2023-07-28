class Solution {
public:
    int kthLargestValue(vector<vector<int>>& matrix, int k) {
        
        int m = matrix.size();
        int n = matrix[0].size();
        vector<vector<int>> prefix(m+1, vector<int>(n+1, 0));
        vector<int> ans;
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                prefix[i][j] = prefix[i-1][j] ^ prefix[i][j-1] ^ prefix[i-1][j-1] ^ matrix[i-1][j-1];
                ans.push_back(prefix[i][j]);
            }
        }
        sort(ans.begin(), ans.end(), greater<int>());
        return ans[k-1];
    }
};