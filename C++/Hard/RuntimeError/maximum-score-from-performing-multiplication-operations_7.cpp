class Solution {
public:
    int maximumScore(vector<int>& nums, vector<int>& multipliers) {
        
        int n = nums.size();
        int m = multipliers.size();
        vector<int> dp(m+1, INT_MIN);
        dp[0] = 0;
        for (int k = 1; k <= m; k++) {
            int mk = multipliers[k-1];
            for (int i = max(0, k-n); i <= min(k, m); i++) {
                int j = k - i;
                dp[i] = max(dp[i] + mk * nums[i], dp[i-1] + mk * nums[n-j]);
            }
        }
        return *max_element(dp.begin(), dp.end());
    }
};