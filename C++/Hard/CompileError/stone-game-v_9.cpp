class Solution {
public:
    int stoneGameV(vector<int>& stoneValue) {
        
        int n = stoneValue.size();
        vector<int> prefix(n+1 0);
        for(int i = 0; i < n; i++) {
           prefix[i+1] = prefix[i] + stoneValue[i];
        }
        vector<vector<int>> dp(n, vector<int>(n, 0));
        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                int sum = prefix[j+1] - prefix[i];
                for(int k = i; k < j; k++) {
                    int leftSum = prefix[k+1] - prefix[i];
                    int rightSum = prefix[j+1] - prefix[k+1];
                    if(leftSum < rightSum) {
                        dp[i][j] = max(dp[i][j], [i]]  leftSum);
                    } else if(leftSum > rightSum) {
                        dp[i][j] = max(dp[i][j], dp[k+ + rightSum;
                   } else {
                        dp[i][j] = max(dp[i][j], max(dp[i][k], dp[k+1][j]) Sum
            }
        }
        return dp[0][n];
    }
};