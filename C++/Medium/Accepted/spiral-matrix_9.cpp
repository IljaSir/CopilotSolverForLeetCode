class Solution {
public:
    vector<int> spiralOrder(vector<vector<int>>& matrix) {
        
        int m = matrix.size();
        int n = matrix[0].size();
        vector<int> ans;
        int i = 0, j = 0;
        int k = 0;
        while (i < m && j < n) {
            for (k = j; k < n; k++) {
                ans.push_back(matrix[i][k]);
            }
            i++;
            for (k = i; k < m; k++) {
                ans.push_back(matrix[k][n-1]);
            }
            n--;
            if (i < m) {
                for (k = n-1; k >= j; k--) {
                    ans.push_back(matrix[m-1][k]);
                }
                m--;
            }
            if (j < n) {
                for (k = m-1; k >= i; k--) {
                    ans.push_back(matrix[k][j]);
                }
                j++;
            }
        }
        return ans;
    }
};