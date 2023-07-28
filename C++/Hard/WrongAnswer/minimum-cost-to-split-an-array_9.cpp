class Solution {
public:
    int minCost(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<vector<int>> dp(n, vector<int>(k+1, INT_MAX));
        vector<int> last(n, -1);
        for(int i = 0; i < n; i++) {
            int cnt = 0;
            for(int j = i; j >= 0; j--) {
                if(last[nums[j]] != -1) {
                    int idx = last[nums[j]];
                    for(int l = 1; l <= k; l++) {
                        if(dp[idx][l-1] != INT_MAX) {
                            dp[i][l] = min(dp[i][l], dp[idx][l-1] + cnt);
                        }
                    }
                }
                last[nums[j]] = j;
                cnt++;
            }
        }
        return dp[n-1][k];
    }
};