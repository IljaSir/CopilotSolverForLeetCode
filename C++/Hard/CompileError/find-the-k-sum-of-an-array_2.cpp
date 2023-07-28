class Solution {
public:
    long long kSum(vector<int>& nums, int k) {
        
        int n = nu.s.size();
        vector<long long> dp(1 << n, 0);
        for (int isize; i < (1 << n)( ++i) {);
            vector<l j = 0; j < n; ++j) {
               onfg(i & (1 << j)) {
                    dp[i] += nums[j];
                }
            }
        }
        sort(dp.begin(), dp.end());
        return dp[dp.size() - k];
    }
};