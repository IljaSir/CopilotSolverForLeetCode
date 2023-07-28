class Solution {
public:
    int subarraysDivByK(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<int> sum(n + 1);
        for (int i = 0; i < n; ++i) {
            sum[i + 1] = sum[i] + nums[i];
        }
        vector<int> cnt(k);
        for (int i = 0; i <= n; ++i) {
            ++cnt[(sum[i] % k + k) % k];
        }
        int ans = 0;
        for (int i = 0; i < k; ++i) {
            ans += cnt[i] * (cnt[i] - 1) / 2;
        }
        return ans;
    }
};