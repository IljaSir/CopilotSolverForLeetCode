class Solution {
public:
    int minimizeTheDifference(vector<vector<int>>& mat, int target) {
        
        int n = mat.size(), m = mat[0].size();
        vector<int> dp(800, 0);
        for (int i = 0; i < n; i++) {
            vector<int> temp(800, 0);
            for (int j = 0; j < m; j++) {
                for (int sum = 0; sum < 800; sum++) {
                    if (dp[sum] || sum == 0) {
                        temp[sum + mat[i][j]] = 1;
                        temp[abs(sum - mat[i][j])] = 1;
                    }
                }
            }
            dp = temp;
        }
        for (int i = 0; i < 800; i++) {
            if (dp[i]) return i;
        }
        return 0;
    }
};