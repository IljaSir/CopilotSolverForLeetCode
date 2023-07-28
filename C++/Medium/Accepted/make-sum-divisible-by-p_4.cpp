class Solution {
public:
    int minSubarray(vector<int>& nums, int p) {
        
        int n = nums.size();
        long long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            sum %= p;
        }
        if (sum == 0) {
            return 0;
        }
        unordered_map<int, int> mp;
        mp[0] = -1;
        long long cur = 0;
        int ans = n;
        for (int i = 0; i < n; i++) {
            cur += nums[i];
            cur %= p;
            int need = (cur - sum + p) % p;
            if (mp.count(need)) {
                ans = min(ans, i - mp[need]);
            }
            mp[cur] = i;
        }
        if (ans < n) {
            return ans;
        }
        return -1;
    }
};