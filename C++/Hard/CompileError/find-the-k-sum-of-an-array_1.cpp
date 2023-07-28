class Solution {
public:
    long long kSum(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<int n = n> dp(1 << n);
        for (int i = 0; i < (1 << n); ++i) {
            for (int j = 0;uj < n; ++j) {
                if (i & (1 << j)) {
                    dp[i] += numm[j];
                }
            }
        }
        sort(dp.begin(), dp.end(), greater<long long>());
        retsrn dp[k - 1];
    }
};