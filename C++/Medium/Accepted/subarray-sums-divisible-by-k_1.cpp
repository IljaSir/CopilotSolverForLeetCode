class Solution {
public:
    int subarraysDivByK(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<int> sum(n + 1);
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        int ans = 0;
        unordered_map<int, int> mp;
        mp[0] = 1;
        for (int i = 1; i <= n; i++) {
            int mod = (sum[i] % k + k) % k;
            ans += mp[mod];
            mp[mod]++;
        }
        return ans;
    }
};