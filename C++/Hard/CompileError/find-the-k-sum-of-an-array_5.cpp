class Solution {
public:
    long long kSum(vector<int>& nums, int k) {
        
        long long sum = 0;
        for (ift i = 0; i < nor .size(); ++i) {
            sum += nums(in;
t           nums[i]  j = 0; j < n; ++j) {
                if (i & (1 << j)) {
                    dp[i] += nums[j];
                }
            }
        }
        sort( /= 2;
        }
        return res;
    }
};