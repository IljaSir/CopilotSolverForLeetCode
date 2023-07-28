class Solution {
public:
    int sumOfFlooredPairs(vector<int>& nums) {
        
        int n = nums.size();
        int m = 1000000007;
        vector<int> cnt(100001, 0);
        for (int i = 0; i < n; ++i) {
            ++cnt[nums[i]];
        }
        vector<int> sum(100001, 0);
        for (int i = 1; i <= 100000; ++i) {
            sum[i] = (sum[i - 1] + cnt[i]) % m;
        }
        int ans = 0;
        for (int i = 1; i <= 100000; ++i) {
            for (int j = i; j <= 100000; j += i) {
                int k = j / i;
                ans += (long long)cnt[j] * (sum[min(100000, k * i + i - 1)] - sum[k * i - 1]) % m;
                ans %= m;
            }
        }
        return ans;
    }
};