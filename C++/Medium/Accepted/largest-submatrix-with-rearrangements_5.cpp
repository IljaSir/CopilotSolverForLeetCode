class Solution {
public:
    int largestSubmatrix(vector<vector<int>>& matrix) {
        
        int m = matrix.size(), n = matrix[0].size();
        vector<int> count(n, 0);
        int ans = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j]) {
                    count[j]++;
                } else {
                    count[j] = 0;
                }
            }
            vector<int> temp(count);
            sort(temp.begin(), temp.end());
            for (int j = 0; j < n; ++j) {
                ans = max(ans, temp[j] * (n - j));
            }
        }
        return ans;
    }
};