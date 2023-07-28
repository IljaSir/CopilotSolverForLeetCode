class Solution {
public:
    int waysToReachTarget(int target, vector<vector<int>>& types) {
        
        int n = types.size();
        vector<int> dp(target+1, 0);
        dp[0] = 1;
        for (int i=0; i<n; i++) {
            for (int j=types[i][0]; j<=target; j++) {
                dp[j] = (dp[j] + dp[j-types[i][0]]) % 1000000007;
            }
        }
        return dp[target];
    }
};