class Solution {
public:
    bool splitArraySameAverage(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> sum(1 << n, 0);
        for (int i = 0; i < (1 << n); ++i) {
            for (int j = 0; j < n; ++j) {
                if (i & (1 << j)) {
                    sum[i] = sum[i ^ (1 << j)] + nums[j];
                }
            }
        }
        
        for (int i = 1; i < (1 << n) - 1; ++i) {
            int j = (1 << n) - 1 - i;
            if (sum[i] * n == sum[j] * __builtin_popcount(i) || sum[j] * n == sum[i] * __builtin_popcount(j)) {
                return true;
            }
        }
        
        return false;
    }
};