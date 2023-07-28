class Solution {
public:
    int sumOfFlooredPairs(vector<int>& nums) {
        
        int n = nums.size();
        int mod = 1e9 + 7;
        vector<int> count(1e5 + 1, 0);
        for (int i = 0; i < n; i++) {
            count[nums[i]]++;
        }
        vector<int> sum(1e5 + 1, 0);
        for (int i = 1; i <= 1e5; i++) {
            sum[i] = (sum[i - 1] + count[i]) % mod;
        }
        int ans = 0;
        for (int i = 1; i <= 1e5; i++) {
            for (int j = i; j <= 1e5; j += i) {
                ans = (ans + (long long)count[i] * (sum[min(j + i - 1, 1e5)] - sum[j - 1])) % mod;
            }
        }
        return ans;
    }
};