class Solution {
public:
    long long maximumSubarraySum(vector<int>& nums, int k) {
        
        long long ans = 0;
        int n = nums.size();
        vector<long long> sum(n + 1, 0);
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        for (int i = 1; i <= n - k + 1; i++) {
            long long tmp = sum[i + k - 1] - sum[i - 1];
            ans = max(ans, tmp);
        }
        return ans;
    }
};