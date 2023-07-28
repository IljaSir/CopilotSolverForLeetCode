class Solution {
public:
    long long maximumSubarraySum(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<int> cnt(1e5+1);
        long long sum = 0, res = 0;
        for (int i = 0; i < n; ++i) {
            if (i >= k) {
                --cnt[nums[i-k]];
                sum -= cnt[nums[i-k]] > 0 ? 0 : nums[i-k];
            }
            ++cnt[nums[i]];
            sum += cnt[nums[i]] > 1 ? 0 : nums[i];
            if (i >= k-1) res = max(res, sum);
        }
        return res;
    }
};