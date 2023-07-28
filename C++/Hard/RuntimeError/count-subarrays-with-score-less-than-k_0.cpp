class Solution {
public:
    long long countSubarrays(vector<int>& nums, long long k) {
        
        int n = nums.size();
        vector<long long> sum(n + 1, 0);
        for (int i = 0; i < n; ++i) {
            sum[i + 1] = sum[i] + nums[i];
        }
        long long res = 0;
        int l = 0, r = 0;
        for (int i = 0; i < n; ++i) {
            while (l < n && sum[l + 1] - sum[i] < k) {
                ++l;
            }
            if (sum[l + 1] - sum[i] >= k) {
                --l;
            }
            r = max(r, i);
            while (r < n && sum[r + 1] - sum[i] <= k) {
                ++r;
            }
            if (sum[r + 1] - sum[i] > k) {
                --r;
            }
            res += r - l;
        }
        return res;
    }
};