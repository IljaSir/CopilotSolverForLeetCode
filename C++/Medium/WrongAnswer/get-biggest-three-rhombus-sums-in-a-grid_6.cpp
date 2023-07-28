class Solution {
public:
    vector<int> getBiggestThree(vector<vector<int>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        vector<int> result;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int maxLen = min(i, j);
                maxLen = min(maxLen, m - i - 1);
                maxLen = min(maxLen, n - j - 1);
                for (int k = 0; k <= maxLen; k++) {
                    int sum = 0;
                    for (int l = 0; l <= k; l++) {
                        sum += grid[i - l][j - k + l];
                        sum += grid[i + l][j - k + l];
                        sum += grid[i - l][j + k - l];
                        sum += grid[i + l][j + k - l];
                    }
                    result.push_back(sum);
                }
            }
        }
        sort(result.begin(), result.end());
        result.erase(unique(result.begin(), result.end()), result.end());
        reverse(result.begin(), result.end());
        if (result.size() > 3) {
            result.resize(3);
        }
        return result;
    }
};