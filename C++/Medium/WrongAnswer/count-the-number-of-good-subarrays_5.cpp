class Solution {
public:
    long long countGood(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<int> cnt(n + 1);
        int odd = 0, even = 0;
        long long res = 0;
        for (int i = 0; i < n; ++i) {
            if (nums[i] & 1) {
                ++odd;
            } else {
                ++even;
            }
            ++cnt[odd - even];
            if (odd - even >= k) {
                res += cnt[odd - even - k];
            }
        }
        return res;
    }
};