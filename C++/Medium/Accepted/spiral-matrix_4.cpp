class Solution {
public:
    vector<int> spiralOrder(vector<vector<int>>& matrix) {
        
        int m = matrix.size();
        int n = matrix[0].size();
        vector<int> ans;
        int l = 0, r = n - 1, t = 0, b = m - 1;
        while (l <= r && t <= b) {
            for (int i = l; i <= r; i++) ans.push_back(matrix[t][i]);
            t++;
            for (int i = t; i <= b; i++) ans.push_back(matrix[i][r]);
            r--;
            if (l <= r && t <= b) {
                for (int i = r; i >= l; i--) ans.push_back(matrix[b][i]);
                b--;
                for (int i = b; i >= t; i--) ans.push_back(matrix[i][l]);
                l++;
            }
        }
        return ans;
    }
};