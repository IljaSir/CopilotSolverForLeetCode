class Solution {
public:
    int largestSubmatrix(vector<vector<int>>& matrix) {
        
        int m = matrix.size();
        int n = matrix[0].size();
        vector<int> count(n, 0);
        int res = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == 1) {
                    count[j] += 1;
                } else {
                    count[j] = 0;
                }
            }
            vector<int> temp(count);
            sort(temp.begin(), temp.end(), greater<int>());
            for (int k = 0; k < n; ++k) {
                res = max(res, temp[k] * (k + 1));
            }
        }
        return res;
    }
};