class Solution {
public:
    vector<int> spiralOrder(vector<vector<int>>& matrix) {
        
        if (matrix.size() == 0) return {};
        int m = matrix.size(), n = matrix[0].size();
        int l = 0, r = n - 1, u = 0, d = m - 1;
        vector<int> res;
        while (true) {
            for (int i = l; i <= r; ++i) res.push_back(matrix[u][i]);
            if (++u > d) break;
            for (int i = u; i <= d; ++i) res.push_back(matrix[i][r]);
            if (--r < l) break;
            for (int i = r; i >= l; --i) res.push_back(matrix[d][i]);
            if (--d < u) break;
            for (int i = d; i >= u; --i) res.push_back(matrix[i][l]);
            if (++l > r) break;
        }
        return res;
    }
};