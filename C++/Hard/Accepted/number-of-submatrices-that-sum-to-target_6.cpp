class Solution {
public:
    int numSubmatrixSumTarget(vector<vector<int>>& matrix, int target) {
        
        int rows = matrix.size();
        int cols = matrix[0].size();
        int res = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                matrix[i][j] += matrix[i][j - 1];
            }
        }
        for (int i = 0; i < cols; i++) {
            for (int j = i; j < cols; j++) {
                unordered_map<int, int> mp;
                mp[0] = 1;
                int cur = 0;
                for (int k = 0; k < rows; k++) {
                    cur += matrix[k][j] - (i > 0 ? matrix[k][i - 1] : 0);
                    res += mp[cur - target];
                    mp[cur]++;
                }
            }
        }
        return res;
    }
};