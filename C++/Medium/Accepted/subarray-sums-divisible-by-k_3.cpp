class Solution {
public:
    int subarraysDivByK(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<int> preSum(n + 1, 0);
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        
        unordered_map<int, int> cnt;
        cnt[0] = 1;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int sum = preSum[i + 1];
            int mod = sum % k;
            if (mod < 0) mod += k;
            ans += cnt[mod];
            cnt[mod]++;
        }
        return ans;
    }
};