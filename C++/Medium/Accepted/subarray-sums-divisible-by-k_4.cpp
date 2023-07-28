class Solution {
public:
    int subarraysDivByK(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<int> sum(n+1);
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i-1] + nums[i-1];
        }
        unordered_map<int, int> m;
        int ans = 0;
        for (int i = 0; i <= n; i++) {
            int mod = (sum[i] % k + k) % k;
            if (m.count(mod)) {
                ans += m[mod];
            }
            m[mod]++;
        }
        return ans;
    }
};